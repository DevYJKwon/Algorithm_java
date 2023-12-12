import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2263 {
	static int rootIndex=0;
	static int in[],post[],pos[];
	static StringBuilder sb = new StringBuilder();
	
	static void getPre(int il, int ir, int pl, int pr) {
		if(il <= ir && pl <= pr) {
			int root = post[pr];
			sb.append(root+" ");
			int mid=pos[root];
			int left = mid-il;
			getPre(il, mid-1, pl, pl+left-1);
			getPre(mid+1, ir, pl+left, pr-1);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		in = new int[n];
		post = new int[n];
		pos = new int [n+1];
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			post[i]= Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			pos[in[i]]=i;
		}

		getPre(0,n-1,0,n-1);

		System.out.println(sb);
	}

}
