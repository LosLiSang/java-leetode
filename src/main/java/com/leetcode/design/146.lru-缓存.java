package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    private Map<Integer, Node> map = new HashMap<Integer, Node>();

    private int capacity;

    private Node head = new Node(), tail = new Node();

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void moveHead(Node cur) {
        // 断开链接
        Node pre = cur.prev;
        Node nex = cur.next;
        pre.next = nex;
        nex.prev = pre;
        // 添加新连接
        Node headNext = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = headNext;
        headNext.prev = cur;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.tail.prev = this.head;
        this.head.next = this.tail;

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        moveHead(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node itr = map.get(key);
            itr.value = value;
            moveHead(itr);
            return;
        }
        // 插入
        Node cur = new Node(key, value);
        Node headNext = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = headNext;
        headNext.prev = cur;
        map.put(key, cur);
        // 删除
        if (map.size() == capacity + 1) {
            cur = map.remove(tail.prev.key);
            Node tailPrev = cur.prev;
            tailPrev.next = tail;
            tail.prev = tailPrev;
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
