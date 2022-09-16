using System;
using System.Collections.Generic;

namespace Receiver
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> CaptureListOfInputfromSender = new List<string>();

            try
            {
                for (int IterateConsoleReadings = 0; IterateConsoleReadings < 50; IterateConsoleReadings++)
                {
                    CaptureListOfInputfromSender.Add(Convert.ToString(Console.ReadLine()));
                }

                List<BmsContainer> BmsParameterContainer = SenderStatistics.ComputeBmsStatistics(CaptureListOfInputfromSender);
                Utilites.PrintStatisticsValue(BmsParameterContainer);
            }
            catch (NullReferenceException)
            {
                throw new Exception("Data passed from Sender is Invalid!");
            }
        }
    }
}
