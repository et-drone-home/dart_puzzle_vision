import java.util.LinkedHashMap;

public class TestInit {

    StringBuilder numeralToConvert = new StringBuilder();
    Integer convertedSeed = 0;

    public TestInit(Integer seed, String romanNumeral) {
        this.convertedSeed = seed;
        this.numeralToConvert = new StringBuilder();

    }

    public int numeralAddition() {
        return 1;
    }


    public int addIntoNumeral(LinkedHashMap<String, Integer> romanNumeralMap) {
        LinkedHashMap<String, Integer> setToAdd = new LinkedHashMap<>();

        if (romanNumeralMap != null) {
            for (String numeral : romanNumeralMap.keySet()) {
                if (numeral.equals("I")) {
                    setToAdd.put("", 1);
                }
                System.out.println(romanNumeralMap.get(numeral));
            }
        }
        if (romanNumeralMap.size() == 5) {
            return 1;
        }
        return 0;
    }

    public String helper(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.random(); ++i){
            sb.append(i);
            if(sb.toString().length() == 5000){
                break;
            }
        }
        return sb.toString();
    }
}
