import java.util.HashMap;
import java.util.Map;
class LRUCache {
 class Node {
 int key;
 int value;
 Node prev;
 Node next;
 public Node(int key, int value) {
 this.key = key;
 this.value = value;
 }
 }
 private int capacity;
 private Map<Integer, Node> cacheMap;
 private Node head;
 private Node tail;
 public LRUCache(int capacity) {
 this.capacity = capacity;
 this.cacheMap = new HashMap<>();
 this.head = new Node(-1, -1);
 this.tail = new Node(-1, -1);
 head.next = tail;
 tail.prev = head;
 }
 public int get(int key) {
 if (cacheMap.containsKey(key)) {
 Node node = cacheMap.get(key);
 moveToHead(node);
 return node.value;
 }
 return -1;
 }
 public void put(int key, int value) {
 if (cacheMap.containsKey(key)) {
 Node node = cacheMap.get(key);
 node.value = value;
 moveToHead(node);
 } else {
 Node newNode = new Node(key, value);
 cacheMap.put(key, newNode);
 addToHead(newNode);
 if (cacheMap.size() > capacity) {
 Node removedNode = removeTail();
 cacheMap.remove(removedNode.key);
 }
 }
 }
 private void moveToHead(Node node) {
 removeNode(node);
 addToHead(node);
 }
 private void addToHead(Node node) {
 node.next = head.next;
 node.prev = head;
 head.next.prev = node;
 head.next = node;
 }
 private void removeNode(Node node) {
 node.prev.next = node.next;
 node.next.prev = node.prev;
 }
 private Node removeTail() {
 Node removedNode = tail.prev;
 removeNode(removedNode);
 return removedNode;
 }
}
public class solution {
 public static void main(String[] args) {
 LRUCache cache = new LRUCache(2);
 cache.put(1, 1);
 cache.put(2, 2);
 System.out.println(cache.get(1)); // Output: 1
 cache.put(3, 3);
 System.out.println(cache.get(2)); // Output: -1
 cache.put(4, 4);
 System.out.println(cache.get(1)); // Output: -1
 System.out.println(cache.get(3)); // Output: 3
 System.out.println(cache.get(4)); // Output: 4
 }
}
