import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj18110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] scores = new int [n];
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			scores[i]=tmp;
		}
		Arrays.sort(scores);
		int sum=0;
		int start = (int)Math.round(n*0.15);
		int end = n-start;
		for(int i=start; i<end; i++) {
			sum+=scores[i];
		}
		System.out.println(Math.round((float)sum/(end-start)));
	}

}
