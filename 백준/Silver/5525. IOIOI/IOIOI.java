import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int count = 0;
		int pattern = 0;
		
		for (int i = 1; i < m - 1; ) {
		    if (input.charAt(i-1) == 'I' && input.charAt(i) == 'O' && input.charAt(i+1) == 'I') {
		        pattern++;
		        i += 2;
		        // 상위 조건이 만족되는 경우 IOI를 재사용 하기 위해 pattern--
		        if (pattern == n) {
		            count++;
		            pattern--;
		        } 
		    } else {
		        pattern = 0;
		        i++;
		    }
		} 
		bw.write(count + "\n");
		bw.flush();
	}
}