import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
	
	public static int N, M;
	public static long[] arr;
	public static long answer = 3000000001L;
	public static long[] answerArr = new long[3];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	arr = new long[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	
    	for(int i=0;i<N-2;i++) { //3가지 용액을 더하기에 1가지 용액을 확정적으로 더하면 2가지 용액을 고려하여 N-2번까지 돌린다.
    		twoPointer(i);
    	}
    	
    	Arrays.sort(answerArr);
    	System.out.println(answerArr[0]+" "+answerArr[1]+" "+answerArr[2]);
	}
	
	public static void twoPointer(int fixedIdx) {
		int start = fixedIdx + 1; //확정적으로 더할 용액보다 한개 더 큰 곳에서 시작한다.
		int end = N - 1; //마지막 용액에서 시작한다.
		
		while(start < end) {
			long value = arr[start] + arr[end] + arr[fixedIdx];
			long absValue = Math.abs(value);
			
			if(answer > absValue) {
				answer = absValue;
				answerArr[0] = arr[fixedIdx];
				answerArr[1]= arr[start];
				answerArr[2] = arr[end];
			}
			
			if(value <= 0) {
				start += 1;
			}else if(value > 0) {
				end -= 1;
			}
			
		}
	}
	
}