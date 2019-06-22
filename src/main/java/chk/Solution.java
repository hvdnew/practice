package chk;

class Solution {

    public static void main(String... arg) {

        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
    }

    public int reverse(int x) {

        if (x == 0) return 0;

        StringBuffer sb = new StringBuffer(String.valueOf(x));

        String string = sb.reverse().toString();

        string = handleNegativeNumber(string);

        return Integer.parseInt(string);
    }

    private String handleNegativeNumber(String string) {
        if (string.endsWith("-")) {
            StringBuffer sb = new StringBuffer("-");
            sb.append(string.substring(0, string.length() - 1));
            return sb.toString();
        } else {
            return string;
        }


    }
}