import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int zeroCount = 0;
		int oneCount = 0;
		
		if (input.charAt(0) == '0') zeroCount++;
		else oneCount++;
		
		for (int i = 1; i < input.length(); i++) {
		    if (input.charAt(i - 1) != input.charAt(i)) {
		        if (input.charAt(i) == '0') zeroCount++;
		        else oneCount++;
		    }
		} 
		bw.write(String.valueOf(Math.min(zeroCount, oneCount)));
		bw.flush();
	}
}