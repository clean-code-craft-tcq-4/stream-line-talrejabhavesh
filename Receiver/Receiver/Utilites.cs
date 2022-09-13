using System;
using System.Collections.Generic;
using System.Linq;

namespace Receiver
{
    public class Utilites
    {
        public static void PrintStatisticsValue(List<BmsContainer> valuesToPrint)
        {
            Console.WriteLine("Minimum Amps value: {0},  Maximum Apms value: {1}", valuesToPrint.Min(x => x.Amps), valuesToPrint.Max(x => x.Amps));
            Console.WriteLine("Minimum temperature value: {0},  Maximum temperature value: {1}", valuesToPrint.Min(x => x.temperature), valuesToPrint.Max(x => x.temperature));
            Console.WriteLine("Simple moving Average of last 5 values for Apms: {0} and temperature: {1}", valuesToPrint.Select(x => x.Amps).TakeLast(5).Sum(x => x) / 5, valuesToPrint.Select(x => x.temperature).TakeLast(5).Sum(x => x) / 5);
        }
    }
}
