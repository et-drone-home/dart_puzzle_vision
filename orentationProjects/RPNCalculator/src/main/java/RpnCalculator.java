public class RpnCalculator {
    public static int calculate(String expression) {
        String[] symbols;

        if(expression.endsWith("+"))
        {
            symbols = expression.split(" ");
            return Integer.valueOf(symbols[0]) + Integer.valueOf(symbols[1]);
        }
        else if(expression.endsWith("-"))
        {
            symbols = expression.split(" ");
            return Integer.valueOf(symbols[0]) - Integer.valueOf(symbols[1]);
        }
        else if(expression.endsWith("/"))
        {
            symbols = expression.split(" ");
            return Integer.valueOf(symbols[0]) / Integer.valueOf(symbols[1]);
        }
        else if(expression.endsWith("*"))
        {
            symbols = expression.split(" ");
            return Integer.valueOf(symbols[0]) * Integer.valueOf(symbols[1]);
        }

        return Integer.valueOf(expression);
    }
}
