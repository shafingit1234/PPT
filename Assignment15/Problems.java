package Assignment15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problems {
	public static void main(String[] args) {
		
	}
	/*
	 * Question 1
	 * Next Greater Element
	 * */
	public class pair{
        int idx;
        int value;
        pair(int idx, int value)
        {
            this.idx = idx;
            this.value = value;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<pair> st_one = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i=0 ; i<nums.length ; i++)
        {
            if(st_one.isEmpty() == true)
            {
                st_one.push(new pair(i , nums[i]));
                continue;
            }
            while(st_one.isEmpty() == false && st_one.peek().value < nums[i])
            {
                res[st_one.pop().idx] = nums[i];
            }
            st_one.push(new pair(i , nums[i]));
        }
        if(st_one.isEmpty() == true) return res;
        int end = st_one.peek().idx;
        for(int i=0 ; i<end ; i++)
        {
            while(st_one.isEmpty() == false && st_one.peek().value < nums[i] && st_one.peek().idx > i)
            {
                res[st_one.pop().idx] = nums[i];
            }
            if(st_one.isEmpty() == true) return res;
        }
        return res;
        
    }
    /*
     * Question 2
     * Smallest Number on lest
     * */
    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> al = new ArrayList<Integer>();
        // Collections.fill(al, 0);
        for(int i=0 ; i<n ; i++) al.add(0);
        Stack<Integer> st = new Stack();
        for(int i=a.length-1 ; i>=0; i--)
        {
            if(st.isEmpty() == true)
            {
                st.add(i);
            }
            else if(a[i] >= a[st.peek()])
            {
                st.add(i);
            }
            else{
                while(st.isEmpty() == false && a[i] < a[st.peek()]){
                    int idx = st.pop();
                    al.set(idx, a[i]);
                }
                st.add(i);
            }
        }
        while(st.isEmpty() == false)
        {
            int idx = st.pop();
            al.set(idx, -1);
        }
        return al;
        //code here
    }
    /*
     * Question 3
     * Implement Stack using two queues
     * */
    static class Stack_custom {
        // Two inbuilt queues
        static Queue<Integer> q1
            = new LinkedList<Integer>();
        static Queue<Integer> q2
            = new LinkedList<Integer>();
 
        // To maintain current number of
        // elements
        static int curr_size;
 
        static void push(int x)
        {
            // Push x first in empty q2
            q2.add(x);
 
            // Push all the remaining
            // elements in q1 to q2.
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
 
            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }
 
        static void pop()
        {
 
            // if no elements are there in q1
            if (q1.isEmpty())
                return;
            q1.remove();
        }
 
        static int top()
        {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }
 
        static int size() { return q1.size(); }
    }
    
    /*
     * Question 4
     * 
     * Reverse a stack using recursion
     * */
    static ArrayList<Integer> reverse(Stack<Integer> s)
    {
        // add your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        reverseStack(al, s);
        return al;
    }
    static void reverseStack(ArrayList<Integer> al, Stack<Integer> s)
    {
        if(s.isEmpty() == true)
        {
            return ;
        }
        int ele = s.pop();
        al.add(ele);
        reverseStack(al, s);
        s.push(ele);
    }
    
    /*Question 5
     * 
     * Reverse a string using recursion
     * */
    public String reverse(String s){
        //code here
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            st.push(s.charAt(i));
        }
        String ans = "";
        while(st.isEmpty() == false){
            ans += st.pop();
        }
        return ans;
    }
    /*
     * Question 6
     * Postfix Evaluation
     * */
    public static int evaluatePostFix(String s)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<s.length() ; i++)
        {
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57)
            {
                int temp = s.charAt(i);
                st.push(temp - 48);
            }
            else
            {
                int a = st.peek();
                st.pop();
                int b = st.peek();
                st.pop();
                int c;
                if(s.charAt(i) == '*')
                {
                    c  = b*a;
                }
                else if(s.charAt(i) == '/'){
                    c = b/a;
                }
                else if(s.charAt(i) == '+'){
                    c = a+b;
                }
                else{
                    c = b-a;
                }
                st.push(c);
            }
        }
        int c = st.peek();
        st.pop();
        return c;
        // Your code here
    }
    /*
     * Question 7
     * Min Stack Design
     * */
    class MinStack {
        public Stack<pair> st;
        public class pair{
            int a;
            int b;
            pair(int a, int b){
                this.a = a;
                this.b = b;
            }
        }
        public MinStack() {
           st = new Stack<>();
        }
        
        public void push(int val) {
            // st.push();
            if(st.isEmpty() == true){
                st.push(new pair(val, val));
                return ;
            }
            int min_so_far = st.peek().b;
            min_so_far = Math.min(min_so_far, val);
            st.push(new pair(val, min_so_far));
            return ;
        }
        
        public void pop() {
            st.pop();
        }
        
        public int top() {
            return st.peek().a;
        }
        
        public int getMin() {
            return st.peek().b;
        }
    }
    
    
    /*
     * Question 8
     * Rain Water trapping
     * */
    public int trap(int[] arr) {
        int[] left = new int[arr.length];
        int sum = 0;
        int[] right = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++)
        {
            left[i] = sum;
            sum = Math.max(sum, arr[i]);
        }
        sum = 0;
        for(int i = arr.length-1 ; i>=0 ; i--)
        {
            right[i] = sum;
            sum = Math.max(sum, arr[i]);
        }
        sum = 0;
        for(int i = 0 ; i<arr.length ; i++)
        {
            int minH = Math.min(left[i] , right[i]);
            if(minH - arr[i] > 0)
            {
                sum = sum + minH-arr[i]; 
            }
        }
        return sum;
    }
    
}
