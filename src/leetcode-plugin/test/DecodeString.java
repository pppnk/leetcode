import java.util.*;
//If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings.
//
//For example:
//Input: "1123". You need to general all valid alphabet codes from this string.
//
//Output List
//aabc //a = 1, a = 1, b = 2, c = 3
//kbc // since k is 11, b = 2, c= 3
//alc // a = 1, l = 12, c = 3
//aaw // a= 1, a =1, w= 23
//kw // k = 11, w = 23
public class DecodeString {

    public Set<String> decode(String code) {
        Set<String> result = new HashSet<String>();
        helper("", code, result);
        return result;
    }


    public void helper(String prefix, String code, Set<String> result) {

        int len = code.length();
        if (len == 0) {
            result.add(prefix);
            return;
        }
        if (code.charAt(0) == '0')
            return;

        helper(prefix + (char)(code.charAt(0) - '1' + 'a'), code.substring(1), result);

        if (len >= 2) {
            int value = Integer.parseInt(code.substring(0, 2));
            if (value <= 26)
                helper(prefix + (char)(value - 1 +'a'), code.substring(2), result);
        }
    }

    public static void main(String[]args){
        DecodeString decoder = new DecodeString();
        Set<String> answer = decoder.decode("1123");
        for(String entry:answer){
            System.out.println(entry);
        }
    }
}
