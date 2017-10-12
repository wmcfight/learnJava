package arabic;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.io.Resources;

/**
 *
 */
public class ArabicCharacterUtils {
    private static Map<Character, String> ARABIC_TO_LATIN;
    public static Map<String, String> ARABIC_WORD_TO_LATIN;
    static {
        ARABIC_TO_LATIN = new HashMap<Character, String>() {
            {
                put('ا', "a");
                put('أ', "a");
                put('آ', "a");
                put('إ', "e");
                put('ب', "b");
                put('ت', "t");
                put('ث', "th");
                put('ج', "j");
                put('ح', "h");
                put('خ', "kh");
                put('د', "d");
                put('ذ', "d");
                put('ر', "r");
                put('ز', "z");
                put('س', "s");
                put('ش', "sh");
                put('ص', "s");
                put('ض', "d");
                put('ط', "t");
                put('ظ', "z");
                put('ع', "'e");
                put('غ', "gh");
                put('ف', "f");
                put('ق', "q");
                put('ك', "k");
                put('ل', "l");
                put('م', "m");
                put('ن', "n");
                put('ه', "h");
                put('و', "w");
                put('ي', "y");
                put('ى', "a");
                put('ئ', "'e");
                put('ء', "'");
                put('ؤ', "'e");
                put('ة', "h");
                put('؟', "?");
                put('ـ', "");
                put('،', ",");
                put('ٌ', "un");
                put('ً', "an");
                put('ٍ', "en");
                put('ّ', "");
                put('\n', "\n");
                put('٩', "9");
                put('٨', "8");
                put('٧', "7");
                put('٦', "6");
                put('٥', "5");
                put('٤', "4");
                put('٣', "3");
                put('٢', "2");
                put('١', "1");
                put('٠', "0");
                put('٪', "%");
                put('ذ', "th");
                put('ع', "a'");
                put('و', "o");
                put('ي', "ye");
                put('ء', "'");
                put('ؤ', "'e");
                put('!', "!");
                put('ُ', "u");
                put('ڤ', "v");
            }
        };

        ARABIC_WORD_TO_LATIN = new LinkedHashMap<>();
    }



    public static String convertCharToLatin(char data) {
        String result =  ArabicCharacterUtils.ARABIC_TO_LATIN.get(data);
        if (result == null) {
            if (data >= 0x0600 && data <= 0x06FF) {
                result = "?";
                System.out.println("use ??");
            } else {
                result = String.valueOf(data);
            }
        }
        return result;
    }

    public static boolean isArabicCharInMap(char data) {
        return ArabicCharacterUtils.ARABIC_TO_LATIN.containsKey(data);
    }

    private static  String removeSpecialChar(String data) {
        String result = data;
        result = StringUtils.remove(result, '(');
        result = StringUtils.remove(result, ')');
        return result;
    }



}
