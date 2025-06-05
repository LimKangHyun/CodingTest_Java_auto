import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		long sum = 0;
		for (int i = 0; i < input.length(); i++) {
		    sum += (input.charAt(i) - 'a' + 1) * Math.pow(31, i);
		} 
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}