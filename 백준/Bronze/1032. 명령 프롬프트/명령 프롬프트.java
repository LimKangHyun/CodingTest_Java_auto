import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
		    arr[i] = br.readLine();
		} 
		int len = arr[0].length();
		for (int i = 0; i < len; i++) {
		    boolean b = true;
		    char c = arr[0].charAt(i);
		    for (int j = 1; j < n; j++) {
		        if (c != arr[j].charAt(i)) b = false; 
		    } 
		    if (b) sb.append(c);
		    else sb.append('?');
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}