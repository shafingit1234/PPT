package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Given three integer arrays arr1, arr2 and arr3 sorted in strictly
	 * increasing order, return a sorted array of only the integers that appeared in
	 * all three arrays.
	 */
	public static ArrayList<Integer> Question1(int A[], int B[] , int C[], int n1, int n2, int n3) {
		HashMap<Integer, Integer> hm1 = new HashMap<Integer , Integer>();
        HashMap<Integer, Integer> hm2 = new HashMap<Integer , Integer>();
        HashMap<Integer, Integer> hm3 = new HashMap<Integer , Integer>();
        for(int i=0 ; i<n1 ; i++){
            if(hm1.containsKey(A[i]) == false){
                hm1.put(A[i] , 0);
            }
            hm1.put(A[i]  ,hm1.get(A[i]) + 1);
        }
        for(int i=0 ; i<n2 ; i++){
            if(hm2.containsKey(B[i]) == false){
                hm2.put(B[i] , 0);
            }
            hm2.put(B[i]  ,hm2.get(B[i]) + 1);
        }
        for(int i=0 ; i<n3 ; i++){
            if(hm3.containsKey(C[i]) == false){
                hm3.put(C[i] , 0);
            }
            hm3.put(C[i]  ,hm3.get(C[i]) + 1);
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0 ; i<n3 ; i++){
            if(hm1.containsKey(C[i]) == false || hm2.containsKey(C[i]) == false){
                continue;
            }
            if(hm1.get(C[i]) > 0 && hm2.get(C[i]) > 0 && hm3.get(C[i]) > 0){
                al.add(C[i]);
                hm1.put(C[i] , 0);
            }
        }
        return al;
	}

	/*
	 * Question 2**
	 * 
	 * Given two **0-indexed** integer arrays nums1 and nums2, return *a list*
	 * answer *of size* 2 *where:*
	 * 
	 * - answer[0] *is a list of all **distinct** integers in* nums1 *which are
	 * **not** present in* nums2*.* - answer[1] *is a list of all **distinct**
	 * integers in* nums2 *which are **not** present in* nums1. </aside>
	 */
	public static List<List<Integer>> Question2(int[] nums1, int[] nums2) {
		int[] freq = new int[2001];
        for(int i=0 ; i<nums1.length ; i++){
            if(nums1[i] < 0){
                int temp = Math.abs(nums1[i]) + 1000;
                freq[temp] = 1;
            }
            else{
                freq[nums1[i]] = 1;
            }
        }
        // ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0 ; i<nums2.length ; i++){
            if(nums2[i] < 0){
                int temp = Math.abs(nums2[i]) + 1000;
                // al.add(temp);
                if(freq[temp] == 1){
                    // al.add(nums2[i]);
                    hs.add(nums2[i]);
                }
            }
            else{
                if(freq[nums2[i]] == 1){
                    // al.add(nums2[i]);
                    hs.add(nums2[i]);
                }
            }
        }
        List<List<Integer>> ls = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashSet<Integer> remove = new HashSet<Integer>();
        for(int i=0 ; i<nums1.length ; i++){
            if(hs.contains(nums1[i]) == false && remove.contains(nums1[i]) == false){
                al.add(nums1[i]);
                remove.add(nums1[i]);
            }
        }
        ls.add(al);
        ArrayList<Integer> al_two = new ArrayList<Integer>();
        remove.clear();
        for(int i=0 ; i<nums2.length ; i++){
            if(hs.contains(nums2[i]) == false && remove.contains(nums2[i]) == false){
                al_two.add(nums2[i]);
                remove.add(nums2[i]);
            }
        }
        ls.add(al_two);
        return ls;
	}

	/*
	 * Question 3** Given a 2D integer array matrix, return *the **transpose** of*
	 * matrix.
	 * 
	 * The **transpose** of a matrix is the matrix flipped over its main diagonal,
	 * switching the matrix's row and column indices.
	 * 
	 * </aside>
	 */
	public static int[][] Question3(int[][] matrix) {
		int[][] ans = new int[matrix[0].length][matrix.length];
        int row = 0;
        int col = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                ans[row][col] = matrix[i][j];

                row++;

                if(row % ans.length == 0) {
                    row = 0;
                    col++;
                }
            }
        }
        return ans;
	}

	/*
	 * Question 4 Given an integer array nums of 2n integers, group these integers
	 * into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai,
	 * bi) for all i is maximized. Return the maximized sum.
	 */
	public static int Question4(int[] nums) {
		Arrays.sort(nums);
        int sum = 0;
        for(int i=nums.length - 1 ; i >= 0 ;){
            sum += Math.min(nums[i] , nums[i-1]);
            i = i - 2;
        }
        return sum;
	}

	/*
	 * Question 5 You have n coins and you want to build a staircase with these
	 * coins. The staircase consists of k rows where the ith row has exactly i
	 * coins. The last row of the staircase may be incomplete.
	 */
	public static int Question5(int n) {
		return (int)Math.floor(-0.5 + Math.sqrt((double)2*n + 0.25));
	}

	/*
	 * Question 6 Given an integer array nums sorted in non-decreasing order, return
	 * an array of the squares of each number sorted in non-decreasing order.
	 */
	public static int[] Question6(int[] nums) {
		int end = nums.length - 1;
        int start = 0;
        int[] ans = new int[nums.length];
        int p = end;
        while(start <= end)
        {
            if(Math.abs(nums[start]) < Math.abs(nums[end]) )
            {
                ans[p--] = nums[end]*nums[end];
                end--;
            }
            else{
                ans[p--] = nums[start]*nums[start];
                start++;
            }
        }
        return ans;
	}
	public static void insert(int[] nums, int start, int end)
    {
        int temp = nums[start];
        for(int i = start; i<end ; i++)
        {
            nums[i] = nums[i+1];
        }
        nums[end] = temp;
    }
	/*
	 * Question 7 You are given an m x n matrix M initialized with all 0's and an
	 * array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be
	 * incremented by one for all 0 <= x < ai and 0 <= y < bi.
	 */
	public static int Question7(int m, int n , int[][] ops) {
		for(int i=0  ; i<ops.length ; i++){
            int a = ops[i][0];
            int b = ops[i][1];
            m = Math.min(a , m);
            n = Math.min(b , n);
        }
        return m*n;
	}

	/*
	 * Question 8**
	 * 
	 * Given the array nums consisting of 2n elements in the form
	 * [x1,x2,...,xn,y1,y2,...,yn].
	 * 
	 * Return the array in the form* [x1,y1,x2,y2,...,xn,yn].
	 * 
	 */
	public static int[] Question8(int[] nums, int n) {
		int arr[] = new int[nums.length];
        int c = 0;
        for(int i=0 ; i<arr.length ; i= i+2){
            arr[i] = nums[c];
            arr[i+1] = nums[n];
            c++;
            n++;
        }
        return arr;
	}
}
