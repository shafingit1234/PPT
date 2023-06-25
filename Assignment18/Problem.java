package Assignment18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Stack;

public class Problem {
	/* Question 1 */
	class Question1 {
		// sort by start
		class pair {
			int start;
			int end;

			pair(int start, int end) {
				this.start = start;
				this.end = end;
			}
		}

		class customSort implements Comparator<pair> {
			public int compare(pair p1, pair p2) {
				if (p1.start < p2.start) {
					return -1;
				}
				return 1;
			}
		}

		public int[][] merge(int[][] intervals) {
			ArrayList<pair> al = new ArrayList<>();
			for (int i = 0; i < intervals.length; i++) {
				al.add(new pair(intervals[i][0], intervals[i][1]));
			}
			Collections.sort(al, new customSort());
			// int[][] res = new int[][];
			ArrayList<pair> res = new ArrayList<>();
			pair p1 = al.get(0);
			for (int i = 1; i < al.size(); i++) {
				pair p2 = al.get(i);
				if (p1.end < p2.start) {
					// res.add(p1);
					res.add(p1);
					// res.add(p2);
					p1 = p2;
					continue;
				} else {
					pair p3;
					if (p1.end >= p2.end) {
						p3 = p1;
					} else {
						p3 = new pair(p1.start, p2.end);
					}
					// p3.start = p1.start;
					// p3.end = p2.end;
					// res.add(p3);
					p1 = p3;
				}
			}
			res.add(p1);
			int[][] ans = new int[res.size()][2];
			for (int i = 0; i < res.size(); i++) {
				ans[i][0] = res.get(i).start;
				ans[i][1] = res.get(i).end;
			}
			return ans;
		}
	}

	/* Question 2 */
	class Question2 {
		public void sortColors(int[] nums) {
			int count[] = new int[3];
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0)
					count[0]++;
				if (nums[i] == 1)
					count[1]++;
				if (nums[i] == 2)
					count[2]++;
			}
			int p = 0;
			for (int i = 0; i < count[0]; i++) {
				nums[p++] = 0;
			}
			for (int i = 0; i < count[1]; i++) {
				nums[p++] = 1;
			}
			for (int i = 0; i < count[2]; i++) {
				nums[p++] = 2;
			}
		}
	}
	/* Question 3 */
	/*
	 * The isBadVersion API is defined in the parent class VersionControl. boolean
	 * isBadVersion(int version);
	 */

	class Question3 {
		public boolean isBadVersion(int mid) {
			//API given in question.
			//This function is supposed to be removed.
			return true;
		}
		public int firstBadVersion(int n) {
			int s = 1;
			int e = n;
			int mid = 1;
			int ans = -1;
			while (s <= e) {
				mid = s + (e - s) / 2;
				if (isBadVersion(mid) == true) {
					e = mid - 1;
					ans = mid;
				} else if (isBadVersion(mid) == false) {
					s = mid + 1;
				}
			}
			return ans;
		}
	}
	/*Question 4*/
	
	/*Question 5*/
	class Question5 {
	    public boolean containsDuplicate(int[] nums) {
	        HashSet<Integer> hs = new HashSet<Integer>();
	        for(int i=0 ; i<nums.length ; i++){
	            hs.add(nums[i]);
	        }
	        if(hs.size() == nums.length){
	            return false;
	        }
	        return true;
	    }
	}
	/*Question 6*/
	
	/*Question 7*/
	class Question7 {
	    public int lengthOfLIS(int[] nums) {
	        int size = nums.length;
	        Integer[][]dp = new Integer[size][size+1];
	        return recursion2(nums, size-1 , size,dp);
	    }
	    int recursion2(int a[], int idx, int val, Integer[][] dp)
	    {
	        if(idx < 0)
	        {
	            return 0;
	        }
	        int sp1 = 0;
	        int sp2 = 0;
	        if(dp[idx][val] != null)
	        {
	            return dp[idx][val];
	        }
	        if(val == a.length || a[idx] < a[val])
	        {
	            sp1 = recursion2(a, idx-1, idx, dp) + 1;
	        }
	        sp2 = recursion2(a, idx-1, val,dp);
	        dp[idx][val] =  Math.max(sp1, sp2);
	        // return dp[idx];
	        return Math.max(sp1, sp2);
	    }
	}
	/*Question 8*/
	class Question8 {
	    public boolean find132pattern(int[] nums) {
	        int[] small = new int[nums.length];
	        small[0] = Integer.MIN_VALUE;
	        
	        int min = nums[0];
	        //store smallest possible value present to the right side of current element you have visited.
	        for(int i=1 ; i<nums.length ; i++)
	        {
	            if(nums[i] > min)
	            {
	                small[i] = min;
	            }
	            else{
	                min = nums[i];
	                small[i] = Integer.MIN_VALUE;
	            }
	        }
	        Stack<Integer> st = new Stack<Integer>();
	        //for every arr[k] find out an element arr[j] such that arr[j] > arr[k] and arr[k] has a valid smallest value to its right.
	        for(int i=nums.length-1 ; i>=0 ; i--)
	        {
	            while(st.isEmpty() == false && st.peek() <= small[i])
	            {
	                st.pop();
	            }
	            if(st.isEmpty() == false && small[i] != Integer.MIN_VALUE && st.peek() < nums[i])
	            {
	                return true;
	            }
	            st.add(nums[i]);
	        }
	        return false;
	    }
	}
}
