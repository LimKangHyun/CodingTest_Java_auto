import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int num = 1;
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		while(idx < input.length()) {
		    sb.setLength(0);
		    sb.append(num);
		    for (int i = 0; i < sb.length(); i++) {
		        if (idx == input.length()) break;
		        if (sb.charAt(i) == input.charAt(idx)) idx++; 
		    } 
		    num++;
		}
		bw.write(String.valueOf(num - 1));
		bw.flush();
	}
}