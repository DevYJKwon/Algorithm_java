import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
	static int n;
	static int m;
	static char [][] map;
	static char [][] white = new char[8][8];
	static char [][] black = new char[8][8];
	static String[] wb = {"WBWBWBWB","BWBWBWBW"};
	
	
	public static int checkCnt(int r, int c) {
		int whiteCnt=0, blackCnt=0;
		for(int y=0; y<8; y++) {
			for(int x=0; x<8; x++) {
				if(white[y][x]!= map[r+y][c+x]) {
					whiteCnt++;
				}
				if(black[y][x]!=map[r+y][c+x]) {
					blackCnt++;
				}
			}
		}
		return Math.min(whiteCnt, blackCnt);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char [n][m];
		
		for(int i=0; i<8; i++) {
			String line = wb[i%2];
			for(int j=0; j<8; j++) {
				white[i][j]=line.charAt(j);
			}
		}
		
		for(int i=0; i<8; i++) {
			String line = wb[(i+1)%2];
			for(int j=0; j<8; j++) {
				black[i][j]=line.charAt(j);
			}
		}
		
		for(int y=0; y<n; y++) {
			String line = br.readLine();
			for(int x =0; x<m; x++) {
				map[y][x]=line.charAt(x);
			}
		}
		int min = m*n;
		for(int r=0; r<=n-8; r++) {
			for(int c=0; c<=m-8; c++) {
				min = Math.min(min, checkCnt(r, c));
			}
		}
		System.out.println(min);
	}

}
