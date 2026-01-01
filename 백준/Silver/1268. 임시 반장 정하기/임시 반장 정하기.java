import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int input[][] = new int[N][5];

        for (int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j< 5; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int student_num = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j< N; j++) {
                if (i==j) continue;
                for (int k = 0; k < 5; k++) {
                    if (input[i][k] == input[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (max < cnt){
                max = cnt;
                student_num = i;
            }
        }
        System.out.println(student_num+1);
    }
}