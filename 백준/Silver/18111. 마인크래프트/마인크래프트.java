
import java.io.*;
import java.util.*;


public class Main {
    static int N,M,B, max = 0, min = 256, answer = Integer.MAX_VALUE, height;
    static int[][] block;	//블록 정보 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        block = new int[N][M];
        //블록 내용 및 최대 높이, 최소 높이 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                int h = Integer.parseInt(st.nextToken());
                block[i][j] = h;
                min = Math.min(h, min);
                max = Math.max(h, max);
            }
        }
        //높이 모든 경우 탐색
        for(int i=max;i>=min;i--)
            blockCheck(i);
        bw.write(answer + " " + height);	//최소 시간 및 높이 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //해당 높이 만들 수 있는지 확인 및 시간 구하는 함수
    static void blockCheck(int h){
        int time = 0;
        int b = B;
        //각 블록 높이 변경하기.
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(time > answer)	//최소 시간보다 커질 경우 종료.
                    return;
                if(block[i][j] > h){	//땅 파기.
                    int sub = block[i][j] - h;
                    time += 2 * sub;
                    b += sub;
                }else if(block[i][j] < h){	//땅 놓기
                    int sub = h - block[i][j];
                    time += sub;
                    b -= sub;
                }
            }
        }
        //최소 시간 비교하기.
        if(b >= 0 && answer > time){
            answer = time;
            height = h;
        }
    }
}