package chk;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses vp = new ValidParentheses();

        System.out.println(vp.isValid("{[]}"));

    }

    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        Map<Character, Character> openClose = new HashMap<>(3);
        openClose.put('(', ')');
        openClose.put('{', '}');
        openClose.put('[', ']');


        Stack<Character> chars = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!chars.empty()) {
                Character top = chars.peek();
                Character closing = openClose.get(top);
                // get latest and pop it if the current char is closing it
                if (closing != null && closing.equals(ch)) {
                    chars.pop();
                    continue;
                }
            }


            // other wise add it to the stack
            chars.push(ch);


        }


        // is the stack is empty here, then it is a valid expression
        return chars.empty();
    }

}
