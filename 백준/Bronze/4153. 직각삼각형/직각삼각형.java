import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    String[] input = br.readLine().split(" ");
		    int a = Integer.parseInt(input[0]);
		    int b = Integer.parseInt(input[1]);
		    int c = Integer.parseInt(input[2]);
		    
		    if (a == 0 && b == 0 && c == 0) break;
		    if ((a * a + b * b) == c * c) {
		        sb.append("right\n");
		    } else if ((b* b + c * c) == a * a) {
		        sb.append("right\n");
		    } else if ((a * a + c * c) == b* b) {
		        sb.append("right\n");
		    } else {
		        sb.append("wrong\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}