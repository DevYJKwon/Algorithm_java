import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Swea1767 {
	/*
	 * NxN 셀 
	 * 각 셀에는 코어 또는 전선이 들어갈 수 있다.
	 * 전선은 교차할 수 없다.
	 * 가장자리는 파워가 흐름. 
	 * 7<=N<=12 1<=C<=12
	 * 최대한 많은 코어를 연결하였을 때, 최소 전선 길이의 합
	 * 0은 빈 셀 , 1은 코어 , 2는 전선
	 * 60개 4초 -> 1개 66.7ms
	 */
	static class Core{
		int x,y;
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,minLine,maxCore,cnt;
	static int [][] map;
	static List <Core> list = new ArrayList<>();
	static int [] dy = {-1,1,0,0}; // 상 하 좌 우 
	static int [] dx = {0,0,-1,1};
	
	
	static void check(int nth,int core,int line) {
		if(nth == list.size()) {
			if(maxCore < core) {
				maxCore = core;
				minLine = line;
			}
			else if(maxCore == core) {
				minLine = Math.min(line, minLine);
			}
			return;
		}
		if(core + list.size()-nth < maxCore) {
			return;
		}
		
		Core c = list.get(nth);
		
		for(int i=0; i<4; i++) {
			if(isConnectable(c,i)) {
				fill(c,i,2);
				check(nth+1,core+1,line+cnt);
				fill(c,i,0);
			}
		}
		check(nth+1,core,line);
	}
	
	static boolean isConnectable(Core c, int d) {
		int x=c.x+dx[d];
		int y=c.y+dy[d];
		while (x >= 0 && y >= 0 && x < n && y < n) {
            if(map[y][x]!=0) {
            	return false;
            }
            x = x + dx[d];
            y = y + dy[d];
        }
		return true;
	}
	static void fill(Core c,int d,int v) {
		cnt = 0;
        int x = c.x + dx[d];
        int y = c.y + dy[d];
        
        while (x >= 0 && y >= 0 && x < n && y < n) {
            map[y][x] = v;
            cnt++;
            x = x + dx[d];
            y = y + dy[d];
        }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=testCase; t++) {
			minLine = Integer.MAX_VALUE;
			maxCore=0;
			list.clear();
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for(int y=0;y<n; y++) {
				st= new StringTokenizer(br.readLine());
				for(int x=0; x<n; x++) {
					map[y][x]= Integer.parseInt(st.nextToken());
					if(map[y][x]==1 && x>0 && y>0 && x<n-1 && y<n-1) {
						list.add(new Core(x,y));
					}
				}
			}
			check(0,0,0);
			sb.append(String.format("#%d %d\n", t,minLine));
		}
		System.out.println(sb);
	}

}
