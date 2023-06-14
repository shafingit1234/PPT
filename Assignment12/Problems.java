package Assignment12;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Delete middle node from the linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		};

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode Question1(ListNode head) {
		if (head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode temp = head;
		while (temp.next != slow) {
			temp = temp.next;
		}
		if (temp.next == slow) {
			temp.next = slow.next;
		}
		slow.next = null;
		slow = null;
		return head;
	}

	/*
	 * Question 2 Detect a linked list cycle.
	 */
	public static boolean Question2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Question 3 Remove Nth Node from End of List
	 */
	public static ListNode Question3(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		int cnt = 1;
		while (cnt <= n && fast != null) {
			fast = fast.next;
			cnt++;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		ListNode temp = slow.next;
		slow.next = slow.next.next;
		temp.next = null;

		return head;
	}

	/*
	 * Question 4 Given a singly linked list of characters, write a function that
	 * returns true if the given list is a palindrome, else false.
	 */
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
		}
		return prev;
	}

	public static boolean Question4(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode temp = reverse(head);
		while (temp != null && head != null) {
			if (temp.val != head.val) {
				return false;
			}
			temp = temp.next;
			head = head.next;
		}
		return true;
	}

	/*
	 * Question 5 Detect and remove the loop from the linked list
	 */
	public static void Question5(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			return;
		}
		fast = head;
		if (slow == head) {
			while (slow.next != head) {
				slow = slow.next;
			}
			slow.next = null;
			return;
		} else {
			while (fast.next != slow.next) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = null;
		}
		return;
	}

	/*
	 * Question 6 Given a linked list and two integers M and N. Traverse the linked
	 * list such that you retain M nodes then delete next N nodes, continue the same
	 * till end of the linked list.
	 * 
	 */
	public static void Question6(ListNode head, int M, int N) {
		// your code here
		int cnt = 0;
		ListNode temp = head;
		while (temp != null) {
			cnt++;
			if (cnt == M) {
				cnt = 0;
				ListNode temp_two = temp;
				while (cnt < N && temp != null) {
					temp = temp.next;
					cnt++;
				}
				if (temp == null) {
					temp_two.next = null;
					return;
				}
				temp_two.next = temp.next;
				cnt = 0;
				temp = temp_two.next;
			} else {
				temp = temp.next;
			}
			// temp = temp.next;
		}
	}
	/*
	 * Question 7
	 * 
	 * Merge Second Linked list elements alternatively in first linkedlist.
	 */
	void merge(ListNode q , ListNode head)
    {
        ListNode p_curr = head, q_curr = head;
        ListNode p_next, q_next;
  
        // While there are available positions in p;
        while (p_curr != null && q_curr != null) {
  
            // Save next pointers
            p_next = p_curr.next;
            q_next = q_curr.next;
  
            // make q_curr as next of p_curr
            q_curr.next = p_next; // change next pointer of q_curr
            p_curr.next = q_curr; // change next pointer of p_curr
  
            // update current pointers for next iteration
            p_curr = p_next;
            q_curr = q_next;
        }
        head = q_curr;
    }
	/*
	 * Question 8 Check if Linked list is circular
	 */
	public static boolean Question8(ListNode head) {
		// An empty linked list is circular
		if (head == null)
			return true;

		// Next of head
		ListNode node = head.next;

		// This loop would stop in both cases (1) If
		// Circular (2) Not circular
		while (node != null && node != head)
			node = node.next;

		// If loop stopped because of circular
		// condition
		return (node == head);
	}

}
