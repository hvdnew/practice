package chk;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private final List<Integer> _stack;
    private final List<Integer> minStack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        _stack = new ArrayList<>(10);
        minStack = new ArrayList<>(10);
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        int _min = x < min ? x : min;
        min = _min;

        minStack.add(min);
        _stack.add(x);
    }

    public void pop() {

        _stack.remove(_stack.size() - 1);

        minStack.remove(minStack.size() - 1);
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.get(minStack.size() - 1);

    }

    public int top() {

        return _stack.get(_stack.size() - 1);
    }

    public int getMin() {

        return min;
    }
}
