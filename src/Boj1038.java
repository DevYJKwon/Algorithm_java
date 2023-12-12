import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1038 {
	//9876543210 이 최대
	static List<String> list = new ArrayList<>();
	
	static void np(int nth, String num, int size) {
		if(nth == size) {
			list.add(num);
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(nth > 0 &&  num.charAt(nth-1)-'0' <= i ) {
				continue;
			}
			String next = num.concat(Integer.toString(i));
			np(nth+1,next,size);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=10; i++) {
			np(0,"",i);
		}
		
		if(n >= list.size()) {
			System.out.println(-1);
			return;
		}
		System.out.println(list.get(n));
		
		
	}

}
