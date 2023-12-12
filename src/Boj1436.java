import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1436 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int num=665;
		int cnt =0;
		while(true) {
			num++;
			if(Integer.toString(num).contains("666")) {
				cnt++;
			}
			if(cnt == n) {
				break;
			}
		}
		System.out.println(num);
	}

}
