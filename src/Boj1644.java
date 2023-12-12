import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> prime = new ArrayList<>();
		boolean [] num = new boolean[n+1];
		
		for(int i=2; i*i<=n; i++) {
			if(!num[i]) {
				for(int j=i*i; j<=n; j+=i) {
					num[j]=true;					
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(!num[i]) {
				prime.add(i);
			}
		}
		int cnt=0;
		int l=0,r=0;
		while(l<=r && r<prime.size()) {
			int sum=0;
			for(int i=l; i<=r; i++) {
				sum+=prime.get(i);
			}
			if(sum >= n) {
				if(sum==n) {
					cnt++;
				}
				l++;
			}
			else {
				r++;
			}
		}
		System.out.println(cnt);
	}

}
