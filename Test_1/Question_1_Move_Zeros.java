package Test_1;

public class Question_1_Move_Zeros {
	public static void main(String[] args) {
		solution sol = new solution();
		/*
		 * Input: nums = [0,1,0,3,12]
		 * Output: [1,3,12,0,0]
		 */
		int[] nums = {0,1,0,3,12};
		sol.moveZeroes(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
		return;
	}
}

class solution {
	public void moveZeroes(int[] nums) {
		int cnt = 0;
		int i = 0;
		int p = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				cnt++;
			} else {
				nums[p] = nums[i];
				p++;
			}
			i++;
		}
		while (cnt > 0) {
			cnt--;
			nums[p++] = 0;
		}
		return;
	}
}
