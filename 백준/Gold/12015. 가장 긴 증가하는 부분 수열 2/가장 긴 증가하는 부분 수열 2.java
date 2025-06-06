import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] lis = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		lis[0] = arr[0];
		int lisLength = 1;
		
		for (int i = 0; i < n; i++) {
		    int key = arr[i];
		    
		    if (lis[lisLength - 1] < key) {
		        lisLength++;
		        lis[lisLength - 1] = key;
		    } else {
		        int low = 0;
		        int high = lisLength;
		        while (low < high) {
		            int mid = (low + high) / 2;
		            if (lis[mid] < key) {
		                low = mid + 1;
		            } else {
		                high = mid;
		            }
		        }
		        // 구성된 lis 배열에서 key 값보다 크거나 같은 숫자중 가장 앞쪽의 수를 찾아서 key로 교체
		        // 뒤에 올 수 있는 수의 하한선이 내려가므로
		        lis[low] = key;
		    }
		} 
		bw.write(String.valueOf(lisLength));
		bw.flush();
	}
}