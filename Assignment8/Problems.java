package Assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * Question 1 Minimum ASCII Delete Sum for Two Strings
	 */
	public int Question1(String s1, String s2) {
		// Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
		// return findAnswer(s1, s2, 0,0, dp);
		return findAnswerTop(s1, s2);
	}

	public int findAnswerTop(String s1, String s2) {
		Integer dp[][] = new Integer[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() && j == s2.length()) {
					dp[i][j] = 0;
					continue;
				}
				if (i == s1.length()) {
					dp[i][j] = dp[i][j + 1] + (int) s2.charAt(j);
					continue;
				} else if (j == s2.length()) {
					dp[i][j] = dp[i + 1][j] + (int) s1.charAt(i);
					continue;
				}
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					int sp3 = dp[i + 1][j + 1] + ((int) s1.charAt(i)) + ((int) s2.charAt(j));
					int sp1 = dp[i + 1][j] + ((int) s1.charAt(i));
					int sp2 = dp[i][j + 1] + ((int) s2.charAt(j));
					// System.out.print((int)'s' + " ");
					dp[i][j] = Math.min(sp1, Math.min(sp2, sp3));
					// return dp[i1][i2];
				}
			}
		}
		return dp[0][0];
	}

	/*
	 * Question 2 Valid Parenthesis String
	 */
	public Boolean dp[][];

	public boolean Question2(String s) {
		dp = new Boolean[s.length() + 1][s.length() + 1];
		return findAnswer(s, 0, 0, dp);
	}

	public boolean findAnswer(String s, int idx, int count, Boolean[][] dp) {
		if (s.length() <= idx) {
			if (count == 0) {
				return true;
			}
			return false;
		}
		if (count < 0) {
			return false;
		}
		if (dp[idx][count] != null) {
			return dp[idx][count];
		}
		if (s.charAt(idx) == '(') {
			dp[idx][count] = findAnswer(s, idx + 1, count + 1, dp);
			// return ;
			return dp[idx][count];
		} else if (s.charAt(idx) == ')') {
			if (count == 0) {
				dp[idx][count] = false;
			}
			dp[idx][count] = findAnswer(s, idx + 1, count - 1, dp);
			return dp[idx][count];
			// return ;
		}
		boolean sp_one = findAnswer(s, idx + 1, count + 1, dp);
		boolean sp_two = false;
		if (count > 0) {
			sp_two = findAnswer(s, idx + 1, count - 1, dp);
		}
		boolean sp_three = findAnswer(s, idx + 1, count, dp);
		dp[idx][count] = sp_one || sp_two || sp_three;
		return dp[idx][count];
	}

	/*
	 * Question 3 Delete operation for two strings.
	 */
	Integer dp_two[][];

	public int Question3(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		dp_two = new Integer[m + 1][n + 1];
		int lcs = LCS(word1, word2, m, n, dp_two);

		return m + n - (2 * lcs);
	}

	public int LCS(String s1, String s2, int m, int n, Integer[][] dp_two) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (dp[m][n] != null)
			return dp_two[m][n];
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			dp_two[m][n] = 1 + LCS(s1, s2, m - 1, n - 1, dp_two);
			return dp_two[m][n];
		}
		dp_two[m][n] = Math.max(LCS(s1, s2, m - 1, n, dp_two), LCS(s1, s2, m, n - 1, dp_two));
		return dp_two[m][n];
	}

	/*
	 * Question 4
	 * 
	 * Construct String from Binary Tree.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public String Question4(TreeNode root) {
		if (root == null) {
			return "";
		}
		if (root.left == null && root.right == null) {
			return "" + root.val;
		}
		String sp1 = Question4(root.left);
		if (root.right == null) {
			return (root.val + "(" + sp1 + ")");
		}
		String sp2 = Question4(root.right);
		return (root.val + "(" + sp1 + ")" + "(" + sp2 + ")");
	}

	/*
	 * Question 5 String Compression
	 */
	public int reverse(int num) {
		int temp = 0;
		while (num != 0) {
			int rem = num % 10;
			num = num / 10;
			temp = temp * 10 + rem;
		}
		return temp;
	}

	public int Question5(char[] chars) {
		int size = chars.length;
		int i = size - 1;
		// int count = 0;
		while (i >= 0) {
			int count = 1;
			int start = i;
			while (i > 0 && chars[i] == chars[i - 1]) {
				count++;
				i--;
			}
			int end = i;
			end++;
			if (count == 1) {
				i--;
				continue;
			}
			String cnt = Integer.toString(count);
			int j = 0;
			while (j < cnt.length()) {
				char ch = cnt.charAt(j);
				j++;
				chars[end] = ch;
				end++;
			}
			// while(count > 0)
			// {
			// int rem = count%10;
			// char ch = (char)(rem + '0');
			// chars[end] = ch;
			// end++;count = count/10;
			// }
			if (end <= start) {
				start++;
				int diff = start - end;
				while (start < size) {
					chars[end] = chars[start];
					start++;
					end++;
				}
				size = size - diff;
			}
			i--;
		}
		// System.out.println(size);
		return size;

	}

	/*
	 * Question 6 Find All Anagrams in a string
	 */
	public List<Integer> Question6(String s, String p) {
		int len = p.length();
		List<Integer> ans = new ArrayList<>();
		int[] arr = new int[26];
		for (int i = 0; i < len; i++)
			arr[p.charAt(i) - 'a']++;
		// traverse in s
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']--;
			if (i - len >= 0) {
				arr[s.charAt(i - len) - 'a']++;
			}
			if (checkZeroArr(arr)) {
				int startIndex = i - len + 1;
				ans.add(startIndex);
			}
		}
		return ans;
	}

	public boolean checkZeroArr(int[] arr) {
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Question 7 Decode String
	 */
	public boolean check(char ch) {
		int i = ch - '0';
		if (i >= 0 && i <= 9)
			return true;
		return false;
	}

	public String Question7(String s) {
		StringBuilder sb = new StringBuilder("");
		Stack<Integer> snum = new Stack<>();
		Stack<String> sstr = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (check(s.charAt(i)) == true) {
				int num = 0;
				while (i < s.length() && check(s.charAt(i)) == true) {
					num = num * 10 + Integer.parseInt("" + s.charAt(i));
					i++;
				}
				snum.push(num);
				i--;
				continue;
			} else if (s.charAt(i) == '[') {
				sstr.push("" + s.charAt(i));
			} else if (s.charAt(i) == ']') {
				sb.replace(0, sb.length(), "");
				while (sstr.isEmpty() == false && sstr.peek().equals("" + '[') == false) {
					sb.append(sstr.pop());
				}
				if (sstr.isEmpty() == false)
					sstr.pop();
				int rpt = 0;
				if (snum.isEmpty() == false) {
					rpt = snum.pop();
				}
				String tmp = sb.toString();
				while (rpt > 1) {
					rpt--;
					sb.append(tmp);
				}
				sstr.push(sb.toString());
			} else {
				sstr.push("" + s.charAt(i));
			}
		}
		StringBuilder res = new StringBuilder("");
		while (sstr.isEmpty() == false) {
			res.append(sstr.pop());
		}
		// reverse the string.
		res.reverse();
		return res.toString();
	}

	/*
	 * Question 8 Buddy Strings
	 */
	public boolean Question8(String str, String goal) {
		if (str.length() != goal.length())
			return false;
		if (str.equals(goal)) {
			HashSet<Character> hs = new HashSet<>();
			for (char ch : str.toCharArray()) {
				hs.add(ch);
			}
			if (hs.size() < str.length()) {
				return true;
			}
			return false;
		}
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != goal.charAt(i)) {
				ls.add(i);
			}
		}
		if (ls.size() == 2) {
			if (str.charAt(ls.get(0)) == goal.charAt(ls.get(1)) && goal.charAt(ls.get(0)) == str.charAt(ls.get(1))) {
				return true;
			}
		}
		return false;
	}
}
