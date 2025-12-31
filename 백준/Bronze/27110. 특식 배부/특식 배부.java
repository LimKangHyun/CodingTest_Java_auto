import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = 0;

        if (a >= n) {
            sum += n;
        } else { // a < n
            sum += a;
        }
        if (b >= n) {
            sum += n;
        } else { // b < n
            sum += b;
        }
        if (c >= n) {
            sum += n;
        } else { // c < n
            sum += c;
        }
        System.out.println(sum);
    }
}