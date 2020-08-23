package com.tangmj.algorithm.stack;

import java.util.Stack;

/**
 * @author tangmingjian
 * O(1)内获取栈内最小值
 **/
public class GetMinStack2<T extends Comparable> {
    private final Stack<T> dataStack;//数据栈
    private final Stack<T> minStack;//最小栈

    public GetMinStack2() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }


    public T push(T item) {
        if (isEmpty()) {
            minStack.push(item);
        } else if (item.compareTo(min()) <= 0) {
            minStack.push(item);
        }
        dataStack.push(item);
        return item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈内没数据了！");
        }
        T item = dataStack.pop();
        if (item.equals(min())) {
            minStack.pop();
        }
        return item;
    }

    public T min() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("栈内没数据了！");
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }


    public static void main(String[] args) {
        GetMinStack2<Integer> stack = new GetMinStack2<>();
        stack.push(2);
        stack.push(2);
        System.out.println(stack.min());

        System.out.println(stack.pop());
        System.out.println(stack.min());

        stack.push(5);
        System.out.println(stack.min());
        System.out.println(stack.pop());

    }
}
