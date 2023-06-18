package Test_1;

public class Question_sqrt_Test2 {
	public static int mySqrt(int x) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((long)mid*mid > (long)x){
                end = mid-1;
            }
            else if((long)mid*mid == (long)x){
                return mid;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		int testcase = 2;
		int[] arr = new int[2];
		arr[0] = 4;
		arr[1] = 8;
		while(testcase-- > 0) {
			System.out.println(mySqrt(arr[testcase]));
		}
	}
}
