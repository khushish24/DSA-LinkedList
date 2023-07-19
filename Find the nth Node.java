class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 }
}
public class solution {
 public static ListNode findNthNodeFromEnd(ListNode head, int n) {
 ListNode fastPointer = head;
 ListNode slowPointer = head;
 // Move the fast pointer 'n' nodes ahead
 for (int i = 0; i < n; i++) {
 if (fastPointer == null) {
 throw new IllegalArgumentException("The LinkedList
does not have " + n + " nodes.");
 }
 fastPointer = fastPointer.next;
 }
 // Move both pointers simultaneously until the fast pointer
reaches the end
 while (fastPointer != null) {
 fastPointer = fastPointer.next;
 slowPointer = slowPointer.next;
 }
 return slowPointer;
 }
 public static void main(String[] args) {
 // Create a sample LinkedList
 ListNode head = new ListNode(1);
 ListNode second = new ListNode(2);
 ListNode third = new ListNode(3);
 ListNode fourth = new ListNode(4);
 ListNode fifth = new ListNode(5);
 head.next = second;
 second.next = third;
 third.next = fourth;
 fourth.next = fifth;
 int n = 2; // Find the 2nd node from the end
 try {
 ListNode nthNodeFromEnd = findNthNodeFromEnd(head, n);
 System.out.println("The " + n + "th node from the end: "
+ nthNodeFromEnd.val);
 } catch (IllegalArgumentException e) {
 System.out.println(e.getMessage());
 }
 }
}
