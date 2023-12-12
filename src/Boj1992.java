import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {
		
	static int [][] map;
	
	static String div(int sc,int sr, int size) {
		int sum=0;
		for(int y=0; y<size; y++) {
			for(int x=0;x<size; x++) {
				sum += map[sr+y][sc+x];
			}
		}
		
		if(sum == 0) {
			return "0";
		}
		else if(sum == size*size) {
			return "1";
		}
		else {
			return "("+div(sc, sr,size/2)+div(sc+size/2,sr,size/2)+
					div(sc, sr+size/2,size/2)+div(sc+size/2,sr+size/2,size/2)+")";
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		for(int y=0; y<n; y++) {
			String str = br.readLine();
			for(int x=0; x<n; x++) {
				map[y][x] = str.charAt(x)-'0';
			}
		}
		
		System.out.println(div(0,0,n));
		
	}

}
