import java.util.HashMap;
import java.util.Map;
class Node {
 int val;
 Node next;
 Node random;
 Node(int val) {
 this.val = val;
 this.next = null;
 this.random = null;
 }
}
public class solution {
 public Node cloneLinkedList(Node head) {
 if (head == null) {
 return null;
 }
 Map<Node, Node> nodeMap = new HashMap<>();
 Node current = head;
 // Create new nodes and store the mapping
 while (current != null) {
 Node newNode = new Node(current.val);
 nodeMap.put(current, newNode);
 current = current.next;
 }
 // Set the next and random pointers of the new nodes
 current = head;
 while (current != null) {
 Node clonedNode = nodeMap.get(current);
 clonedNode.next = nodeMap.get(current.next);
 clonedNode.random = nodeMap.get(current.random);
 current = current.next;
 }
 return nodeMap.get(head);
 }
 public static void main(String[] args) {
 // Create a sample linked list with random pointers
 Node head = new Node(1);
 Node node2 = new Node(2);
 Node node3 = new Node(3);
 head.next = node2;
 head.random = node3;
 node2.next = node3;
 node2.random = head;
 node3.random = node2;
 // Clone the linked list
 solution solution = new solution();
 Node clonedHead = solution.cloneLinkedList(head);
 // Print the original linked list and its random pointers
 System.out.println("Original Linked List:");
 solution.printLinkedList(head);
 // Print the cloned linked list and its random pointers
 System.out.println("Cloned Linked List:");
 solution.printLinkedList(clonedHead);
 }
 // Utility method to print the linked list and its random pointers
 private void printLinkedList(Node head) {
 Node current = head;
 while (current != null) {
 String randomValue = (current.random != null) ?
String.valueOf(current.random.val) : "null";
 System.out.println("Node: " + current.val + ", Random: " +
randomValue);
 current = current.next;
 }
 }
}
