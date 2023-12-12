import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea5656 {
	static int [][] map;
	static int [][] temp;
	
	static int fall(Point start) {
		if(start == null) {
			return 0;
		}
		boolean [][] visited = new boolean [height][width];
		int cnt=0;
		
		int [] dy = {1,0,0,-1};
		int [] dx = {0,-1,1,0};
		
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		visited[start.y][start.x]=true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int c = temp[cur.y][cur.x];
			temp[cur.y][cur.x]=0;
			cnt++;
			
			for(int i=0; i<4; i++) {
				int nx = cur.x;
				int ny = cur.y;
				for(int j=1; j<c; j++) {
					nx+=dx[i];
					ny+=dy[i];
					if(nx>=0 && ny>=0 && nx <width && ny < height && temp[ny][nx]!=0 && !visited[ny][nx]) {
						q.add(new Point(nx,ny));
						visited[ny][nx]=true;
					}
				}
			}
		}
		return cnt;
	}
	
	static void gravity() {
		for(int y=height-1; y>=0; y--) {
			for(int x=0; x<width; x++) {
				if(temp[y][x]==0) {
					for(int i=y-1; i>=0; i--) {
						if(temp[i][x] != 0) {
							temp[y][x]=temp[i][x];
							temp[i][x]=0;
							break;
						}
					}
				}
			}
		}
	}
	
	static void np(int nth, int [] chosen) {
		if(min==0) {
			return;
		}
		if(nth == chosen.length) {
			int sum=0;
			//맵 복사
			temp = new int [height][width];
			for(int i=0; i<map.length; i++) {
				temp[i]= Arrays.copyOf(map[i], map[i].length);
			}
			//공 떨어트리기
			for(int i=0; i<chosen.length; i++) {
				int x = chosen[i];
				Point start=null;
				for(int y=0; y<height; y++) {
					if(temp[y][x] !=0) {
						start = new Point(x,y);
						break;
					}
				}
				sum+=fall(start);
				gravity();
			}
			
			min = Math.min(min,blocks-sum);
			return;
		}
		
		for(int i=0; i<width; i++) {
			chosen[nth]=i;
			np(nth+1,chosen);
		}
	}
	static void printMap() {
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				System.out.print(temp[y][x]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int width,height,min,blocks;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			map = new int [height][width];
			min=255;
			blocks=0;
			for(int y=0; y<height; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<width; x++) {
					map[y][x]=Integer.parseInt(st.nextToken());
					if(map[y][x]!=0) {
						blocks++;
					}
				}
			}
			if(blocks > 0) {
				np(0,new int[n]);
			}
			else {
				min = blocks;
			}
			sb.append(String.format("#%d %d\n", t,min));
		}
		System.out.println(sb);
	}

}
