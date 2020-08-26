package com.tangmj.algorithm.str;

import java.util.Arrays;

/**
 * @author tangmingjian
 * 字符串前缀树
 **/
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode(null);
    }

    public void insert(String str) {
        if (str == null) return;
        char[] chars = str.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode(""+chars[i]);
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }


    public int search(String str) {
        if (str == null) return 0;
        char[] chars = str.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }


    public int prefixNum(String str) {
        if (str == null) return 0;
        char[] chars = str.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public void delete(String str) {
        if (str == null) return;
        if (search(str) == 0) return;
        //存在再删除
        TrieNode node = root;
        node.pass--;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (--node.nexts[index].pass == 0) {
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    class TrieNode {
        //经过该节点的个数
        private int pass;
        //以该节点结尾的个数
        private int end;
        //后续节点
        private TrieNode[] nexts;

        private String curr;

        public TrieNode(String curr) {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
            this.curr = curr;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    ", curr='" + curr + '\'' +
                    ", pass=" + pass +
                    ", end=" + end +
                    ", nexts=" + Arrays.toString(nexts) +

                    '}';
        }
    }


    public static void main(String[] args) {
        TrieTree test = new TrieTree();
        test.insert("abc");
        test.insert("abcd");

        System.out.println(test.prefixNum("a")==2);

        System.out.println(test.prefixNum("abc")==2);

        System.out.println(test.prefixNum("abb")==0);

        System.out.println(test.search("abc"));

        System.out.println(test.root);
        test.delete("abc");
        System.out.println(test.root);

        System.out.println(test.search("abcd"));

        System.out.println(test.root);
        test.delete("abcd");
        System.out.println(test.root);


        System.out.println(test.search("abcd"));

    }
}
