package Sender;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;


public class SenderTest{

 @Test 
 public static void testConvertRanges12bit() {
    List<Integer> bitReadings= Arrays.asList(409,820,1228);
    assertTrue(Sender.convert12BitToAmps(bitReadings).equals(Arrays.asList(1,2,3)));

  }

 
 @Test 
 public static void testConvertFarenheitToCelcius() {
    List<Integer> celciusReadings= Arrays.asList(113,86,77);
    assertTrue(Sender.convertFarenheitToCelcius(celciusReadings).equals(Arrays.asList(45,30,25)));
  }
  
  @Test 
  public static void testCreateSingleReadingsMap() {
    List<Integer> bitReadings= Arrays.asList(409,820,1228);
    List<Integer> celciusReadings= Arrays.asList(113,86,77);
    assertTrue(Sender.createSingleReadingsMap(bitReadings, celciusReadings, 3).get(0).equals(Arrays.asList(409,113)));
  }
  
  @Test 
  public static void testGenerateCurrentReadings() {
    assertTrue(Sender.generateCurrentReadings(5).size()==5);
  }
  
  @Test 
  public static void testGenerateTemperatureReadings() {
    assertTrue(Sender.generateTemperatureReadings(5).size()==5);
  }

}
