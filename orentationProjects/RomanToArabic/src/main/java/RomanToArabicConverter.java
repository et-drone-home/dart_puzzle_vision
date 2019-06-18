
public class RomanToArabicConverter {
  public int convertToInteger(String romanNumeral) {
    int total = 0;
    String[] individualNumerals = romanNumeral.split("");

    for (int i = 0; i < romanNumeral.length(); i++) {
      if(individualNumerals[i].equals("M")) {
        total += 1000;
      }
      if(individualNumerals[i].equals("D")) {
        total += 500;
      }
      if(individualNumerals[i].equals("C")) {
        if(shouldSubtractOneHundred(individualNumerals, i)) {
          total -= 100;
        }else {
          total += 100;
        }
      }
      if(individualNumerals[i].equals("L")) {
        total += 50;
      }
      if(individualNumerals[i].equals("X")) {
        if(shouldSubtractTen(individualNumerals, i)) {
          total -= 10;
        }else {
          total += 10;
        }
      }
      if(individualNumerals[i].equals("V")) {
        total += 5;
      }
      if(individualNumerals[i].equals("I")) {
        if(shouldSubtractOne(individualNumerals, i)) {
          total -= 1;
        }else {
          total += 1;
        }
      }
    }
    return total;
  }

  private boolean shouldSubtractOneHundred(String[] individualNumerals, int i) {
    return individualNumerals.length > (i + 1) && (individualNumerals[i + 1].equals("D") || individualNumerals[i + 1].equals("M"));
  }

  private boolean shouldSubtractTen(String[] individualNumerals, int i) {
    return individualNumerals.length > (i + 1) && (individualNumerals[i + 1].equals("L") || individualNumerals[i + 1].equals("C"));
  }

  private boolean shouldSubtractOne(String[] individualNumerals, int i) {
    return individualNumerals.length > (i + 1) && (individualNumerals[i + 1].equals("V") || individualNumerals[i + 1].equals("X"));
  }

}
