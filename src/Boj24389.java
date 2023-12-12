import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj24389 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int complement = ~n+1;
		int diff = n ^ complement;
		int cnt=0;
		for(char c: Integer.toBinaryString(diff).toCharArray()) {
			if(c=='1') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
