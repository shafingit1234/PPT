package Test_1;

public class Question_2_find_unique_character {
	public static void main(String[] args) {
//		solution sol = new solution();
		String str = "loveleetcodeduh";
		System.out.println(firstUniqChar(str));
	}
	public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0 ; i<s.length() ; i++){
            if(freq[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
