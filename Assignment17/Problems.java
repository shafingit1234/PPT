package Assignment17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problems {
	public static void main(String[] args) {

	}

	/* Question 1 */
	public static int Question1(String s) {
		char[] freq = new char[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		int idx = -1;
		for (int i = 0; i < 26; i++) {
			if (freq[i] == 1) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
//			System.out.println(-1);
			return -1;
		}
		char ch = (char) ('a' + idx);
		int ans = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
//				ans = ch;
				ans = i;
				break;
			}
		}
		return ans;
	}

	/* Question 2 */
	public static int Kadanes(int[] nums) {
		int sum = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			ans = Math.max(ans, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return ans;
	}

	public static int Question2(int[] nums) {
		int ans = Kadanes(nums);
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
			nums[i] = -nums[i];
		}
		int minAns = -1 * Kadanes(nums);
		if (totalSum == minAns) {
			return ans;
		}
		int temp = totalSum - minAns;
		return Math.max(temp, ans);
	}

	/* Question 3 */
	public int Question3(int[] students, int[] sandwiches) {
		int[] a = { 0, 0 };
		for (int i = 0; i < students.length; i++) {
			a[students[i]] += 1;
		}
		int k = 0;
		while (k < sandwiches.length) {
			if (a[sandwiches[k]] > 0) {
				a[sandwiches[k]] -= 1;
			} else {
				break;
			}
			k += 1;
		}
		return sandwiches.length - k;
	}

	/* Question 4 */
	Queue<Integer> q = new LinkedList<Integer>();

	public int Question4(int t) {
		q.offer(t);
		while (q.isEmpty() == false && q.peek() < t - 3000) {
			q.poll();
		}
		return q.size();
	}

	/* Question 5 */
	public int findTheWinner(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.offer(i);
		}
		while (q.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.remove());
			}
			q.remove();
		}
		return q.peek() + 1;
	}

	/* Question 6 */
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < deck.length; i++)
			q.add(i);

		int[] ans = new int[deck.length];
		for (int i = 0; i < deck.length; i++) {
			ans[q.poll()] = deck[i];
			q.add(q.poll());
		}
		return ans;
	}
	/*Question 7*/
	class FrontMiddleBackQueue {

	    private Queue<Integer> queue;
	    private Queue<Integer> queue2;
	    public FrontMiddleBackQueue() {
	        queue = new LinkedList<>();
	        queue2 = new LinkedList<>();
	    }
	    
	    public void pushFront(int val) {
	        queue2.add(val);
	        while(!queue.isEmpty()){
	            queue2.add(queue.remove());
	        }
	        queue = queue2;
	        queue2 = new LinkedList<>();
	    }
	    
	    public void pushMiddle(int val) {
	        if(queue.size() == 0){
	            queue.add(val);
	            return;
	        }
	        int size = queue.size();
	        while(!queue.isEmpty()){
	            if(((size%2 == 0) && (queue.size() == size/2)) || ((size%2 != 0) && (queue.size() == (size/2)+1))){
	                queue2.add(val);
	            }
	            queue2.add(queue.remove());
	        }
	        queue = queue2;
	        queue2 = new LinkedList<>();    
	    }
	    
	    public void pushBack(int val) {
	        queue.add(val);
	    }
	    
	    public int popFront() {
	        if(queue.isEmpty()) return -1;
	        return queue.remove();
	    }
	    
	    public int popMiddle() {
	        if(queue.isEmpty()) return -1;
	        int size = queue.size();
	        int removed = -1;
	        while(!queue.isEmpty()){
	            if(((size%2 == 0) && (queue.size() == (size/2)+1)) || ((size%2 != 0) && (queue.size() == (size/2)+1))){
	                removed = queue.remove();
	                continue;
	            }
	            queue2.add(queue.remove());
	        }
	        queue = queue2;
	        queue2 = new LinkedList<>();  
	        return removed;
	    }
	    
	    public int popBack() {
	        if(queue.isEmpty()) return -1;
	        while(queue.size() > 1){
	            queue2.add(queue.remove());
	        }
	        int removed = queue.remove();
	        queue = queue2;
	        queue2 = new LinkedList<>();
	        return removed;
	    }
	}
	/*Question 8*/
	class DataStream {
	    Queue<Integer> q=new LinkedList<>();
	    int k;
	    int value;
	    public DataStream(int value, int k) {
	        this.k=k;
	        this.value=value;
	    }
	    
	    public boolean consec(int num) {
	        if(num!=value){q.clear();return false;}
	        if(num==value){
	            q.add(num);
	        }
	        if(q.size()==k){
	            q.poll();
	            return true;
	        }
	        return false;
	    }
	}

}
