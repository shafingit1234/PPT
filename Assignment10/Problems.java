package Assignment10;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 power of Three
	 */
	public static boolean Question1(int n) {
		if (n == 0)
			return false;
		if (n == 1)
			return true;

		if (n % 3 != 0)
			return false;

		return Question1(n / 3);
	}

	/*
	 * Question 2 Elimination Game
	 */
	public static int Question2(int n) {
		if (n == 1) {
			return 1;
		}
		return 2 * ((n / 2) - Question2(n / 2) + 1);
	}

	/*
	 * Question 3 Power set
	 */
	public static String curr = "";

	public static void Question3(String str, int index, String curr) {
		int n = str.length();
		if (index == n) {
			return;
		}

		System.out.println(curr);

		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			Question3(str, i, curr);
			curr = curr.substring(0, curr.length() - 1);
		}
	}

	/*
	 * Question 4 Length of a string using recursion
	 */
	public static int Question4(String str) {
		if (str.equals(""))
			return 0;
		else
			return Question4(str.substring(1)) + 1;
	}

	/*
	 * Question 5 use recursion to count substrings having same first and last
	 * characters.
	 */
	public static int Question5(String str, int i, int j, int n) {
		if (n == 1)
			return 1;
		if (n <= 0)
			return 0;

		int res = Question5(str, i + 1, j, n - 1) + Question5(str, i, j - 1, n - 1)
				- Question5(str, i + 1, j - 1, n - 2);

		if (str.charAt(i) == str.charAt(j))
			res++;

		return res;
	}

	/*
	 * Question 6 Tower of hanoi
	 */
    public static long Question6(int N, int from, int to, int aux) {
        // Your code here
        if(N == 1){
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            return 1;
        }
        long sp1 = Question6(N-1 , from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        long sp2 = Question6(N-1, aux, to, from);
        return sp1 + sp2 + 1;
    }

	/*
	 * Question 7 Print all permutation of string
	 */
	public static void Question7(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			Question7(ros, ans + ch);
		}
	}

	/*
	 * Question 8 Count Consonants in a string
	 */
	public static boolean isConsonant(char ch) {
		// To handle lower case
		ch = Character.toUpperCase(ch);

		return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') == false && ch >= 65 && ch <= 90;
	}

	public static int Question8(String str, int n) {
		if (n == 1) {
			if (isConsonant(str.charAt(0)))
				return 1;
			else
				return 0;
		}

		if (isConsonant(str.charAt(n - 1)))
			return Question8(str, n - 1) + 1;
		else
			return Question8(str, n - 1);
	}
}
