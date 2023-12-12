import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point [] arr = new Point[n];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i]=new Point(x,y);
		}
		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y > o2.y) {
					return 1;
				}
				else if(o1.y==o2.y) {
					if(o1.x > o2.x) {
						return 1;
					}
					else if(o1.x == o2.x) {
						return 0;
					}
					else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}
			
		}
		);
		for(Point p : arr) {
			sb.append(p.x+" "+p.y+"\n");
		}
		System.out.println(sb);
	}
}
