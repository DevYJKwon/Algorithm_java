import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 권용재
@since 2023. 8. 1.
@see
@git
@youtube
@performance
@category #
@note */

public class Boj15649 {
	static StringBuilder sb = new StringBuilder();
	
	static void permutation(int [] arr, int r, int [] choosed, boolean [] visited) {
		if(choosed.length == r) {
			for(int i=0; i<r; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =0; i< arr.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[r]=arr[i];
				permutation(arr, r+1, choosed, visited);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=i+1;
		}
		permutation(arr, 0, new int[r], new boolean[n]);
		System.out.println(sb);
	}

}
