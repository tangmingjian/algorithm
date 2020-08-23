package com.tangmj.algorithm.array;

/**
 * @author tangmingjian
 * 环状数组
 **/
public class RingArray<T> {
    private Object[] data;
    private int pollIndex;//读下标
    private int pushIndex;//写下标
    private int size;
    private int cap;

    public RingArray(int cap) {
        data = new Object[cap];
        this.size = 0;
        this.pollIndex = 0;
        this.pushIndex = 0;
        this.cap = cap;

    }

    public void push(T t) {
        if (size == cap) throw new RuntimeException("满了，不能再加了！");
        data[pushIndex] = t;
        size++;
        pushIndex = nextIndex(pushIndex);

    }

    public T poll() {
        if (size == 0) throw new RuntimeException("没数据，不能再取了！");
        T t = (T) data[pollIndex];
        size--;
        pollIndex = nextIndex(pollIndex);
        return t;
    }

    private int nextIndex(int currIndex) {
//        return currIndex < cap - 1 ? currIndex + 1 : 0;
        return (currIndex ^ (cap - 1)) == 0 ? 0 : currIndex + 1;
    }


    public static void main(String[] args) {
        RingArray<Integer> array = new RingArray(5);
        int index = 0;
        array.push(++index);
        array.push(++index);
        array.push(++index);
        array.push(++index);
        array.push(++index);
        while (true) {
//            Integer poll = array.poll();
//            System.out.println(poll);
            array.push(++index);
        }
    }
}
