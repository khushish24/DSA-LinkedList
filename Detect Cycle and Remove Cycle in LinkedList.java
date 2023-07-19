class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 }
}
public class solution {
 public static boolean hasCycle(ListNode head) {
 ListNode tortoise = head;
 ListNode hare = head;
 while (hare != null && hare.next != null) {
 tortoise = tortoise.next;
 hare = hare.next.next;
 if (tortoise == hare) {
 return true; // Cycle detected
 }
 }
 return false; // No cycle detected
 }
public static void removeCycle(ListNode head) {
 ListNode tortoise = head;
 ListNode hare = head;
 ListNode cycleStartNode = null;
 // Find the meeting point of the tortoise and hare (if cycle
exists)
 while (hare != null && hare.next != null) {
 tortoise = tortoise.next;
 hare = hare.next.next;
 if (tortoise == hare) {
 cycleStartNode = tortoise;
break;
 }
 }
 if (cycleStartNode != null) {
 // Move one pointer to the head and another pointer from the
cycle start node,
 // both with the same pace. The point where they meet will be
the start of the cycle.
 ListNode ptr1 = head;
 ListNode ptr2 = cycleStartNode;
 while (ptr1 != ptr2) {
 ptr1 = ptr1.next;
ptr2 = ptr2.next;
 }
 // Find the last node of the cycle
 while (ptr2.next != ptr1) {
 ptr2 = ptr2.next;
 }
 // Remove the cycle by setting the next pointer of the last
node of the cycle to null
 ptr2.next = null;
 }
 }
 public static void main(String[] args) {
 // Create a sample LinkedList with a cycle
 ListNode head = new ListNode(1);
 ListNode second = new ListNode(2);
 ListNode third = new ListNode(3);
 ListNode fourth = new ListNode(4);
 ListNode fifth = new ListNode(5);
 head.next = second;
 second.next = third;
 third.next = fourth;
 fourth.next = fifth;
 fifth.next = third; // Cycle created: 5 -> 3
 boolean hasCycle = hasCycle(head);
 System.out.println("Has Cycle: " + hasCycle);
 if (hasCycle) {
 removeCycle(head);
 System.out.println("Cycle removed.");
 }
 hasCycle = hasCycle(head);
 System.out.println("Has Cycle after removal: " + hasCycle);
 }
}
