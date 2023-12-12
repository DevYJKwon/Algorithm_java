import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2239 {

	static int[][] map;

	static void dfs() {
		Point next = getNext();
		if (next.x==-1) {
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					System.out.print(map[y][x]);
				}
				System.out.println();
			}
			System.exit(0);
		} 
		for(int i=1; i<10; i++) {
			if(valid(next,i)) {
				map[next.y][next.x]=i;
				dfs();
				map[next.y][next.x]=0;
			}
		}
	}

	static Point getNext() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (map[y][x] == 0) {
					return new Point(x, y);
				}
			}
		}
		return new Point(-1, -1);
	}
	
	static boolean valid(Point next,int num) {
		for (int x = 0; x < 9; x++) {
			if(map[next.y][x]==num) {
				return false;
			}
		}
		for (int y = 0; y < 9; y++) {
			if(map[y][next.x]==num) {
				return false;
			}
		}
		int x= next.x/3*3;
		int y= next.y/3*3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(map[y+i][x+j]==num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int y = 0; y < 9; y++) {
			String str = br.readLine();
			for (int x = 0; x < 9; x++) {
				map[y][x] = str.charAt(x) - '0';
			}
		}
		dfs();
	}

}
