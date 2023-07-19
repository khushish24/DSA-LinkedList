class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 this.next = null;
 }
}
public class solution {
 public ListNode[] splitLinkedList(ListNode head) {
 ListNode list1 = null;
 ListNode list2 = null;
 ListNode current1 = null;
 ListNode current2 = null;
 ListNode current = head;
 boolean isList1 = true;
 while (current != null) {
 if (isList1) {
 if (list1 == null) {
 list1 = new ListNode(current.val);
 current1 = list1;
 } else {
 current1.next = new ListNode(current.val);
 current1 = current1.next;
 }
 } else {
 if (list2 == null) {
 list2 = new ListNode(current.val);
 current2 = list2;
 } else {
 current2.next = new ListNode(current.val);
 current2 = current2.next;
 }
 }
 current = current.next;
 isList1 = !isList1;
 }
 if (current1 != null) {
 current1.next = null;
 }
 if (current2 != null) {
 current2.next = null;
 }
 ListNode[] result = new ListNode[2];
 result[0] = list1;
 result[1] = list2;
 return result;
 }
 public static void main(String[] args) {
 // Create a sample linked list
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 head.next.next.next = new ListNode(4);
 head.next.next.next.next = new ListNode(5);
 // Split the linked list into two lists
 solution solution = new solution();
 ListNode[] result = solution.splitLinkedList(head);
 // Print the elements of list1
 ListNode list1 = result[0];
 System.out.print("List 1: ");
 while (list1 != null) {
 System.out.print(list1.val + " ");
 list1 = list1.next;
 }
 System.out.println();
 // Print the elements of list2
 ListNode list2 = result[1];
 System.out.print("List 2: ");
 while (list2 != null) {
 System.out.print(list2.val + " ");
 list2 = list2.next;
 }
 System.out.println();
 }
}
