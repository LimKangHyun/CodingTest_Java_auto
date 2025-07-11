import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int l = Integer.parseInt(br.readLine());
		int low = 0;
		int high = 1000;
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    if (num == n) {
		        count++;
		        break;
		    } 
		    if (num < n && low < num) low = num;
		    if (num > n && high > num) high = num;
		} 
		int result = 0;
		if (count == 1) {
		    bw.write(String.valueOf(0));
		} else {
		    for (int i = low + 1; i <= n; i++) {
		        for (int j = n; j < high; j++) {
		            if (i != j) result++; 
		        } 
		    } 
		    bw.write(String.valueOf(result));
		}
		bw.flush();
	}
}