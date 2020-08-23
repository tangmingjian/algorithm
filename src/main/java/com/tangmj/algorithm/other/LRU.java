package com.tangmj.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmingjian
 * LRU: 一种缓存淘汰算法，在缓存放满的情况下淘汰很久都没有使用的数据，给新数据腾空间
 * 特点:
 * 1. 有序(数组、链表)
 * 2. 查找快(hash表)
 * 3. 删除插入快(链表)
 * ==> hash表+链表
 **/
public class LRU<K, V> {
    private Map<K, Node<K, V>> map;
    private DoubleLinkedList<K, V> cache;
    private int cap;

    public LRU(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleLinkedList<>();
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        //提升为最新使用的数据
        makeRecent(node.key);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            return;
        }
        if (cache.size == cap) {
            cache.removeFirst();
        }
        addRecent(key, value);
    }


    private void makeRecent(K key) {
        Node<K, V> node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecent(K key, V value) {
        Node<K, V> x = new Node<>(key, value);
        //添加在尾部
        cache.addLast(x);
        map.put(key, x);
    }


    class DoubleLinkedList<K, V> {
        private Node<K, V> head, tail;
        private int size;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }


        public Node<K, V> removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public void remove(Node<K, V> x) {
            //head <-> 1 <-> 2 <-> 3 <-> tail
            //head <-> 1 <-> 2 <-> tail
            x.pre.next = x.next;
            x.next.pre = x.pre;
            x = null;
            size--;
        }

        public void addLast(Node<K, V> x) {
            //head <-> 1 <-> 2 <-> 3 <-> tail
            //head <-> 1 <-> 2 <-> 3 <-> x <-> tail
            tail.pre.next = x;
            x.pre = tail.pre;
            x.next = tail;
            tail.pre = x;
            size++;
        }

    }

    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> pre, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    @Override
    public String toString() {
        DoubleLinkedList<K, V> cache = this.cache;
        StringBuilder sb = new StringBuilder();
        if (cache.head.next == cache.tail) {
            sb.append("[]");
            return sb.toString();
        }
        Node<K, V> curr = cache.head.next;
        while (curr != null && curr != cache.tail) {
            sb.append("[").append(curr.key).append(":").append(curr.value).append("]");
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRU<String, String> lru = new LRU<>(3);
        lru.addRecent("tang", "001");
        lru.addRecent("ming", "002");
        lru.addRecent("jian", "003");
        System.out.println(lru);
        String tang = lru.get("tang");
        System.out.println(tang);
        System.out.println(lru);

        lru.put("tangtang","aaaa");
        System.out.println(lru);

    }
}
