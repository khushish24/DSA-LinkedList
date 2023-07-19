class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 this.next = null;
 }
}
public class solution {
 public ListNode swapPairs(ListNode head) {
 // Create a dummy node and set its next to the head of the list
 ListNode dummy = new ListNode(0);
 dummy.next = head;
 // Set the current node to the dummy node
 ListNode current = dummy;
 // Iterate until there are at least two nodes left
 while (current.next != null && current.next.next != null) {
 // Get references to the two nodes to be swapped
 ListNode first = current.next;
 ListNode second = current.next.next;
 // Perform the swap by adjusting the pointers
 first.next = second.next;
 second.next = first;
 current.next = second;
 // Move the current node to the next pair of nodes
 current = current.next.next;
 }
 // Return the head of the modified list
 return dummy.next;
 }
 public static void main(String[] args) {
 // Create a sample linked list
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 head.next.next.next = new ListNode(4);
 // Swap pairs in the linked list
 solution solution = new solution();
 ListNode swappedList = solution.swapPairs(head);
 // Print the elements of the swapped list
 ListNode current = swappedList;
 while (current != null) {
 System.out.print(current.val + " ");
 current = current.next;
 }
 System.out.println();
 }
}
