package Assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1
	 * 
	 * Convert 1D Array Into 2D Array
	 * 
	 * You are given a **0-indexed** 1-dimensional (1D) integer array original, and
	 * two integers, m and n. You are tasked with creating a 2-dimensional (2D)
	 * array with  m rows and n columns using **all** the elements from original.
	 * 
	 * The elements from indices 0 to n - 1 (**inclusive**) of original should form
	 * the first row of the constructed 2D array, the elements from indices n to 2 *
	 * n - 1 (**inclusive**) should form the second row of the constructed 2D array,
	 * and so on.
	 */
	public static int[][] Question1(int[] original, int m, int n) {
	       int[][] ans = new int[m][n];
	        if(original.length != m*n){
	            // return null;
	            return new int[][]{};
	        }
	        int p = 0;
	        for(int i=0 ; i<m ; i++){
	            for(int j = 0 ; j<n ;j++){
	                ans[i][j] = original[p++];
	            }
	        }
	        return ans;
	}

	/*
	 * Question 2 You have n coins and you want to build a staircase with these
	 * coins. The staircase consists of k rows where the ith row has exactly i
	 * coins. The last row of the staircase may be incomplete.
	 */
	public static int Question2(int n) {
		return (int)Math.floor(-0.5 + Math.sqrt((double)2*n + 0.25));
	}

	/*
	 * Question 3 Given an integer array nums sorted in non-decreasing order, return
	 * an array of the squares of each number sorted in non-decreasing order.
	 */
	public static int[] Question3(int [] nums) {
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

	/*
	 * Question 4 Given two **0-indexed** integer arrays nums1 and nums2, return *a
	 * list* answer *of size* 2 *where:*
	 * 
	 * - answer[0] *is a list of all **distinct** integers in* nums1 *which are
	 * **not** present in* nums2*.* - answer[1] *is a list of all **distinct**
	 * integers in* nums2 *which are **not** present in* nums1.
	 ** 
	 * Note** that the integers in the lists may be returned in **any** order.
	 */
	public static List<List<Integer>> Question4(int nums1[] ,  int nums2[]) {
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
	 * Question 5 Given two integer arrays arr1 and arr2, and the integer d, *return
	 * the distance value between the two arrays*.
	 * 
	 * The distance value is defined as the number of elements arr1[i] such that
	 * there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
	 */
	public static int Question5(int[] arr1, int[] arr2, int d) {
        int count=0;
        int x=0;
        for(int i=0;i<arr1.length;i++){
            x=0;
            for(int j=0;j<arr2.length;j++){
                int diff=Math.abs(arr1[i]-arr2[j]);
                if(diff<=d){
                    j=arr2.length;
                }
                else{
                    x++;
                }
            }
            if(x==arr2.length){
                count++;
            }
        }
        return count;
	}

	/*
	 * Question 6 Given an integer array nums of length n where all the integers of
	 * nums are in the range [1, n] and each integer appears once or twice, return
	 * an array of all the integers that appears twice.
	 */
	public static List<Integer> Question6(int [] nums) {
        int n = nums.length+1;
        for(int i=0 ; i<nums.length ; i++){
            nums[nums[i]%n - 1] +=  n;
        }
        List<Integer> ls  = new ArrayList<Integer>();
        for(int i=0 ; i<nums.length ; i++){
            int temp = nums[i];
            int div = temp/n;
            if(div == 2){
                ls.add(i+1);
            }
        }
        return ls;
	}

	/*
	 * Question 7
	 * 
	 * Suppose an array of length n sorted in ascending order is **rotated** between
	 * 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
	 * 
	 * - [4,5,6,7,0,1,2] if it was rotated 4 times. - [0,1,2,4,5,6,7] if it was
	 * rotated 7 times.
	 * 
	 * Notice that **rotating** an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
	 * results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
	 */
	public static int Question7(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){

                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
	}

	/*
	 * Question 8 An integer array original is transformed into a **doubled** array
	 * changed by appending **twice the value** of every element in original, and
	 * then randomly **shuffling** the resulting array.
	 * 
	 * Given an array changed, return original *if* changed *is a **doubled** array.
	 * If* changed *is not a **doubled** array, return an empty array. The elements
	 * in* original *may be returned in **any** order*.
	 */
	public static int[] Question8(int changed[]) {
		if(changed.length%2 != 0){
            return new int[]{};
        }
        //now I am gonna go rouge.
        int[]ans = new int[changed.length/2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(changed);
        for(int i=0 ; i<changed.length ; i++){
            if(hm.containsKey(changed[i]) == false){
                hm.put(changed[i] , 0);
            }
            hm.put(changed[i] , hm.get(changed[i]) + 1);
        }
        int k = 0;
        for(int i = 0 ; i<changed.length ; i++){
            int temp = changed[i];
            if(hm.containsKey(temp)){
                if(hm.containsKey(temp*2)){
                    ans[k++] = temp;
                    hm.put(temp , hm.get(temp) - 1);
                    hm.put(temp*2 , hm.get(temp*2) - 1);
                    if(hm.get(temp) <= 0) hm.remove(temp);
                    if(hm.containsKey(temp*2) && hm.get(temp*2) <= 0) hm.remove(temp*2);
                }
                else return new int[0];
            }
        }
        return ans;
	}

}
