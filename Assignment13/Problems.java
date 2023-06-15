package Assignment13;

import java.util.Stack;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Design a LinkedList
	 */
	class MyLinkedList {
		class Node {
			int val;
			Node nxt;
			Node prev;

			Node(int val) {
				this.val = val;
				this.nxt = null;
				this.prev = null;
			}
		}

		Node head;
		Node tail;

		public MyLinkedList() {
			head = null;
			tail = null;
		}

		public int get(int index) {
			int cnt = 0;
			Node ptr = head;
			if (head == null)
				return -1;
			if (cnt == index) {
				return head.val;
			}
			while (ptr != null) {
				ptr = ptr.nxt;
				cnt++;
				if (cnt == index) {
					break;
				}

			}
			if (ptr == null)
				return -1;
			return ptr.val;
		}

		public void addAtHead(int val) {
			Node temp = new Node(val);
			if (head == null) {
				head = temp;
				tail = temp;
				return;
			}
			temp.nxt = head;
			head.prev = temp;
			head = temp;
			return;
		}

		public void addAtTail(int val) {
			Node temp = new Node(val);
			if (tail == null) {
				head = temp;
				tail = temp;
				return;
			}
			tail.nxt = temp;
			temp.prev = tail;
			tail = temp;
		}

		public void addAtIndex(int index, int val) {
			if (index == 0) {
				addAtHead(val);
				return;
			}
			Node ptr = head;
			int cnt = 0;
			Node temp = new Node(val);
			while (ptr != null) {
				ptr = ptr.nxt;
				cnt++;
				if (cnt == index) {
					break;
				}
			}
			if (ptr == null && cnt == index) {
				addAtTail(val);
				return;
			}
			if (cnt == index) {
				temp.nxt = ptr;
				temp.prev = ptr.prev;
				ptr.prev.nxt = temp;
				ptr.prev = temp;
			}
			return;
		}

		public void deleteAtIndex(int index) {
			if (head == null) {
				return;
			}
			if (index == 0) {
				Node ptr = head;
				head = head.nxt;
				if (head != null)
					head.prev = null;
				ptr.nxt = null;
				return;
			}
			int cnt = 0;
			Node ptr = head;
			while (ptr != null) {
				cnt++;
				ptr = ptr.nxt;
				if (cnt == index) {
					break;
				}
			}
			if (ptr == null)
				return;
			Node temp = ptr.prev;
			temp.nxt = ptr.nxt;
			if (ptr.nxt != null) {
				ptr.nxt.prev = temp;
			} else {
				tail = temp;
			}
			ptr.nxt = null;
			ptr.prev = null;
			return;
		}
	}

	/*
	 * Question 2
	 * 
	 * Remove Duplicates from Sorted List
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

	public static ListNode Question2(ListNode head) {
		ListNode temp1 = head;
		ListNode temp2 = head;
		while (temp1 != null) {
			while (temp2 != null && temp2.next != null && temp1.val == temp2.next.val) {
				temp2 = temp2.next;
			}
			if (temp1 != temp2) {
				temp1.next = temp2.next;
				temp2.next = null;
				temp1 = temp1.next;
				temp2 = temp1;
			} else {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return head;
	}

	/*
	 * Question 3
	 * 
	 * Given a linked list of size N. The task is to reverse every k nodes (where k
	 * is an input to the function) in the linked list. If the number of nodes is
	 * not a multiple of k then left-out nodes, in the end, should be considered as
	 * a group and must be reversed (See Example 2 for clarification).
	 */
	public static ListNode Question3(ListNode head, int k) {
		
		/*
		 * TIME COMPLEXITY : O(SIZE OF LINKED LIST)
		 * 
		 * SPACE COMPLEXITY: O(k + SIZE OF LINKED LIST) = O(SIZE OF LINKED LIST)
		 * */
		
		Stack<ListNode> st = new Stack<>();
        ListNode ptr = head;
        int cnt = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode tmp = null;
        boolean flag = false;
        while(ptr!= null)
        {
            if(cnt == k)
            {
                cnt = 0;
                while(st.isEmpty() == false)
                {
                    tail.next = st.pop();
                    tail = tail.next;
                }
                flag = false;
            }
            st.add(ptr);
            if(flag ==false)
            {
                flag = true;
                tmp = ptr;
            }
            cnt++;
            ptr = ptr.next;
            
        }
        if(cnt == k)
        {
            while(st.isEmpty()== false)
            {
                tail.next = st.pop();
                tail = tail.next;
            }
            tail.next = null;
        }
        
        if(st.isEmpty() == false)
        {
            tail.next = tmp;
        }
        // tail.next = null;
        return dummy.next;
	}
	
	/*
	 * EFFICIENT APPROACH FOR ABOVE PROBLEM
	 * 
	 * TIME COMPLEXITY : O(N)
	 * SPACE COMPLEXITY: O(1)
	 * */
	public static ListNode Question4(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode nex = dummy;

        int count = 0;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }

        while(count >= k){
            curr = prev.next;
            nex = curr.next;
            for(int i=1 ; i<k ; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev= curr;
            count -= k;
        }
        return dummy.next;
	}
	/*
	 * 
	 * DELETE LAST OCCURENCE OF A NODE
	 * */
	public static void Question5(Node head, int x) 
	{ 
	    Node temp = head, ptr = null; 
	    while (temp!=null) 
	    { 
	        if (temp.data == x) 
	            ptr = temp;     
	        temp = temp.next; 
	    } 
	    if (ptr != null && ptr.next == null) 
	    { 
	        temp = head; 
	        while (temp.next != ptr) 
	            temp = temp.next; 
	        temp.next = null; 
	    } 
	  
	    if (ptr != null && ptr.next != null)
	    { 
	        ptr.data = ptr.next.data; 
	        temp = ptr.next; 
	        ptr.next = ptr.next.next; 
	        System.gc();
	    } 
	} 
	/*
	 * 
	 * MERGE TWO SORTED LINKED LIST
	 * 
	 * */
	public static ListNode Question6(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null)
        {
            tail.next = list1;
        }
        else
        {
            tail.next = list2;
        }
        return dummy.next;
	}


	/*
	 * Reverse a doubly linked list
	 * */
	static class Node
	{
	    int data;
	    Node next, prev;
	    Node(int data)
	    {
	        this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}
	public static Node Question7(Node head) {
		if(head == null){
	        return head;
	    }
	    Node p1 = head;
	    Node p2 = head.next;
	    p1.next= null;
	    p1.prev = p2;
	    while(p2!=null){
	        p2.prev = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = p2.prev;
	    }
	    return p1;
	}
	/*
	 * Delete a node in a doubly linked list
	 * */
	public static Node Question8(Node head, int x) {
		if(x == 1){
	        if(head.next == null){
	            return null;
	        }
	        Node temp = head;
	        head = head.next;
	        head.prev = null;
	        temp.next = null;
	        temp = null;
	        return head;
	    }
	    int cnt = 1;
	    Node temp = head;
	    while(x != cnt){
	        temp = temp.next;
	        cnt++;
	    }
	    if(temp == null){
	        return head;
	    }
	    if(temp.next == null){
	        Node tmp = temp.prev;
	        tmp.next = null;
	        temp.prev = null;
	        return head;
	    }
	    Node p = temp.prev;
	    p.next = temp.next;
	    temp.next.prev = p;
	    temp.prev = null;
	    temp.next = null;
	    return head;
	}
}
