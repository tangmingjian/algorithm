package com.tangmj.algorithm.stack;

import java.util.Stack;

/**
 * @author tangmingjian 2020-08-21 10:08 PM
 * 栈(FILO)模拟队列(FIFO)
 **/
public class QueueBasedStack<T> {
    private Stack<T> pollStack;
    private Stack<T> pushStack;
    private int size;

    public QueueBasedStack() {
        pollStack = new Stack<>();
        pushStack = new Stack<>();
        size = 0;
    }

    public void add(T t) {
        pushStack.push(t);
        pushToPoll();
        size++;
    }


    public T poll() {
        if (pushStack.isEmpty() && pollStack.isEmpty()) {
            throw new RuntimeException("没有数据！");
        }
        pushToPoll();
        T t = pollStack.pop();
        size--;
        return t;
    }

    public T peek() {
        if (pushStack.isEmpty() && pollStack.isEmpty()) {
            throw new RuntimeException("没有数据！");
        }
        pushToPoll();
        return pollStack.peek();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void pushToPoll() {
        if (pollStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                pollStack.push(pushStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueBasedStack<Integer> queue = new QueueBasedStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);


        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

}
