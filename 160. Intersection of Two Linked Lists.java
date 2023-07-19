public class Solution {
 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 ListNode pointerA = headA;
 ListNode pointerB = headB;

 while (pointerA != pointerB) {
 // Move pointerA to the next node in listA
 if (pointerA == null)
 pointerA = headB;
 else
 pointerA = pointerA.next;

 // Move pointerB to the next node in listB
 if (pointerB == null)
 pointerB = headA;
 else
 pointerB = pointerB.next;
 }

 return pointerA; // Return the intersecting node or null
 }
}
