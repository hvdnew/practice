package chk;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {

        StringBuffer sb = new StringBuffer();

        for (char ch: s.toCharArray()){

            // ignore if non alpha numeric
            if (Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }

        }

        return isPalindromeIn(sb.toString().toLowerCase().toCharArray());
    }

    private boolean isPalindromeIn(char[] arr) {
        if (arr.length < 2) {
            return true;
        }

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            if(arr[start] == arr[end]){
                start++; end--;
            } else {
                return false;
            }

        }


        return true;
    }

}
