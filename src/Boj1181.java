import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Boj1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> list = new HashSet<>();
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		List<String> arr = new ArrayList<>(list);
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					return -1;
				}
				else if(o1.length() == o2.length()){
					return o1.compareTo(o2)*1;
				}
				else {
					return 1;
				}
			}
		});
		for(String s : arr) {
			System.out.println(s);
		}

	}

}
