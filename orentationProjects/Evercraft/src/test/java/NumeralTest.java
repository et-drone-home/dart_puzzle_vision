import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumeralTest {

    private Integer passingValue = 0;
    LinkedHashMap<String,Integer> setToAdd = new LinkedHashMap<>();

    @Before
    public void setup(){
        setToAdd.put("I",1);
        setToAdd.put("II",2);
        setToAdd.put("IV",4);
        setToAdd.put("V",5);
        setToAdd.put("VI",6);
    }

    @Test
    public void testOneInit(){
        TestInit test = new TestInit(0,"");
        int testValue = test.numeralAddition();
        assertEquals(1, testValue);
    }

    @Test
    public void testRomanNumeralOneConvertsToIntegerOne(){
        StringBuilder sb = new StringBuilder();
        TestInit test = new TestInit(passingValue,sb.toString());
        assertEquals(0, test.addIntoNumeral(null));
    }

    @Test
    public void testRomanCalcOnShellWithoutNumbers(){
        StringBuilder sb = new StringBuilder();
        List<String> setupValuesFromMethod = Arrays.asList(
                "I",
                "II",
                "IV",
                "V",
                "VI");
        TestInit test = new TestInit(passingValue,sb.toString());
        assertEquals(setupValuesFromMethod.size() % 4, test.addIntoNumeral(setToAdd));
        int setupValue = setupValuesFromMethod.size();
        assertEquals(setupValue, test.helper());

    }


}
