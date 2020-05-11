import java.util.HashMap;

/**
 * this class is LRU implementation of LRU using doubly linklist
 * list is used to keep data in order from most recently to least recently
 * If data is find in cache by get operation it will be added to head.
 * data is removed from the last if total data increased the capaciy
 */
public class LRUCache<K,V> {
    private Node<K,V> tail;
    private Node<K,V> head;
    private HashMap<K, Node<K,V>> map;
    private int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    /**
     * This method is used to get the value based on key
     * if the value exist in the cache ,and the node is not the head node
     * if will delete the node and add again at the first place
     *
     * @param key based on which the value will be reterieved
     * @return value if exist else null
     */
    public V get(K key) {
        if (map.get(key) == null) {
            return null;
        }

        //move to head
        Node<K,V> t = map.get(key);

        removeNode(t);
        offerNode(t);

        return t.value;
    }

    /**
     * This method is used to put the data in the Cache.
     * if capacity is reach ,the it will delete the Least recently
     * used data and add this at the head of the double linklist
     *
     * @param key   key of the data
     * @param value value of the data
     */

    public void  put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K,V> t = map.get(key);
            t.value = value;

            //move to head
            removeNode(t);
            offerNode(t);
        } else {
            if (map.size() >= cap) {
                //delete head
                map.remove(tail.key);
                removeNode(tail);
            }

            //add to head
            Node node = new Node(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    /**
     * This method is used to remove the node from the last
     *
     * @param n
     */
    private void removeNode(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            tail = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            head = n.prev;
        }
    }

    /**
     * This methid is put the node at the first place
     *
     * @param n node
     */
    private void offerNode(Node n) {
        if (head != null) {
            head.next = n;
        }

        n.prev = head;
        n.next = null;
        head = n;

        if (tail == null) {
            tail = head;
        }
    }

    public static void main(String[] args) {
        LRUCache<String,String> cache = new LRUCache<>(5);

        cache.put("1","A");
        cache.put("2","B");
        cache.put("3","C");
        cache.put("4","D");
        cache.put("5","E");
        cache.put("6","F");
        cache.put("7","G");
        cache.put("8","H");

        System.out.println(cache.get("2"));
    }
}

/**
 * This class is used to have the structure of data that will be inserted
 * in  doubly Linklist
 */
class Node<K,V> {
    Node prev;
    Node next;
    V value;
    K key;

    public  Node(K key, V value) {
        this.key = key;
        this.value = value;
    }




}





