import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Boj1504 {
	
	static class Node{
		int n;
		int c;
		
		public Node(int n, int c) {
			this.n = n;
			this.c = c;
		}
	}
	
	static final int INF = 1001;
	static int [][] map;
	static int N,E;
	static int [] res;
	/*
	 * 1踰� -> N踰� 理쒕떒 嫄곕━ �씠�룞
	 * 二쇱뼱吏� �몢 �젙�젏�� 諛섎뱶�떆 �넻怨�
	 * �옱�씠�룞 媛��뒫
	 * 泥� 踰덉㎏ 以� �젙�젏�쓽 媛쒖닔 N , 媛꾩꽑�쓽 媛쒖닔 E
	 * E媛� 以꾩뿉 嫄몄퀜 a,b,c
	 * a <-> b 嫄곕━�뒗 c
	 * �꽌濡� �뿬�윭媛쒖쓽 媛꾩꽑�씠 �뿰寃곕맂 �젙�젏�쓽 �뙇�� 議댁옱�븯吏� �븡�뒗�떎.
	 */
	static void search(int start) {
		int min = INF;
		res[start]=0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			int current = pq.peek().n;
			int cost = -pq.peek().c;
			pq.remove();
			if(res[current] < cost) {
				continue;
			}
			for(int i=0; i < map[current].length; i++) {
				if(i == current) {
					continue;
				}
				
				int next = i;
				int distance = cost + map[current][i];
				if(distance < res[next] ) {
					res[next] = distance;
					pq.add(new Node(next,-distance));
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		res = new int [N];
		Arrays.fill(res, INF);
		Arrays.fill(map, INF);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[from][to]=cost;
			map[to][from]=cost;
		}
		
		for(int i=0; i<N; i++) {
			search(i);
		}
	}

}
