import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class Boj10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			int num= Integer.parseInt(br.readLine());
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}
			else {
				map.put(num, 1);
			}
		}
		map.forEach((n1,n2)->{
				for(int i=0; i<n2; i++) {
					sb.append(n1).append("\n");
				}
		});
		System.out.println(sb);
	}

}
