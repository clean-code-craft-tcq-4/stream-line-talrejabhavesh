package SenderPart;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sender{
  

// converts bit readings to ampere 
  public static List<Integer> convert12BitToAmps(List<Integer> bitReadings) {
    List<Integer> ampReadings = new ArrayList<>();
    for (Integer reading : bitReadings) {
      float f = 10 * (float) reading / 4094;
      ampReadings.add(Math.round(f));
    }
    return ampReadings;
  }
  
  
  // converts temperature sensor readings to celcius
  public static List<Integer>  convertFarenheitToCelcius(List<Integer> farenheitReadings) {
    List<Integer> celciusReadings = new ArrayList<>();
    for (Integer reading : farenheitReadings) {
      float f = (float)(reading-32)*(float)(5.0/9.0);
      celciusReadings.add(Math.round(f));
    }
    return celciusReadings;
  }
  
  // creates a single map to merge temperature and current sensor readings
  public static  Map<Integer,List<Integer>>  createSingleReadingsMap(List<Integer> ampereReadings,List<Integer> temperatureReadings,int noOfReadings) {
    Map<Integer,List<Integer>> readingsMap=new HashMap<>(); 
    for(int i=0;i<noOfReadings;i++) {
      List<Integer> readingsList = new ArrayList<>();
      readingsList.add(ampereReadings.get(i));
      readingsList.add(temperatureReadings.get(i));    
      readingsMap.put(i, readingsList);
    }
    return readingsMap;
  }
  
  
  public static void printReadingToConsole( Map<Integer,List<Integer>> finalReadings) {
    for (Map.Entry reading : finalReadings.entrySet()) {
      System.out.println(reading.getValue());     
    }
  }
  
  
  public static List<Integer> generateCurrentReadings(int noOfReadings) {
    List<Integer> bitReadings = new ArrayList<>();
    int firstReading=50;
    for(int i=0;i<noOfReadings;i++) {
      bitReadings.add(firstReading);
      firstReading+=100;
    }
    return bitReadings;
  }
  
  public static List<Integer> generateTemperatureReadings(int noOfReadings) {
    List<Integer> farenheitReadings = new ArrayList<>();
    int firstReading=32;
    for(int i=0;i<noOfReadings;i++) {
      farenheitReadings.add(firstReading);
      firstReading+=5;
    }
    return farenheitReadings;
  }
  
  public static void main(String[] args) {
    
    List<Integer> bitReadings=generateCurrentReadings(50);
    List<Integer> ampereReadings=convert12BitToAmps(bitReadings);
    
    List<Integer> farenheitReadings= generateTemperatureReadings(50);
    List<Integer> temperatureReadings=convertFarenheitToCelcius(farenheitReadings);
    
    Map<Integer,List<Integer>> finalReadings=createSingleReadingsMap(ampereReadings,temperatureReadings,50);
    
    printReadingToConsole(finalReadings);
    
  }
  

  
}
