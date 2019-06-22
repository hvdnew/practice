package chk;

import java.util.HashSet;

/**
 * <p>Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Input: String="araaci", K=2
 * Output: 4
 * Input: String="araaci", K=1
 * Output: 2
 * Input: String="cbbebi", K=3
 * Output: 5
 * </p>
 */
public class LongestSubstrWithKDistinctChars {

    public static void main(String[] args) {

        System.out.println(new LongestSubstrWithKDistinctChars().longestSubstrWithKDistinct("araaci", 2));
        System.out.println(new LongestSubstrWithKDistinctChars().longestSubstrWithKDistinct("araaci", 1));
        System.out.println(new LongestSubstrWithKDistinctChars().longestSubstrWithKDistinct("cbbebi", 3));

    }

    public int longestSubstrWithKDistinct(String str, int count) {

        char[] charArr = str.toCharArray();

        int windowStart = 0;
        int maxLength = 0;

        HashSet<Character> distinct = new HashSet<>(count);

        for (int i = 0; i < charArr.length; ) {
            char ch = charArr[i];
            distinct.add(Character.valueOf(ch));

            // breach, reset window
            if (distinct.size() > count) {
                maxLength = Math.max((i - windowStart), maxLength);
                windowStart++;
                distinct = new HashSet<>(count);
            } else {
                i++;
            }
        }

        return maxLength;
    }

}
