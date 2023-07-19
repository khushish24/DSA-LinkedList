class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
 this.val = val;
 }
}
public class solution {
 public static ListNode findMiddleElement(ListNode head) {
 ListNode slowPointer = head;
 ListNode fastPointer = head;
 while (fastPointer != null && fastPointer.next != null) {
 slowPointer = slowPointer.next;
 fastPointer = fastPointer.next.next;
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
 ListNode middleElement = findMiddleElement(head);
 System.out.println("Middle element: " + middleElement.val);
 }
}
