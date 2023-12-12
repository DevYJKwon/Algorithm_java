import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1679 {
	static int start,end,min=Integer.MAX_VALUE;
	
	static void bfs() {
		boolean [] visited = new boolean [100001];
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(start,0));
		visited[start]=true;
		
		while(true) {
			Point cur = q.poll();
			if(cur.x == end) {
				min = Math.min(min, cur.y);
				break;
			}
			if(cur.x-1 >= 0) {
				if(!visited[cur.x-1]) {
					visited[cur.x-1]=true;
					q.add(new Point(cur.x-1,cur.y+1));
				}
			}
			if(cur.x+1 <= 100000) {
				if(!visited[cur.x+1]) {
					visited[cur.x+1]=true;
					q.add(new Point(cur.x+1,cur.y+1));
				}
			}
			if(cur.x*2 <= 100000) {
				if(!visited[cur.x*2]) {
					visited[cur.x*2]=true;
					q.add(new Point(cur.x*2,cur.y+1));
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start= Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(min);
	}

}
