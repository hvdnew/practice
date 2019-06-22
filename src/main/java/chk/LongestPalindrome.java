package chk;

import java.util.HashSet;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("aaaabbaa"));
    }

    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        Boolean[][] results = new Boolean[s.length()][s.length()];
        fillDiagonal(results);
        // i, j == if i-1, j-1 = true and i==j then true
        char[] charArr = s.toCharArray();

        HashSet<String> palindromes = new HashSet<>();

        String longestPalindrome = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {

                Boolean mem = results[i][j];
                if(mem != null && Boolean.TRUE == mem){

                    int length = i-j;
                    //maxLength =

                }

                String str = s.substring(i, j);

                if (str.length() == 1) {
                    longestPalindrome = addPalindromeAndGetLongest(palindromes, longestPalindrome, str);
                    continue;
                }

                if (palindromes.contains(str) || isFuzzyPalindrome(str, palindromes)) {
                    continue;
                }
                if (isPlaindrome(str)) {
                    longestPalindrome = addPalindromeAndGetLongest(palindromes, longestPalindrome, str);
                }
            }
        }

        return longestPalindrome;
    }

    private void fillDiagonal(Boolean[][] results) {
        for (int i = 0; i < results.length; i++) {
            results[i][i] = Boolean.TRUE;
        }
    }

    private String addPalindromeAndGetLongest(HashSet<String> palindromes, String longestPalindrome, String str) {
        palindromes.add(str);
        longestPalindrome = str.length() > longestPalindrome.length() ? str : longestPalindrome;
        return longestPalindrome;
    }

    private boolean isFuzzyPalindrome(String str, HashSet<String> palindromes) {
        String _ch = str.charAt(0) + "";
        if (str.startsWith(_ch) && str.endsWith(_ch)) {
            String slice = str.substring(1, str.length() - 1);
            return palindromes.contains(slice);
        }
        return false;
    }

    private boolean isPlaindrome(String str) {

        System.out.println(String.format("computing for %s", str));

        if (str.length() == 1) {
            return true;
        }
        int start = 0, end = str.length() - 1;
        boolean isPalindrome = true;
        while (start < end && start < str.length() && end >= 0) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}
