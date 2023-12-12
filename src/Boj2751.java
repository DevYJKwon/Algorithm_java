import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Boj2751 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> list = new TreeSet<>();
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		for(int i:list) {
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}

}
