package pl.camp.it.szyfr.cezara;

import java.util.HashMap;
import java.util.Map;

public class Cezar {

    private static Map<Integer, Character> polishCharacters  = new HashMap<Integer, Character>() {{
        put(123, '1');
        put(124, '2');
        put(125, '3');
        put(126, '4');
        put(127, '5');
        put(128, '6');
        put(129, '7');
        put(130, '8');
        put(131, '9');
    }};
    public static String encode(String text, int key) {
        char[] chars = text.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            /*int ascii = chars[i];
            ascii += key;
            if(ascii > 122) {
                ascii = ascii - 123 + 97;
            }

            if(ascii < 97) {
                ascii = ascii - 96 + 122;
            }

            chars[i] = (char) ascii;*/

            if(chars[i] == ' ') {
                continue;
            }


            int ascii = chars[i];
            if(ascii > 122 || ascii < 97) {
                for(Map.Entry<Integer, Character> entry : polishCharacters.entrySet()) {
                    if(entry.getValue() == chars[i]) {
                        ascii = entry.getKey();
                    }
                }
            }
            ascii = (ascii - 97 + key) % 35;
            if(ascii >= 0) {
                ascii += 97;
            } else {
                ascii += 132;
            }

            if(ascii < 123) {
                chars[i] = (char) ascii;
            } else {
                chars[i] = polishCharacters.get(ascii);
            }
        }

        return String.valueOf(chars);
    }

    public static String decode(String text, int key) {
        return encode(text, -key);
    }
}
