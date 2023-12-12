import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2042 {
	static long [] tree;
	
	
	static long init(long [] arr , int node, int start, int end) {
		if(start ==end) {
			return tree[node] = arr[start];
		}
		
		return tree[node]= init(arr,node*2,start,(start+end)/2) + init(arr,node*2+1,(start+end)/2+1,end);
	}
	
	static void update(int node, int start, int end, int idx, long diff) {
		if(idx < start || idx>end) {
			return;
		}
		
		tree[node]+=diff;
		if(start!=end) {
			update(node*2,start,(start+end)/2,idx,diff);
			update(node*2+1,(start+end)/2+1,end,idx,diff);
		}
	}
	
	
	public static long sum (int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0 ;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		return sum(node*2, start, (start+end)/2, left,right)+ sum(node*2+1, (start+end)/2+1, end, left, right);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //변경 횟수
		int k =Integer.parseInt(st.nextToken()); // 구간의 합 구하는 횟수
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		StringBuilder sb = new StringBuilder();
		tree = new long[(int) Math.pow(2, h+1)];
		long [] arr = new long [n+1];
		for(int i=1; i<=n; i++){
			arr[i] =Long.parseLong(br.readLine());
		}
		init(arr,1,1,n);
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int action = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(action == 1) {
				update(1,1,n,a,b-arr[a]);
				arr[a]=b;
			}
			else {
				sb.append(sum(1,1,n,a,(int)b)).append("\n");
			}
		}
		System.out.println(sb);
		

	}

}
