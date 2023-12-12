import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2357 {

	static int [] arr;
		

	static int minTree[];
	static int maxTree[];
	
	static int initMin(int node, int start, int end) {
		if(start == end) {
			return minTree[node]=arr[start];
		}
		int mid = (start+end)/2;
		return minTree[node]=Math.min(initMin(node*2, start, mid), initMin(node*2+1, mid+1,end));
	}
	static int initMax(int node, int start, int end) {
		if(start == end) {
			return maxTree[node]=arr[start];
		}
		int mid = (start+end)/2;
		return maxTree[node]=Math.max(initMax(node*2, start, mid), initMax(node*2+1, mid+1,end));
	}
	
	static int getMin(int node, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && right >= end) {
			return minTree[node];
		}
		int mid = (start+end)/2;
		return Math.min(getMin(node*2,start,mid,left,right), getMin(node*2+1,mid+1,end,left,right));
	}
	static int getMax(int node, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return Integer.MIN_VALUE;
		}
		
		if(left <= start && right >= end) {
			return maxTree[node];
		}
		int mid = (start+end)/2;
		return Math.max(getMax(node*2,start,mid,left,right), getMax(node*2+1,mid+1,end,left,right));
	}

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		arr = new int [n+1];
		minTree = new int [(int)Math.pow(2,h+1)];
		maxTree = new int [(int)Math.pow(2,h+1)];
		
		for(int i=1; i<=n; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		initMin(1,1,n);
		initMax(1,1,n);
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(getMin(1,1,n,left,right)).append(" ").append(getMax(1,1,n,left,right)).append("\n");
		}
		System.out.println(sb);
		
	}

}
