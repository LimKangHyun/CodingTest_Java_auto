import java.io.*;
import java.util.*;

public class Main {
    private static int[][] abcd;
    private static int[] ab;
    private static int[] cd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		abcd = new int[n][4];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 4; j++) {
		        abcd[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		ab = new int[n*n];
		cd = new int[n*n];
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        ab[i*n + j] = abcd[i][0] + abcd[j][1];
		        cd[i*n + j] = abcd[i][2] + abcd[j][3];
		    } 
		}
		bw.write(String.valueOf(twoPointer()));
		bw.flush();
	}
	private static long twoPointer() {
	    Arrays.sort(ab);
	    Arrays.sort(cd);
	    int abp = 0;
	    int cdp = cd.length - 1;
	    long count = 0;
	    while(abp < ab.length && cdp > -1) {
	        int abv = ab[abp];
	        int cdv = cd[cdp];
	        int sum = abv + cdv;
	        if (sum == 0) {
	            long abDupCount = 0;
	            long cdDupCount = 0;
	            while(abp < ab.length && ab[abp] == abv) {
	                abp++;
	                abDupCount++;
	            }
	            while(cdp > -1 && cd[cdp] == cdv) {
	                cdp--;
	                cdDupCount++;
	            }
	            count += abDupCount * cdDupCount;
	        } else if (sum < 0) {
	            abp++;
	        } else {
	            cdp--;
	        }
	    }
	    return count;
	}
}