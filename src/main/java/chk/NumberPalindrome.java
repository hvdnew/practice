package chk;

public class NumberPalindrome {

    public static void main(String[] args) {

        System.out.println(new NumberPalindrome().isPalindrome(214783647));

    }

    public boolean isPalindrome(int num) {
        if (num < 0) return false;
        int reversed = 0, remainder, original = num;
        while (num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num /= 10;  //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    }

    public boolean isPalindrome1(int x) {

        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int self = x;
        StringBuffer sb = new StringBuffer();

        while (x > 0) {

            sb.append(x % 10);
            x = x / 10;

        }

        int rev = Integer.valueOf(sb.toString());

        return self == rev;
    }
}
