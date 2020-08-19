package leetcode;

/*  824. Goat Latin */

/*  https://leetcode.com/problems/goat-latin/   */

/*
*
* A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150
*
* */

public class GoatLatin {
    public String toGoatLatin(String S) {
        if(S == null || S.isEmpty()) {
            return "";
        }

        StringBuffer out = new StringBuffer();
        StringBuffer aa = new StringBuffer();
        String[] split = S.split("\\s+");


        for(String ss : split) {
            aa.append("a");
            if(ss.charAt(0) == 'a' || ss.charAt(0) == 'A' ||
                    ss.charAt(0) == 'e' || ss.charAt(0) == 'E' ||
                    ss.charAt(0) == 'i' || ss.charAt(0) == 'I' ||
                    ss.charAt(0) == 'o' || ss.charAt(0) == 'O' ||
                    ss.charAt(0) == 'u' || ss.charAt(0) == 'U') {
                out.append(ss);
            } else {
                out.append(ss.substring(1, ss.length())).append(Character.toString(ss.charAt(0)));
            }
            out.append("ma").append(aa.toString()).append(" ");
        }

        return out.toString().trim();
    }
}
