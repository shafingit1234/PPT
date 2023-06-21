package Assignment16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Next Greater Frequency Element for each element
	 */
	Stack<Pair> mystack = new Stack<>();
	HashMap<Integer, Integer> mymap = new HashMap<>();

	class Pair {
		int data;
		int freq;

		Pair(int data, int freq) {
			this.data = data;
			this.freq = freq;
		}
	}

	/*
	 * NFG function to find the next greater frequency element for each element and
	 * for placing it in the resultant array
	 */
	void NGF(int[] arr, int[] res) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (mymap.containsKey(arr[i]))
				mymap.put(arr[i], mymap.get(arr[i]) + 1);
			else
				mymap.put(arr[i], 1);
		}
		int curr_freq = mymap.get(arr[n - 1]);
		mystack.push(new Pair(arr[n - 1], curr_freq));
		res[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			curr_freq = mymap.get(arr[i]);
			while (!mystack.isEmpty() && curr_freq >= mystack.peek().freq)
				mystack.pop();
			res[i] = (mystack.isEmpty()) ? -1 : mystack.peek().data;
			mystack.push(new Pair(arr[i], mymap.get(arr[i])));
		}
	}

	/*
	 * Question 2 Sort using temporary stack.
	 */
	public Stack<Integer> sort(Stack<Integer> s) {
		if (s.empty() == true) {
			return s;
		}
		int temp = s.pop();
		s = sort(s);
		s = modify(s, temp);
		return s;
		// add code here.
	}

	public Stack<Integer> modify(Stack<Integer> s, int ele) {
		if (s.empty() == true) {
			s.push(ele);
			return s;
		}
		if (s.peek() > ele) {
			int temp = s.pop();
			modify(s, ele);
			s.push(temp);
		} else {
			s.push(ele);
		}
		return s;
	}

	/*
	 * Question 3 Remove middle element from the stack
	 */
	public void deleteMid(Stack<Integer> s, int sizeOfStack) {
		// code here
		Stack<Integer> st = new Stack<>();
		int mid = sizeOfStack - (sizeOfStack + 1) / 2 + 1;
		int cnt = 0;
		while (cnt <= sizeOfStack && s.isEmpty() == false) {
			cnt++;
			if (cnt == mid) {
				s.pop();
				continue;
			}
			st.push(s.pop());
		}
		while (st.isEmpty() == false) {
			s.push(st.pop());
		}
		// return st;
	}

	/*
	 * Question 4 CHeck if Queue can be sorted into another queue using stack
	 */
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean checkSorted(int n) {
		Stack<Integer> st = new Stack<Integer>();
		int expected = 1;
		int fnt;
		while (q.size() != 0) {
			fnt = q.peek();
			q.poll();
			if (fnt == expected)
				expected++;

			else {
				if (st.size() == 0) {
					st.push(fnt);
				}
				else if (st.size() != 0 && st.peek() < fnt) {
					return false;
				}
				else
					st.push(fnt);
			}
			while (st.size() != 0 && st.peek() == expected) {
				st.pop();
				expected++;
			}
		}
		if (expected - 1 == n && st.size() == 0)
			return true;

		return false;
	}
	/*
	 * 
	 * Question 5
	 * REverse a number using stack
	 * */
    static Stack<Integer> st= new Stack<>();
    static void push_digits(int number)
    {
        while(number != 0)
        {
            st.push(number % 10);
            number = number / 10;
        }
    }
    static int reverse_number(int number)
    {
        push_digits(number);
        int reverse = 0;
        int i = 1;
        while (!st.isEmpty())
        {
            reverse = reverse + (st.peek() * i);
            st.pop();
            i = i * 10;
        }
        return reverse;
    }
    /*
     * Question 6
     * 
     * */
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q1 = new LinkedList<>();
        while(k > 0){
            s.push(q.peek());
            q.poll();
            k--;
        }
        while(!q.isEmpty()){
            q1.offer(q.peek());
            q.poll();
        }
        while(!s.isEmpty()){
            q.offer(s.peek());
            s.pop();
        }
        while(!q1.isEmpty()){
            q.offer(q1.peek());
            q1.poll();
        }
        return q;
        //add code here.
    }
    /*
     * Question 7
     * */
    static int removeConsecutiveSame(Vector <String > v) 
    {
        // Your code goes here
        Stack<String> st = new Stack<>();
        for(int i=0;i<v.size();++i) {
            if(st.empty()) {
                st.push(v.get(i));
            }
            else {
                if(v.get(i).equals(st.peek())) {
                    st.pop();
                }
                else {
                    st.push(v.get(i));
                }
            }
        }
        return st.size();
    }
    /*
     * Question 8
     * */
    int[] prevSmallestElement(int[] a , int n ){
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        stack.push(0);
        for(int i = 0 ; i<n ; i++){
            int curr = a[i];
            while(!stack.isEmpty() && stack.peek() != -1 && stack.peek() >= curr){
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(a[i]);
        }
        return prev;
    }
    
    int[] nextSmallestElement(int[] a , int n ){
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[n];
        stack.push(0);
        for(int i = n-1 ; i>=0 ; i--){
            int curr = a[i];
            while(!stack.isEmpty() && stack.peek() != -1 && stack.peek() >= curr){
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(a[i]);
        }
        return next;
    }
    
    
    int findMaxDiff(int a[], int n)
    {
        // Your code here
        int[] left = prevSmallestElement(a ,n);
        int[] right = nextSmallestElement(a,n);
         
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0 ; i<n; i++){
           maxDiff = Math.max(Math.abs(left[i] - right[i]) , maxDiff);
        }
       
        return maxDiff;
    }
    
}
