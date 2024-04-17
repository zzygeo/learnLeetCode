package hashTable;

import java.util.Arrays;

/**
 * @Author zzy
 * @Description 判断是否是字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {

    }

    public static boolean test(String s, String t) {
       int[] record = new int[26];
       for (int i = 0; i < s.length(); i++) {
           record[s.charAt(i) - 'a']++;
       };
       for (int i = 0; i < t.length(); i++) {
           record[t.charAt(i) - 'a']--;
       }
       return Arrays.equals(record, new int[26]);
    }
}
