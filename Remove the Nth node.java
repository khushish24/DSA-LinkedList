class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 }
}
public class solution {
 public static ListNode removeNthFromEnd(ListNode head, int n) {
 ListNode dummy = new ListNode(0);
 dummy.next = head;
 ListNode slow = dummy;
 ListNode fast = dummy;
 // Move the fast pointer 'n+1' nodes ahead
 for (int i = 0; i <= n; i++) {
 fast = fast.next;
 }
 while (fast != null) {
 slow = slow.next;
 fast = fast.next;
 }
 slow.next = slow.next.next;
 return dummy.next;
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
 int n = 2; // Remove the 2nd node from the end
 ListNode newHead = removeNthFromEnd(head, n);
 // Print the updated LinkedList
 ListNode current = newHead;
 while (current != null) {
 System.out.print(current.val + " ");
 current = current.next;
 }
 }
}
