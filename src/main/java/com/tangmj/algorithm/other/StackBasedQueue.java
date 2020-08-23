package com.tangmj.algorithm.other;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tangmingjian
 * 队列(单向)模拟栈
 **/
public class StackBasedQueue<T> {
    //1,2,3,4依次入栈

    //入->4->3->2->1->出
    private Queue<T> queue;
    //queue的数据转到helper中
    //入->3->2->1->出
    private Queue<T> helper;
    //取出queue中最后一个，queue和helper互换

    public StackBasedQueue() {
        queue = new LinkedBlockingQueue<>();
        helper = new LinkedBlockingQueue<>();
    }

    public void push(T t) {
        queue.offer(t);
    }

    public T pop() {
        while (queue.size() > 1) {
            helper.add(queue.poll());
        }
        T t = queue.poll();
        Queue<T> tmp = queue;
        queue = helper;
        helper = tmp;
        return t;
    }
    public T peek() {
        while (queue.size() > 1) {
            helper.offer(queue.poll());
        }
        T ans = queue.poll();
        helper.offer(ans);
        Queue<T> tmp = queue;
        queue = helper;
        helper = tmp;
        return ans;
    }

    public static void main(String[] args) {
        StackBasedQueue<Integer> stack = new StackBasedQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());



    }
}
