import java.io.*;

public class Main {
    private static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		int size = (int) Math.pow(2, N);
		findCount(r, c, size);
		bw.write(String.valueOf(count));
		bw.flush();
	}// 열 세는게 x, 행 세는게 y
	private static void findCount(int x, int y, int size) {
	    if (size == 1) return;
	    
	    if (x < size / 2 && y < size / 2) {
	        // 여기부터 차례대로 1 구역
	        findCount(x, y, size / 2);
	    } else if (x < size / 2 && y >= size / 2) {
	        // 오른쪽 위 -> 1 구역을 거침
	        count += (size * size / 4);
	        findCount(x, y - (size / 2), size / 2);
	    } else if (x >= size / 2 && y < size / 2) {
	        // 왼쪽 아래 -> 1, 2 구역을 거침
	        count += (size * size / 4) * 2;
	        findCount(x - (size / 2), y, size / 2);
	    } else {
	        // 오른쪽 아래 -> 1, 2, 3 구역을 거침
	        count += (size * size / 4) * 3;
	        findCount(x - (size / 2), y - (size / 2), size / 2);
	    }
	}
}