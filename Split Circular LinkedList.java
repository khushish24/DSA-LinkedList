class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 this.next = null;
 }
}
public class solution {
 public ListNode[] splitCircularLinkedList(ListNode head) {
 if (head == null || head.next == null) {
 return new ListNode[]{head, null};
 }
 ListNode slow = head;
 ListNode fast = head;
 // Find the midpoint of the circular linked list
 while (fast.next != head && fast.next.next != head) {
 slow = slow.next;
 fast = fast.next.next;
 }
 // Set the next pointer of the second half to the head
 ListNode head2 = slow.next;
 slow.next = head;
 // Connect the end of the first half to the head
 fast.next = head2;
 // Return the heads of the two split linked lists
 ListNode[] result = new ListNode[]{head, head2};
 return result;
 }
 public static void main(String[] args) {
 // Create a circular linked list
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 head.next.next.next = new ListNode(4);
 head.next.next.next.next = head; // Make it circular
 // Split the circular linked list into two lists
 solution solution = new solution();
 ListNode[] result = solution.splitCircularLinkedList(head);
 // Print the elements of list1
 ListNode list1 = result[0];
 System.out.print("List 1: ");
 printList(list1);
 // Print the elements of list2
 ListNode list2 = result[1];
 System.out.print("List 2: ");
 printList(list2);
 }
 // Utility method to print the elements of a linked list
 private static void printList(ListNode head) {
 if (head == null) {
 System.out.println("Empty List");
 return;
 }
 ListNode current = head;
 while (current.next != head) {
 System.out.print(current.val + " ");
 current = current.next;
 }
 System.out.println(current.val); // Print the last node
 }
}
