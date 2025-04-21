import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    String[] numbers = new String[n];
		    for (int i = 0; i < n; i++) {
		        numbers[i] = br.readLine();
		    } 
		    Arrays.sort(numbers);
		    
		    boolean isConsistent = true;
		    for (int i = 0; i < n - 1; i++) {
		        if (numbers[i+1].startsWith(numbers[i])) {
		            isConsistent = false;
		            break;
		        }
		    } 
		    sb.append(isConsistent ? "YES\n" : "NO\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}