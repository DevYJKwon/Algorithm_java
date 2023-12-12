import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Boj5430 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t =0; t<testCase; t++) {
			boolean fail = false;
			StringBuilder tmp = new StringBuilder();
			char [] action = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			char [] str = br.readLine().toCharArray();
			int last =0;
			Deque<Integer> q = new LinkedList<>();
			boolean reversed=false;
			
			for(int i=0; i<n; i++) {
				tmp.setLength(0);
				for(int s =last; s<str.length; s++) {
					if(str[s]==',') {
						str[s]='x';
						last = s;
						break;
					}
					else if(str[s] >= '0' && str[s] <= '9') {
						tmp.append(str[s]);
						str[s]='x';
					}
				}
				q.add(Integer.parseInt(tmp.toString()));
			}
			for(int i=0; i<action.length; i++) {
				if(action[i]=='R') {
					reversed = !reversed;
				}
				else if(action[i]=='D'){
					if(q.isEmpty()) {
						fail = true;
						break;
					}
					
					if(reversed) {
						q.removeLast();
					}
					else {
						q.remove();
					}
				}
			}
			if(fail) {
				sb.append("error\n");
			}
			else {
				
				sb.append("[");
				while(!q.isEmpty()) {
						if(reversed) {
							sb.append(q.removeLast());	
						}
						else {
							sb.append(q.remove());
						}
						
						if(!q.isEmpty()) {
							sb.append(",");
						}
				}
				sb.append("]\n");	
			}
		}
		System.out.print(sb);
	}

}
