using System;
using System.Collections.Generic;

namespace Receiver
{
    public class SenderStatistics
    {
        public static List<BmsContainer> ComputeBmsStatistics(List<string> lstofInputfromSender)
        {
            List<BmsContainer> containers = new List<BmsContainer>();
            foreach (string Senderinput in lstofInputfromSender)
            {
                string[] splitdata = Senderinput.Split(',');
                BmsContainer container = new BmsContainer();
                container.Amps = Convert.ToInt32(splitdata[0].Trim('['));
                container.temperature = Convert.ToInt32(splitdata[1].Trim(']'));
                containers.Add(container);
            }
            return containers;
        }
    }
    public class BmsContainer
    {
        public int Amps;
        public int temperature;
    }
}
