package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problems {
	public static void main(String[] args) {
		
	}

	/*
	 * Question 1 A permutation perm of n + 1 integers of all the integers in the
	 * range [0, n] can be represented as a string s of length n where:
	 * 
	 * - s[i] == 'I' if perm[i] < perm[i + 1], and - s[i] == 'D' if perm[i] > perm[i
	 * + 1].
	 * 
	 * Given a string s, reconstruct the permutation perm and return it. If there
	 * are multiple valid permutations perm, return **any of them**.
	 */
	public static int[] Question_1(String s) {
		int incr = 0;
        int decr = s.length();
        int k = 0;
        char ch = s.charAt(0);
        char ch_2 = s.charAt(s.length()-1);
        s = ("" + ch) + s + (ch_2 + "");
        System.out.println(s);
        int[] ans = new int[decr+1];
        for(int i=0 ; i<s.length()-1  ; i++){
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'I'){
                ans[k++] = incr;
                incr++;
            }
            else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'D'){
                ans[k++] = decr;
                decr--;
            }
            else if(s.charAt(i) == 'D' && s.charAt(i+1) == 'D'){
                ans[k++] = decr;
                decr--;
            }
            else if(s.charAt(i) == 'D' && s.charAt(i+1) == 'I'){
                ans[k++] = incr;
                incr++;
            }
        }
        return ans;
	}

	/*
	 * Question 2 You are given an m x n integer matrix matrix with the following
	 * two properties:
	 * 
	 * - Each row is sorted in non-decreasing order. - The first integer of each row
	 * is greater than the last integer of the previous row.
	 */
	public static boolean Question_2(int[][] matrix, int target) {
		int i = 0;
        int start = 0;
        int end = matrix.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid][i] == target){
                return true;
            }
            else if(matrix[mid][i] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(end < 0){
            return false;
        }
        int row = end;
        start = 0;
        end = matrix[0].length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
	}

	/*
	 * Question 3 Given an array of integers arr, return true if and only if it is a
	 * valid mountain array.
	 */
	public static boolean Question_3(int[] arr) {
		if(arr.length < 3){
            return false;
        }
        int j = 0;
        for(int i=0 ; i<arr.length-1 ; i++){
            if(arr[i] > arr[i+1]){
                j = i;
                break;
            }
            else if(arr[i] == arr[i+1]) return false;
        }
        if(j == 0){
            return false;
        }
        // int temp = 0;
        for(int i = j ; i<arr.length-1 ; i++){
            if(arr[i] < arr[i+1]){
                return false;
            }
            else if(arr[i] == arr[i+1]) return false;
        }
        return true;
	}

	/*
	 * Question 4 Given a binary array nums, return the maximum length of a
	 * contiguous subarray with an equal number of 0 and 1.
	 */
	public static int Question_4(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int prefix[] = new int[nums.length + 1];
        hm.put(0 , -1);
        int ans = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i] == 1){
                prefix[i+1] = prefix[i] + 1;
            }
            else{
                prefix[i+1] = prefix[i] - 1;
            }
            // if(hm.containsKey())
            hm.putIfAbsent(prefix[i+1], i);
            ans = Math.max(ans, (i - hm.get(prefix[i+1])));
        }
        return ans;
	}

	/*
	 * Question 5 The **product sum** of two equal-length arrays a and b is equal to
	 * the sum of a[i] * b[i] for all 0 <= i < a.length (**0-indexed**).
	 * 
	 * - For example, if a = [1,2,3,4] and b = [5,2,3,1], the **product sum** would
	 * be 1*5 + 2*2 + 3*3 + 4*1 = 22.
	 */
	public static long Question_5(int a[], int b[], long n) {
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        int start = a.length-1;
        int end = 0;
        while(start >= 0){
            sum += a[start]*b[end];
            end++;
            start--;
        }
        return sum;
	}

	/*
	 * Question 6 An integer array original is transformed into a doubled array
	 * changed by appending twice the value of every element in original, and then
	 * randomly shuffling the resulting array.
	 */
	public static int[] Question_6(int[] changed) {
        int len = changed.length;
        if(len%2 != 0){
            return new int[]{};
        }
        // Arrays.sort(changed)
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(changed);
        for(int i=0 ; i<changed.length ; i++){
            hm.put(changed[i] , hm.getOrDefault(changed[i] , 0) + 1);
        }
        int[] ans = new int[changed.length/2];
        int p = 0;
        for(int i=0 ; i<changed.length ; i++){
            int ele = changed[i];
            // System.out.println(ele);
            //1 2 3 4 6 8
            // System.out.println(ele);
            if(hm.containsKey(ele)){
                if(hm.containsKey(ele*2)){
                    ans[p++] = ele;
                    hm.put(ele, hm.get(ele) - 1);
                    hm.put(ele*2 , hm.get(ele*2) - 1);
                    if(hm.get(ele) <= 0) hm.remove(ele);
                    if(hm.containsKey(ele*2) && hm.get(ele*2) <= 0) hm.remove(ele*2);
                }
                else{
                    return new int[]{};
                }
            }
        }
        return ans;
	}

	/*
	 * Question 7 Given a positive integer n, generate an n x n matrix filled with
	 * elements from 1 to n2 in spiral order.
	 */
	public static int[][] Question_7(int n) {
		int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return matrix;
	}

	/*
	 * Question 8 Given two sparse matrices mat1 of size m x k and mat2 of size k x
	 * n, return the result of mat1 x mat2. You may assume that multiplication is
	 * always possible.
	 */
	public static class pair{
		int r;
		int c;
		pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static int[][] Question_8(int[][] A, int[][] B) {
		int[][] result = new int[A.length][B.length];
		ArrayList<pair> a = new ArrayList<pair>();
		ArrayList<pair> b = new ArrayList<pair>();
		for(int i=0 ; i<A.length ; i++) {
			for(int j = 0 ;j<A[0].length ; j++) {
				if(A[i][j] != 0) {
					a.add(new pair(i , j));
				}
			}
		}
		
		for(int i=0 ; i<B.length ; i++) {
			for(int j = 0 ;j<B[0].length ; j++) {
				if(B[i][j] != 0) {
					b.add(new pair(i , j));
				}
			}
		}
		
		for(pair p : a) {
			for(pair q : b) {
				if(p.c == q.r) {
					result[p.r][q.c] += A[p.r][p.c] * B[q.r][q.c];
				}
			}
		}
		return result;
	}
}
