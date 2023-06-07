package Assignment7;

import java.util.HashMap;

public class Problems {
	public static void main(String[] args) {

	}

	/*
	 * **Question 1**
	 * 
	 * Given two strings s and t, *determine if they are isomorphic*.
	 * 
	 * Two strings s and t are isomorphic if the characters in s can be replaced to
	 * get t.
	 * 
	 * All occurrences of a character must be replaced with another character while
	 * preserving the order of characters. No two characters may map to the same
	 * character, but a character may map to itself.
	 * 
	 */
	public static boolean Question1(String s, String t) {
		HashMap<Character, String> hm = new HashMap<>();
		HashMap<Character, String> hs = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hm.containsKey(ch) == false) {
				hm.put(ch, "");
			}
			hm.put(ch, hm.get(ch) + i);

		}
		for (int i = 0; i < s.length(); i++) {
			char ch = t.charAt(i);
			if (hs.containsKey(ch) == false) {
				hs.put(ch, "");
			}
			hs.put(ch, hs.get(ch) + i);
		}
		for (int i = 0; i < s.length(); i++) {
			if (hm.get(s.charAt(i)).equals(hs.get(t.charAt(i))) == false) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Question 2 Given a string num which represents an integer, return true *if*
	 * num *is a **strobogrammatic number***.
	 * 
	 * A **strobogrammatic number** is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 */
	public static boolean Question2(String n) {
		if (n == null || n.length() == 0) {
			return true;
		}
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('8', '8');
		map.put('6', '9');
		map.put('9', '6');
		int left = 0;
		int right = n.length() - 1;
		while (left <= right) {
			if (!map.containsKey(n.charAt(right)) || n.charAt(left) != map.get(n.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	/*
	 * Question 3 Given two non-negative integers, num1 and num2 represented as
	 * string, return *the sum of* num1 *and* num2 *as a string*.
	 * 
	 * You must solve the problem without using any built-in library for handling
	 * large integers (such as BigInteger). You must also not convert the inputs to
	 * integers directly.
	 */
	public static String Question_three(String num1, String num2) {
		int carry = 0;
		int dig = 0;
		int sum = 0;
		int p = 0;
		int start = num1.length() - 1;
		int end = num2.length() - 1;
		String res = "";
		while (start >= 0 && end >= 0) {
			int ch_1 = num1.charAt(start) - '0';
			int ch_2 = num2.charAt(end) - '0';
			dig = ch_1 + ch_2 + carry;
			carry = dig / 10;
			dig = dig % 10;
			res = dig + res;
			start--;
			end--;
		}
		while (start >= 0) {
			int ch_1 = num1.charAt(start) - '0';
			dig = ch_1 + carry;
			carry = dig / 10;
			dig = dig % 10;
			res = dig + res;
			start--;
		}
		while (end >= 0) {
			int ch_1 = num2.charAt(end) - '0';
			dig = ch_1 + carry;
			carry = dig / 10;
			dig = dig % 10;
			res = dig + res;
			end--;
		}
		if (carry != 0) {
			res = carry + res;
		}
		return res;
	}

	/*
	 * Question 4 Given a string s, reverse the order of characters in each word
	 * within a sentence while still preserving whitespace and initial word order.
	 */
	public static String Question4(String s) {
		String res = "";
		for (String t : s.split(" ")) {
			res += new StringBuilder(t).reverse().toString() + " ";
		}
		return res.trim();
	}

	/*
	 * Question 5 Given a string s and an integer k, reverse the first k characters
	 * for every 2k characters counting from the start of the string.
	 * 
	 * If there are fewer than k characters left, reverse all of them. If there are
	 * less than 2k but greater than or equal to k characters, then reverse the
	 * first k characters and leave the other as original.
	 */
	public static String Question5(String s, int k) {
		StringBuilder sb = new StringBuilder("");
		// abcd
		for (int i = 0; i < s.length(); i = i + 2 * k) {
			int end = i + k;
			if (i + k > s.length()) {
				end = s.length();
			}
			int end_2 = i + 2 * k;
			if (end_2 > s.length()) {
				end_2 = s.length();
			}
			String str = s.substring(i, end);
			str = new StringBuilder(str).reverse().toString() + s.substring(end, end_2);
			sb.append(str);
		}
		return sb.toString();
	}

	/*
	 * Question 6 Given two strings s and goal, return true if and only if s can
	 * become goal after some number of shifts on s.
	 */
	public static boolean Question6(String s, String goal) {
		if (s.equals(goal) == true) {
			return true;
		}
		StringBuilder sb = new StringBuilder("");
		int k = 1;
		while (k < s.length()) {
			sb.append(s.substring(k, s.length()) + s.substring(0, k));
			if (sb.toString().equals(goal)) {
				return true;
			}
			sb.delete(0, sb.length());
			k++;
		}
		return false;
	}

	/*
	 * Question 7 Given two strings s and t, return true if they are equal when both
	 * are typed into empty text editors. '#' means a backspace character.
	 */
	public static boolean Question7(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while(i >= 0 || j >= 0){
            while(i>=0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if(skipS > 0){
                    skipS--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }
                else if(skipT > 0){
                    skipT--;
                    j--;
                }
                else{
                    break;
                }
            }
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)){
                return false;
            }
            if(i >= 0 && j < 0 || i < 0 && j >= 0){
                return false;
            }
            i--;
            j--;
        }
        return true;
	}

	/*
	 * Question 8 You are given an array coordinates, coordinates[i] = [x, y], where
	 * [x, y] represents the coordinate of a point. Check if these points make a
	 * straight line in the XY plane.
	 */
	public static boolean Question8(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;
        int x0 = coordinates[0][0] , x1 = coordinates[1][0];
        int y0 = coordinates[0][1] , y1 = coordinates[1][1];
        int dx = x1 - x0 , dy = y1 - y0;
        for(int i = 2 ; i < coordinates.length ; i++)
        {
            int x = coordinates[i][0] , y = coordinates[i][1];
            if(dy * (x - x0) != dx * (y - y0))
                return false;
        }
        return true;
	}
}
