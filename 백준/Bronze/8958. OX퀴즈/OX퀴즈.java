import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int result = 0;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
            result = 0;
		    String input = br.readLine();
		    int count = 0;
		    for (int i = 0; i < input.length(); i++) {
	            char spell = input.charAt(i);
		        if (spell == 'O') {
		            count+=1;
		            result += count;
		        } else {
		            count = 0;
		        }
    		} 
    		sb.append(result + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}