using System;
using System.Collections.Generic;

namespace Receiver
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> CaptureListOfInputfromSender = new List<string>();

            for (int i = 0; i < 50; i++)
                CaptureListOfInputfromSender.Add(Console.ReadLine());

            List<BmsContainer> containers = SenderStatistics.ComputeBmsStatistics(CaptureListOfInputfromSender);
            Utilites.PrintStatisticsValue(containers);
        }
    }
}
