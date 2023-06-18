package Test_1;

import java.util.Scanner;

public class Question_Add_Two_numbers_Test2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public static Scanner sc= new Scanner(System.in);
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while(ptr1 != null && ptr2!=null)
        {
            int sum = ptr1.val + ptr2.val + carry;
            int dig = sum%10;
            carry = sum/10;
            tail.next = new ListNode(dig);
            tail = tail.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr1 != null){
            int sum = ptr1.val + carry;
            int dig =sum%10;
            carry = sum/10;
            tail.next = new ListNode(dig);
            tail = tail.next;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null)
        {
            int sum = ptr2.val + carry;
            int dig =sum%10;
            carry = sum/10;
            tail.next = new ListNode(dig);
            tail = tail.next;
            ptr2 = ptr2.next;
        }
        if(carry != 0)
        {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return dummy.next;
    }
	public static ListNode createList(int n) {
		ListNode head = new ListNode();
		ListNode temp = head;
		while(n > 0) {
			n--;
			temp.next = new ListNode(sc.nextInt());
			temp = temp.next;
		}
		return head.next;
	}
	public static void main(String[] args) {
		System.out.println("Enter size of list 1");
		int n1 = sc.nextInt();
		System.out.println("Enter size of list 2");
		int n2 = sc.nextInt();
		System.out.println("Enter elements for list 1");
		ListNode list1 = createList(n1);
		System.out.println("Enter elements for list 2");
		ListNode list2 = createList(n2);
		ListNode result = addTwoNumbers(list1, list2);
		System.out.println("Required Answer:");
		while(result!=null) {
			System.out.print(result.val + " ");
			result =result.next;
		}
		System.out.println();
	}
}
