package chk;

import java.util.ArrayList;
import java.util.List;

public class MaxParenthesesCombination {

    // TODO: solve!
    public static void main(String[] args) {
        /*[
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
        ]*/
        System.out.println(new MaxParenthesesCombination().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("We cannot make a valid expression for the input " + n);
        }

        List<String> output = new ArrayList<>();


        return output;
    }
}
