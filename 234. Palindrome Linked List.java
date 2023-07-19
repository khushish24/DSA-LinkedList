class Solution {
 public boolean isPalindrome(ListNode head) {
 List<Integer> values = new ArrayList<>();

 ListNode current = head;
 while (current != null) {
 values.add(current.val);
 current = current.next;
 }

 int start = 0;
 int end = values.size() - 1;
 while (start < end) {
 if (!values.get(start).equals(values.get(end))) {
 return false;
 }
 start++;
 end--;
 }

 return true;
 }
}
