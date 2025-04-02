import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        br.close();
        
        int diagonal = 1; // 현재 대각선 번호
        int sum = 1; // 현재 대각선까지의 합
        
        // X번째 숫자가 어느 대각선에 위치하는지 찾기
        while (sum < X) {
            diagonal++;
            sum += diagonal;
        }
        
        // 대각선에서 X번째 숫자의 위치 찾기
        int position = X - (sum - diagonal);
        
        int numerator, denominator;
        
        // 홀수 번째 대각선 (위에서 아래로 진행)
        if (diagonal % 2 == 1) {
            numerator = diagonal - (position - 1);
            denominator = position;
        } 
        // 짝수 번째 대각선 (아래에서 위로 진행)
        else {
            numerator = position;
            denominator = diagonal - (position - 1);
        }

        // 결과 출력
        bw.write(numerator + "/" + denominator + "\n");
        bw.flush();
    }
}