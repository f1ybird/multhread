package programtest.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * @Author: zhangkai
 * @Date: 2020/5/25 23:37
 */
public class LRUCacheOfLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheOfLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheOfLinkedHashMap cache = new LRUCacheOfLinkedHashMap(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}