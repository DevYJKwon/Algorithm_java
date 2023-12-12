import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1873 {
	/*
	 * 벽돌벽은 부셔짐 강철은 아무런 일 없음
	 */
	static char [][] map;
	static int h,w;
	static Point pos;
	static void play(char order) {
	
		switch(order) {
		case 'U':
			if(pos.y -1 >= 0 && map[pos.y-1][pos.x] == '.') {
				map[pos.y][pos.x] = '.';
				pos.y=pos.y-1;
			}
			map[pos.y][pos.x] = '^';
			break;
		case 'D':
			if(pos.y +1 < h && map[pos.y+1][pos.x] == '.') {
				map[pos.y][pos.x] = '.';
				pos.y=pos.y+1;
			}
			map[pos.y][pos.x] = 'v';
			break;
		case 'L':
			if(pos.x -1 >= 0 && map[pos.y][pos.x-1] == '.') {
				map[pos.y][pos.x] = '.';
				pos.x=pos.x-1;
			}
			map[pos.y][pos.x] = '<';
			break;
		case 'R':
			if(pos.x +1 < w && map[pos.y][pos.x+1] == '.') {
				map[pos.y][pos.x] = '.';
				pos.x=pos.x+1;
			}
			map[pos.y][pos.x] = '>';
			break;
		case 'S':
			int d=1;
			int dx=0;
			int dy=0;
			if(map[pos.y][pos.x] == '^') {
				dx = 0;
				dy=-1;
			}
			else if(map[pos.y][pos.x] == '<') {
				dx=-1;
				dy=0;
			}
			else if(map[pos.y][pos.x] == '>') {
				dx=1;
				dy=0;
			}
			else { //down
				dx=0;
				dy=1;
			}
			
			while(true) {
				int ny = dy*d+pos.y;
				int nx = dx*d+pos.x;
				
				if(nx >=0 && ny>=0 && nx<w && ny<h) {
					if(map[ny][nx]=='*') {
						map[ny][nx]='.';
						break;
					}
					else if(map[ny][nx]=='#') {
						break;
					}
					d++;
					continue;
				}
				break;
			}
			break;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=testCase; t++) {
			
			st = new StringTokenizer(br.readLine());
			h  = Integer.parseInt(st.nextToken()); 
			w = Integer.parseInt(st.nextToken());
			map = new char  [h][w];
			
			for(int y=0; y<h; y++) {
				String str = br.readLine();
				for(int x=0; x<w; x++) {
					map[y][x]=str.charAt(x);
					if(map[y][x] == '<' || map[y][x] == '>' || map[y][x] == '^' || map[y][x]=='v') {
						pos = new Point(x,y);
					}
				}
			}
			
			int orderSize = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int i=0; i<orderSize; i++) {
				play(str.charAt(i));
			}
			sb.append("#"+t+" ");
			for(int y=0; y<h; y++) {
				for(int x=0; x<w; x++) {
					sb.append(map[y][x]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
