import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj2164 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.removeFirst();
			int first = q.removeFirst();
			q.addLast(first);
		}
		System.out.println(q.remove());
		
	}	

}
