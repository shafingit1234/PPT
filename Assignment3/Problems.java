package Assignment3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Given an integer array nums of length n and an integer target,
	 * find three integers in nums such that the sum is closest to the target.
	 * Return the sum of the three integers.
	 */
	public static int Question1(int [] nums, int target) {
		Arrays.sort(nums);
        int n = nums.length ;
        int ans = nums[0] + nums[1] + nums[2];
        if(n == 3){
            // int ans = nums[0] + nums[1] + nums[2];
            return ans;
        }
        for(int i=0 ; i<n-2 ; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                if(sum >= target){
                    right--;
                }
                else{
                    left++;
                }
                int diff = sum - target;
                if(Math.abs(diff) < Math.abs(ans - target)){
                    ans = sum;
                }
            }
        }
        return ans;
	}

	/*
	 * Question 2 Given an array nums of n integers, return an array of all the
	 * unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
	 */
	public static int len = 0;
	public static List<List<Integer>> Question2(int[] nums, int target) {
		Arrays.sort(nums);
        len = nums.length;
        return findAnswer(nums, target, 4, 0);
	}
	public static List<List<Integer>> findAnswer(int[] nums, long target, int k, int index){
        List<List<Integer>> res = new ArrayList<>();
        if(index >= len){
            return res;
        }

        if(k == 2){
            int i = index;
            int j = nums.length-1;
            while(i < j){
                if(target == nums[i] + nums[j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add((int)(target-nums[i]) );
                    res.add(temp);
                    while(i < j && nums[i] == nums[i+1]){
                        i++;
                    }
                    while(i < j && nums[j-1] == nums[j]){
                        j--;
                    }
                    i++;
                    j--;
                }
                else if(target - nums[i] >= nums[j]){
                    i++;
                }
                else if(target - nums[i] < nums[j]){
                    j--;
                }
            }
        }
        else{
            for(int i=index; i<len - k + 1 ; i++){
                List<List<Integer>> temp = findAnswer(nums, target - nums[i], k-1 , i+1);
                if(temp!=null){
                    for(List<Integer> t : temp){
                        t.add(nums[i]);
                    }
                    res.addAll(temp);
                }
                //remove duplicate current values;
                while(i < len - 1 && nums[i] == nums[i+1]){
                    i++;
                }
                // res.addAll(temp);
            }
        }
        return res;
    }
	/*
	 * Question 3 A permutation of an array of integers is an arrangement of its
	 * members into a sequence or linear order.
	 */
	public static void Question3(int[] nums) {
		int end = nums.length-1;
        int start = end-1;
        if(end == 0)
        {
            return ;
        }
        if(nums[start] < nums[end])
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            return;
        }
        start--;
        end--;
        int i;
        for(i = start ;i>=0 ; i--)
        {
            if(nums[start] >= nums[end])
            {
                start--;
                end--;
            }
            else{
                findNum(nums, start, nums.length-1);
                break;
            }
        }
        if(i<0)
        {
            reverse(nums, 0, nums.length-1);
        }
        return ;
	}
	public static void reverse(int [] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return ;
    }
	public static void findNum(int[] nums, int start, int end)
    {
        //find next maximum
        int i;
        for(i = end ; i>start ; i--)
        {
            if(nums[i] > nums[start])
            {
                break;
            }
        }
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i]= temp;
        reverse(nums , start + 1, end);
        return ;
    }
	/*
	 * Question 4 Given a sorted array of distinct integers and a target value,
	 * return the index if the target is found. If not, return the index where it
	 * would be if it were inserted in order.
	 */
	public static int Question4(int[] arr, int target) {
		int low = 0;
        int high = arr.length-1;
        int mid = -1;
        while(low <= high)
        {
            mid = low + (high - low)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        int i = mid;
        for(; i<arr.length; i++)
        {
            if(arr[i] > target) break; 
        }
        return i;
	}

	/*
	 * Question 5 You are given a large integer represented as an integer array
	 * digits, where each digits[i] is the ith digit of the integer. The digits are
	 * ordered from most significant to least significant in left-to-right order.
	 * The large integer does not contain any leading 0's.
	 */
	public static int[] Question5(int [] digits) {
		int cnt = 0;
        for(int i=digits.length-1 ; i>=0 ; i--){
            if(digits[i] == 9){
                cnt++;
            }
            else{
                break;
            }
        }
        if(cnt == digits.length){
            int ans[] = new int[digits.length + 1];
            ans[0] = 1;
            for(int i=1 ; i<=digits.length ; i++){
                ans[i] = 0;
            }
            return ans;
        }
        if(cnt == 0){
            digits[digits.length - 1]++;
            return digits;
        }
        int p = 0;
        while(cnt > 0){
            digits[digits.length - p - 1] = 0;
            cnt--;
            p++;
        }
        digits[digits.length-p-1]++;
        return digits;
	}

	/*
	 * Question 6 Given a non-empty array of integers nums, every element appears
	 * twice except for one. Find that single one.
	 */
	public static int Question6(int [] nums) {
		int num = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            num ^= nums[i];
        }
        return num;
	}

	/*
	 * Question 7 You are given an inclusive range [lower, upper] and a sorted
	 * unique integer array nums, where all elements are within the inclusive range.
	 */
	public static List<String> Question7(int[] nums) {
		Arrays.sort(nums);
        List<String> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        boolean check = false;
        StringBuilder res = new StringBuilder("");
        for(int i=0 ; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]-1){
                if(check == true) continue;
                res.append("" + nums[i] + "->");
                check = true;
            }
            else{
                res.append("" + nums[i]);
                ans.add(res.toString());
                res.delete(0 , res.length());
                check = false;
            }
        }
        res.append("" + nums[nums.length-1]);
        ans.add(res.toString());
        return ans;
	}

	/*
	 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
	 * determine if a person could attend all meetings.
	 */
	public static int Question8(int[][] events) {
		Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] -b[1] : a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        int event_attended = 0;
        int current_date = 0;
        int i=0;
        while(i < events.length){
            while(i < events.length && events[i][0] <= current_date && events[i][1] >= current_date){
                pq.add(events[i++]);
            }
            
            if(pq.isEmpty() == false){
                // event_attended++;
                int[] temp = pq.poll();
                // System.out.print(temp[0] + " " + temp[1] + " " + current_date + "   ");
                if(temp[0] <= current_date && current_date <= temp[1]){
                    event_attended++;
                    current_date++;
                }
            }
            if(pq.isEmpty() == true && i<events.length){
                current_date = events[i][0];
            }
        }
        while(pq.isEmpty() == false){
            int [] temp = pq.poll();
            // System.out.print(temp[0] + " " + temp[1] + " " + current_date + "   ");
            if(temp[0] <= current_date && current_date <= temp[1]){
                event_attended++;
                current_date++;
            }
        }
        return event_attended;
	}

}
