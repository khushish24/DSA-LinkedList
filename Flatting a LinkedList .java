class ListNode {
 int val;
 ListNode next;
 ListNode child;
 ListNode(int val) {
 this.val = val;
 this.next = null;
 this.child = null;
 }
}
public class solution {
 public ListNode flatten(ListNode head) {
 if (head == null) {
 return null;
 }
 ListNode current = head;
 while (current != null) {
 if (current.child != null) {
 // Save the reference to the next node in the main list
 ListNode next = current.next;
 // Flatten the child linked list
ListNode flattenedChild = flatten(current.child);
 // Connect the flattened child to the current node
current.next = flattenedChild;
 current.child = null;
 // Find the tail of the flattened child linked list
 ListNode tail = flattenedChild;
while (tail.next != null) {
 tail = tail.next;
 }
 // Connect the tail to the next node in the main list
 tail.next = next;
 }
 current = current.next;
 }
 return head;
 }
 public static void main(String[] args) {
 // Create a sample linked list with nested structure
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 head.next.child = new ListNode(4);
 head.next.child.next = new ListNode(5);
 head.next.next.child = new ListNode(6);
 // Flatten the linked list
 solution solution = new solution();
 ListNode flattenedList = solution.flatten(head);
 // Print the elements of the flattened list
 ListNode current = flattenedList;
 while (current != null) {
 System.out.print(current.val + " ");
 current = current.next;
 }
 System.out.println();
 }
}
