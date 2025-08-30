import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int num = 1;
		int idx = 0;
		while(idx < input.length()) {
		    String numStr = String.valueOf(num);
		    for (char c : numStr.toCharArray()) {
		        if (idx == input.length()) break; 
		        if (c == input.charAt(idx)) idx++; 
		    } 
		    num++;
		}
		bw.write(String.valueOf(num - 1));
		bw.flush();
	}
}