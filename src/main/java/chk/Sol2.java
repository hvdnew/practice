package chk;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Sol2 {

    public static void main(String[] args) {

        Sol2 so = new Sol2();

        System.out.println(so.lengthOfLongestSubstring("aa"));

    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        Set<String> uniqueStrings = new HashSet<>(s.length());
        IntStream.range(0, s.length() - 1)
                .forEach(idx -> {
                    uniqueStrings.add(getUniqeCharSubStr(s, idx));
                });

        return uniqueStrings.stream()
                .filter(Objects::nonNull)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private String getUniqeCharSubStr(String str, int idx) {

        String subStr = str.substring(idx);

        Set<Character> _chSet = new HashSet<>(subStr.length());

        StringBuffer sb = new StringBuffer();
        char[] arr = subStr.toCharArray();

        for (int i = 0; i < subStr.length(); i++) {
            char _ch = arr[i];
            if (_chSet.contains(_ch)) {
                return sb.toString();
            }
            _chSet.add(_ch);
            sb.append(_ch + "");
        }
        return sb.toString();
    }


}
