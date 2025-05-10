import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
		    char ch = input.charAt(i);
		    if (ch == 'X') {
		        count++;
		    } else {
		        if (count % 2 != 0) {
		            sb.setLength(0);
		            sb.append("-1");
		            break;
		        }
		        sb.append("AAAA".repeat(count / 4));
		        sb.append("BB".repeat(count % 4 / 2));
		        count = 0;
		        sb.append(".");
		    }
		}  
		if (count != 0 && !sb.toString().equals("-1")) {
		    if (count % 2 != 0) {
		        sb.setLength(0);
		        sb.append("-1");
		    } else {
		        sb.append("AAAA".repeat(count / 4));
		        sb.append("BB".repeat(count % 4 / 2));
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}