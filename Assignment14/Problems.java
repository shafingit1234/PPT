package Assignment14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Detect and remove cycle in linked list.
	 */
	public static class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}

	public static void Question1(Node head) {
		// code here
		// remove the loop without losing any nodes
		Node fast = head;
		Node slow = head;
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
	 * Question 2 Add 1 to a linked list
	 */
	public static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head;
		Node prev = null;
		Node nex = curr.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = nex;
			if (curr == null) {
				break;
			}
			nex = nex.next;
		}
		return prev;
	}

	public static Node addOne(Node head) {
		// code here.
		// first reverse the list
		Node temp = reverse(head);
		if (temp == null) {
			return temp;
		}
		// after reversing add 1.
		Node ans = temp;

		// temp = ans;
		int carry = 0;
		int dig = temp.data;
		int sum = dig + 1;
		carry = sum / 10;
		dig = sum % 10;
		temp.data = dig;
		Node prev = temp;
		temp = temp.next;
		// Node prev = null;
		while (temp != null) {
			// prev = temp;
			dig = temp.data;
			if (carry != 0) {
				dig += carry;
				carry = dig / 10;
				dig = dig % 10;
				temp.data = dig;
			} else if (carry == 0) {
				break;
			}
			if (temp.next == null) {
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		if (carry != 0 && temp != null) {
			temp.next = new Node(carry);
		} else if (carry != 0 && temp == null) {
			prev.next = new Node(carry);
		}
		return reverse(ans);
	}

	/*
	 * Question 3 Flatten a linked list
	 */
	public static Node Question3(Node root) {
		// Your code here
		ArrayList<Node> al = new ArrayList<Node>();
		Node ans = root;
		while (root != null) {
			al.add(root);
			Node temp = root.next;
			root.next = null;
			root = temp;
		}

		Node list1 = al.get(0);
		// print(list1);
		for (int i = 1; i < al.size(); i++) {
			Node list2 = al.get(i);
			// print(list2);
			list1 = MergeList(list1, list2);
			// print(list1);
			// Print(flattenSingleList(list1));
		}
		// list1 = flattenSingleList(list1);
		return list1;
	}

	public static Node MergeList(Node list1, Node list2) {
		Node temp_1 = list1;
		Node temp_2 = list2;
		Node dummy = new Node(-1);
		Node t = dummy;
		while (temp_1 != null && temp_2 != null) {
			if (temp_1.data == temp_2.data) {
				dummy.bottom = temp_1;
				temp_1 = temp_1.bottom;
				// temp_2 = temp_2.bottom;
			} else if (temp_1.data > temp_2.data) {
				dummy.bottom = temp_2;
				temp_2 = temp_2.bottom;
			} else {
				dummy.bottom = temp_1;
				temp_1 = temp_1.bottom;
			}
			dummy = dummy.bottom;
		}
		while (temp_1 != null) {
			dummy.bottom = temp_1;
			temp_1 = temp_1.bottom;
			dummy = dummy.bottom;
		}
		while (temp_2 != null) {
			dummy.bottom = temp_2;
			temp_2 = temp_2.bottom;
			dummy = dummy.bottom;
		}
		return t.bottom;
	}

	public static Node flattenSingleList(Node list) {
		Node dummy = new Node(-1);
		Node t = dummy;
		while (list != null) {
			dummy.next = list;
			Node temp = list;
			list = list.bottom;
			temp.bottom = null;
			dummy = dummy.next;
		}
		return t.next;
	}

	public static void Print(Node ls) {
		while (ls != null) {
			System.out.print(ls.data + " ");
			ls = ls.next;
		}
	}

	public static void print(Node ls) {
		while (ls != null) {
			System.out.print(ls.data + " ");
			ls = ls.bottom;
		}
		System.out.println();
	}

	/*
	 * Question 4 You are given a special linked list with N nodes where each node
	 * has a next pointer pointing to its next node. You are also given M random
	 * pointers, where you will be given M number of pairs denoting two
	 * nodes a and b  i.e. a->arb = b (arb is pointer to random node).
	 */

	// Definition for a Node.
	public class Node_two {
		int val;
		Node_two next;
		Node_two random;

		public Node_two(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node_two copyRandomList(Node_two head) {
		if (head == null) {
			return null;
		}
		Node_two temp_two = new Node_two(-1);
		Node_two temp_two_head = temp_two;
		// Node temp_two = new Node(head.val);
		Queue<Node_two> q = new LinkedList<>();
		Node_two temp_one = head;
		while (temp_one != null) {
			q.add(temp_one);
			temp_two.next = new Node_two(temp_one.val);
			temp_two = temp_two.next;
			temp_two.random = temp_one;
			Node_two t = temp_one.next;
			temp_one.next = temp_two;
			temp_one = t;
		}
		temp_two = temp_two_head.next;
		while (temp_two != null) {
			Node_two check = temp_two.random;
			if (check == null) {
				temp_two = temp_two.next;
				continue;
			}
			Node_two check_random = check.random;
			// Node check_random = null;
			// if(check != null){
			// check_random = check.random;
			// }
			if (check_random == null) {
				temp_two.random = null;
			} else {
				temp_two.random = check_random.next;
			}

			temp_two = temp_two.next;
		}
		Node_two start = q.poll();
		while (q.isEmpty() == false) {
			start.next = q.poll();
			start = start.next;
		}
		start.next = null;
		return temp_two_head.next;
	}

	/*
	 * Question 5
	 * 
	 * Odd Even Linked List
	 * 
	 */
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

	public static ListNode Question5(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyOdd = new ListNode(-1);
		ListNode dummyEve = new ListNode(-1);
		ListNode tailOdd = dummyOdd;
		ListNode tailEven = dummyEve;
		ListNode ptr = head;
		while (ptr != null) {
			ListNode temp = ptr.next;
			tailOdd.next = ptr;
			tailOdd = tailOdd.next;
			tailOdd.next = null;

			if (temp != null)
				ptr = temp.next;
			else
				break;
			tailEven.next = temp;
			tailEven = tailEven.next;
			tailEven.next = null;
		}
		tailOdd.next = dummyEve.next;
		return dummyOdd.next;
	}
	/*
	 * Question 6
	 * Left shift the linked list
	 */
	public Node rotate(Node head, int k)
    {
        if (k == 0) return head;
        
        Node walk = head;
        Node prev = null;
        
        while( k-->0 && walk!=null )
        {
            prev = walk;
            walk = walk.next;
        }
        if(walk==null) return head; 
        
        Node newHead = walk;
        prev.next = null;
        
        while( walk.next != null )
            walk = walk.next;
        
        walk.next = head;
        
        return newHead;
    }
	/*
	 * Question 7 Next Greater Node in Linked Lists
	 */
	public int count(ListNode head) {
		ListNode ptr = head;
		int ans = 0;
		while (ptr != null) {
			ans++;
			ptr = ptr.next;
		}
		return ans;
	}

	class pair {
		int val;
		int idx;

		pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

	public int[] nextLargerNodes(ListNode head) {
		Stack<pair> st = new Stack<>();
		ListNode ptr = head;
		int[] res = new int[count(head)];
		int idx = 0;
		while (ptr != null) {
			if (st.isEmpty() == true) {
				st.push(new pair(ptr.val, idx++));
				ptr = ptr.next;
				continue;
			} else {
				while (st.isEmpty() == false && st.peek().val < ptr.val) {
					int id = st.pop().idx;
					res[id] = ptr.val;
				}
				st.push(new pair(ptr.val, idx++));
			}
			ptr = ptr.next;
		}
		while (st.isEmpty() == false) {
			int id = st.pop().idx;
			res[id] = 0;
		}
		return res;
	}

	/*
	 * Question 8 Remove zero sum consecutive nodes from Linked list.
	 */
	public ListNode removeZeroSumSublists(ListNode head) {
        //First create a prefix sum storing sum till a specific point.
        if(head.next == null){
            if(head.val == 0){
                return null;
            }
            return head;
        }
        int[] prefix = new int[1002];
        Stack<ListNode> st = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0 , 0);
        int sum = 0;
        ListNode temp = head;
        int idx= 1;
        while(temp != null){
            
            ListNode ptr = temp.next;
            if(st.isEmpty() == false){
                st.peek().next = temp;
            }
            st.push(temp);
            sum += temp.val;
            if(hm.containsKey(sum) == true){
                int diff= Math.abs(idx - hm.get(sum));
                while(diff > 0){
                    diff--;
                    //remove the nodes
                    st.pop();
                }
                if(st.isEmpty() == false){
                    st.peek().next = null;
                }
                for(int i = hm.get(sum) + 1 ; i<idx ; i++){
                    hm.remove(prefix[i]);
                }
                idx = hm.get(sum)+1;
                temp = temp.next;
                continue;
            }
            else{
                hm.put(sum , idx);
            }
            prefix[idx++] = sum;
            temp = ptr;
        }
        if(st.isEmpty() == true){
            return null;
        }
        ListNode ans = null;
        while(st.isEmpty() == false){
            ans = st.pop();
        }
        return ans;
        // return head;
    }
}
