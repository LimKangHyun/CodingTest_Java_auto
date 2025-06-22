import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;
            String[] parts = line.split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);
            if (name.equals("#") && age == 0 && weight == 0) {
                break;
            }
            if (age > 17 || weight >= 80) {
                bw.write(name + " Senior\n");
            } else {
                bw.write(name + " Junior\n");
            }
        }
        bw.flush();
    }

}