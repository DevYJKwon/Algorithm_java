import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1974 {
	static class Node{
		int v,d,i;

		public Node(int v, int d,int i) {
			super();
			this.v = v;
			this.d  =d;
			this.i = i;
		}
		
	}
	
	static int binarySearch(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			
			if(lis.get(mid) < target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	static List<Integer> lis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			lis = new ArrayList<>();
			List<Node> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				if(i==0) {
					int next = Integer.parseInt(st.nextToken());
					lis.add(next);
					list.add(new Node(next,lis.size()-1,i));
					continue;
				}
				int next = Integer.parseInt(st.nextToken());
				if(lis.get(lis.size()-1) < next) {
					lis.add(next);
					list.add(new Node(next,lis.size()-1,i));
				}
				else {
					int idx = binarySearch(0,lis.size(),next);
					lis.set(idx, next);
					list.add(new Node(next,idx,i));
				}
			}
			sb.append(lis.size()).append("\n");
			int idx = lis.size()-1;
			for(int i= n-1; i>=0; i--) {
				if(list.get(i).d == idx) {
					lis.set(idx, list.get(i).i+1);
					idx--;
				}
			}
			
			for(int i: lis) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
