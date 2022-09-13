using NUnit.Framework;
using System.Collections.Generic;
using System.Linq;

namespace Receiver.TestProject
{
    public class ReceiverUnitTest
    {

        public List<string> CaptureListOfInputfromSender;

        [SetUp]
        public void Setup()
        {
            CaptureListOfInputfromSender = PrepareTestdata();
        }
        public static List<string> PrepareTestdata()
        {
            List<string> CaptureListOfInputfromSender = new List<string>();
            CaptureListOfInputfromSender.Add("[0,0]");
            CaptureListOfInputfromSender.Add("[0,3]");
            CaptureListOfInputfromSender.Add("[1,2]");
            CaptureListOfInputfromSender.Add("[5,6]");
            CaptureListOfInputfromSender.Add("[3,1]");
            return CaptureListOfInputfromSender;
        }
        [Test]
        public void CheckBmsParameterCompatibility()
        {
            List<BmsContainer> containers = SenderStatistics.ComputeBmsStatistics(CaptureListOfInputfromSender);

            Assert.AreEqual(containers.Select(x => x.Amps).Last(), 3);
            Assert.AreEqual(containers.Select(x => x.temperature).Last(), 1);
        }

        [Test]
        public void CheckBmsParameterSMAStatistics()
        {
            List<BmsContainer> containers = SenderStatistics.ComputeBmsStatistics(CaptureListOfInputfromSender);

            Assert.AreEqual(containers.Select(x => x.Amps).TakeLast(5).Sum(x => x) / 5, 1);
            Assert.AreEqual(containers.Select(x => x.temperature).TakeLast(5).Sum(x => x) / 5, 2);
        }
    }
}