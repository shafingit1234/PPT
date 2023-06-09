package Assignment9;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question1 Power of two
	 */
	public static boolean Question1(int n) {
		int count = 0;
		if (n < 0) {
			return false;
		}
		n = Math.abs(n);
		for (int i = 31; i >= 0; i--) {
			if (((1 << i) & n) > 0) {
				count++;
			}
		}
		if (count != 1) {
			return false;
		}
		return true;
	}

	/*
	 * Question2
	 */
	public static int Question2(int n) {
		if (n == 0) {
			return 0;
		}
		return n + Question2(n - 1);
	}

	/*
	 * Question 3 Factorial of a number
	 */
	public static int Question3(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return num * Question3(num - 1);
	}

	/*
	 * Question 4 Pow(x,n)
	 */
	public static double Question4(double x, int n) {
		if (x < -10000 || x > 10000) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		if (n % 2 == 0) {
			return Question4(x * x, n / 2);
		}
		return x * Question4(x, n - 1);
	}

	/*
	 * Question 5 Recursive program to find min and max elements of array.
	 */
	public static void Question5(int A[], int n) {
		int min = findMinRec(A, n);
		int max = findMaxRec(A, n);
	}

	public static int findMinRec(int A[], int n) {
		if (n == 1) {
			return A[0];
		}
		return Math.min(A[n - 1], findMinRec(A, n - 1));
	}

	public static int findMaxRec(int A[], int n) {
		if (n == 1) {
			return A[0];
		}
		return Math.max(A[n - 1], findMaxRec(A, n - 1));
	}

	/*
	 * Question 6 Program for Nth term of arithmetic progression series.
	 */
	public static int Question6(int a, int d, int N) {
		return a + (N - 1) * d;
	}

	/*
	 * Question 7 Permutation in a string
	 */
	public static boolean Question7(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] arr = new int[26];
		int len = s1.length();
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length(); i++) {
			arr[s2.charAt(i) - 'a']--;
			if (i - len >= 0) {
				arr[s2.charAt(i - len) - 'a']++;
			}
			if (checkForZero(arr)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkForZero(int[] arr) {
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Question 8
	 * Product of array except self
	 */
	public static int[] Question8(int[] nums) {
		int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prod = 1;
        int mult = 1;
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 0 ; i <nums.length ; i++)
        {
            left[i] = mult;
            mult *= nums[i];
        }
        mult = 1;
        int j = 0;
        for(int i = nums.length-1 ; i>=0 ; i--)
        {
            right[i] = mult;
            mult*=nums[i];
        }
        for(int i = 0 ; i<nums.length ; i++)
        {
            nums[i]= left[i] * right[i];
        }
        return nums;
	}
}
