import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea3289 {
	/*
	 * ù ��°  �׽�Ʈ���̽� ��
	 * �� ��° n(����� ��)�� m(������ ��)
	 * 0 a b a�� b�� ���Ķ�
	 * 1 a b �� ���Ұ� ���� ���տ� �ִ°�?
	 */
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [] parents;
	static int n,m;
	
	
	static void makeSet() {
		for(int i=1; i<=n; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		parents[bRoot]=aRoot;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int testCase = Integer.parseInt(br.readLine());
		for(int test=1; test<=testCase; test++) {
			sb.append("#"+test+" ");
			st= new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int [n+1];
			makeSet();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(oper == 0) {
					union(a,b);
				}
				else {
					if(find(a)==find(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
