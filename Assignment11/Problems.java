package Assignment11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 
	 * 
	 * Sqrt(x)
	 */
	public static int Question1(int x) {
		int start = 0;
		int end = Integer.MAX_VALUE;
		int ans = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if ((long) mid * mid > (long) x) {
				end = mid - 1;
			} else if ((long) mid * mid == (long) x) {
				return mid;
			} else {
				ans = mid;
				start = mid + 1;
			}
		}
		return ans;
	}

	/*
	 * Question 2 
	 * 
	 * Find Peak Element in an array
	 */
	public static int Question2(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int ans = end;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
				// ans = mid;
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	/*
	 * Question 3 
	 * 
	 * Find missing Number
	 */
	public static int Question3(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int n = nums.length;
		int temp = ((n) * (n + 1)) / 2;
		return temp - sum;
	}

	/*
	 * Question 4 
	 * 
	 * Find Duplicate Number in the array
	 */
	public static int Question4(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int n = nums.length;
		int temp = ((n) * (n + 1)) / 2;
		return temp - sum;
	}

	/*
	 * Question 5 
	 * 
	 * Find Intersection of two Arrays
	 * 
	 */
	public static void fillHs(HashSet<Integer> hs, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i]) == false) {
				hs.add(nums[i]);
			}
		}
		return;
	}

	public static int[] Question5(int[] nums1, int[] nums2) {
		HashSet<Integer> hs = new HashSet<>();
		int[] temp;
		if (nums1.length < nums2.length) {
			fillHs(hs, nums1);
			temp = nums2;
		} else {
			fillHs(hs, nums2);
			temp = nums1;
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < temp.length; i++) {
			if (hs.contains(temp[i]) == true) {
				res.add(temp[i]);
				hs.remove(temp[i]);
			}
		}
		int[] ans = new int[res.size()];
		int i = 0;
		for (int x : res) {
			ans[i++] = x;
		}
		return ans;

	}

	/*
	 * Question 6 
	 * 
	 * find minimum in rotated sorted array
	 */
	public static int Question6(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {

				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}

	/*
	 * Question 7 
	 * 
	 * Find last and first position of an element in sorted array.
	 */
	public static int findMn(int[] nums, int target, int mid, int start) {
		int ans = mid;
		// int start = 0;
		int end = mid - 1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				ans = mid;
				end = mid - 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static int findMx(int[] nums, int target, int mid, int end) {
		int ans = mid;
		int start = mid + 1;
		// int end = mid-1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				ans = mid;
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static int[] Question7(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int[] result = { -1, -1 };
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result[0] = findMn(nums, target, mid, start);
				result[1] = findMx(nums, target, mid, end);
				break;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	/*
	 * Question 8
	 * 
	 * Intersection of two arrays part 2
	 */
	public static void fillHm(HashMap<Integer, Integer> hm, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i]) == false) {
				hm.put(nums[i], 0);
			}
			hm.put(nums[i], hm.get(nums[i]) + 1);
		}
		return;
	}

	public static int[] Question8(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] temp;
		if (nums1.length < nums2.length) {
			fillHm(hm, nums1);
			temp = nums2;
		} else {
			fillHm(hm, nums2);
			temp = nums1;
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < temp.length; i++) {
			if (hm.containsKey(temp[i]) == true) {
				if (hm.get(temp[i]) == 0) {
					continue;
				}
				hm.put(temp[i], hm.get(temp[i]) - 1);
				res.add(temp[i]);
			}
		}
		int ans[] = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}
