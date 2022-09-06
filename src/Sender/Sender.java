Package Sender;


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
  
  
  public static void main(String[] args) {
    
    List<Integer> bitReadings= Arrays.asList(409,820,1228);
    List<Integer> ampereReadings=convert12BitToAmps(bitReadings);
    
    List<Integer> celciusReadings= Arrays.asList(113,86,77);
    List<Integer> temperatureReadings=convertFarenheitToCelcius(celciusReadings);
    
    Map<Integer,List<Integer>> finalReadings=createSingleReadingsMap(ampereReadings,temperatureReadings,3);
    
    printReadingToConsole(finalReadings);
    
  }
  
}
