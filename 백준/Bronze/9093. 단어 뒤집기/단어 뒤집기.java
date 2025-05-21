import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
		    String[] input = br.readLine().split(" ");
		    for (String word : input) {
		        for (int j = word.length() - 1; j >= 0; j--) {
		            sb.append(word.charAt(j));
		        } 
		        sb.append(" ");
		    } 
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}