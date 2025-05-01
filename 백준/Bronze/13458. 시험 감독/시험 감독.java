import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        String[] dir = br.readLine().split(" ");
        int head = Integer.parseInt(dir[0]);
        int sub = Integer.parseInt(dir[1]);
        long answer = N;
        for (int i = 0; i < N; i++) {
            int student = Integer.parseInt(input[i]) - head;
            if (student <= 0) continue;
            answer += (student + sub - 1) / sub;
        } 
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}