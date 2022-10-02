import java.util.HashMap;

public class Number {
    public Integer value;

    private static final HashMap<String, Integer> toRoman = new HashMap<>(){{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};


    private static final HashMap<Integer, String> toRomanOne = new HashMap<>(){{
        put(0, "");
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
    }};

    private static final HashMap<Integer, String> toRomanTwo = new HashMap<>(){{
        put(1, "X");
        put(2, "XX");
        put(3, "XXX");
        put(4, "XL");
        put(5, "L");
        put(6, "LX");
        put(7, "LXX");
        put(8, "LXXX");
        put(9, "XC");
    }};

    Number(){
        value = 0;
    }
    Number(String s){
        if (IsArabic(s)) {
            value = Integer.parseInt(s);
        } else {
            value = ConvertFromRoman(s);
        }
    }

    public static boolean IsArabic(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int ConvertFromRoman(String s) {
        return toRoman.get(s);
    }

    public String toRoman(){
        if (value == 100) return "C";
        if (value<10) return toRomanOne.get(value);
        return toRomanTwo.get(value/10)+toRomanOne.get(value%10);
    }

}
