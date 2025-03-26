import java.io.*;
import java.util.*;

public class Main {
    private static int[] answer;
    private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int N = Integer.parseInt(br.readLine());
	    int[] arr = new int[N];
	    answer = new int[2];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    } 
	    
	    Arrays.sort(arr);
	    twoPointer(arr);
	    for(int i : answer) {
	        bw.write(String.valueOf(i));
	        bw.write(" ");
	    }
	    bw.flush();
	}
	private static void twoPointer(int[] arr) {
	    int left = 0;
	    int right = arr.length - 1;
	    
	    while(left < right) {
	        if(min > Math.abs(arr[left] + arr[right])) {
	            min = Math.abs(arr[left] + arr[right]);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
	        if(arr[left] + arr[right] == 0) {
	            return;
	        }
	        else if(arr[left] + arr[right] > 0) {
	            right--;
	        } else {
	            left++;
	        }
	    }
	}
}