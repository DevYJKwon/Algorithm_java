import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2563 {
	/*
	 * 크기가 각각 100
	 * 각 라인마다 확인해서 넓이 구하기 1칸이 1크기임
	 * 왼벽부터 도화지 왼쪽 거리 ,  아래벽부터 아래쪽 도화지 거리
	 */
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean [][] map = new boolean [100][100];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			for(int y = 0; y<10; y++) {
				for(int x=0; x<10; x++) {
					map[startY+y][startX+x]=true;
				}
			}
		}
		int res=0;
		for(int y = 0; y<100; y++) {
			for(int x=0; x<100; x++) {
				if(map[y][x]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
