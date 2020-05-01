package lru;

import lombok.Data;

import java.util.HashMap;

/**
 * this class is LRU implementation of LRU using doubly linklist
 * list is used to keep data in order from most recently to least recently
 * If data is find in cache by get operation it will be added to head.
 * data is removed from the last if total data increased the capaciy
 */
public class LRUCache {
    Node head;
    Node tail;
    HashMap<String, Node> map;
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");

        System.out.println(lruCache.get("4"));
    }

    public String get(String key) {
        if (map.get(key) == null) {
            return null;
        }

        //move to tail
        Node t = map.get(key);

        removeNode(t);
        offerNode(t);

        return t.value;
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;

            //move to tail
            removeNode(t);
            offerNode(t);
        } else {
            if (map.size() >= cap) {
                //delete head
                map.remove(head.key);
                removeNode(head);
            }

            //add to tail
            Node node = new Node(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }

    private void offerNode(Node n) {
        if (tail != null) {
            tail.next = n;
        }

        n.prev = tail;
        n.next = null;
        tail = n;

        if (head == null) {
            head = tail;
        }
    }
}

@Data
class Node {
    Node prev;
    Node next;
    String value;
    String key;

    public Node(String data, String key) {
        this.value = data;
        this.key = key;
    }

}





