import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj2565 {
	static List<Integer> lis = new ArrayList<>();
	
	static int bSearch(int start, int end , int target) {
		while(start < end) {
			int mid = (start+end)/2;
			
			if(lis.get(mid) < target) {
				start=mid+1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map.put(from, to);
		}
		
		for(int i:map.values()) {
			if(lis.size()==0) {
				lis.add(i);
			}
			
			if(lis.get(lis.size()-1) < i) {
				lis.add(i);
			}
			else {
				int idx = bSearch(0,lis.size(),i);
				lis.set(idx, i);
			}
		}
		
		System.out.println(n-lis.size());
		
	}

}
