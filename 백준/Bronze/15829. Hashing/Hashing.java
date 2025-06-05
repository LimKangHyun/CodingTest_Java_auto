import java.io.*;

public class Main {
    private static int MOD = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		long sum = 0;
		long power = 1;
		for (int i = 0; i < input.length(); i++) {
		    int charVal = input.charAt(i) - 'a' + 1;
		    sum = (sum + charVal * power) % MOD;
		    power = (power * 31) % MOD;
		} 
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}