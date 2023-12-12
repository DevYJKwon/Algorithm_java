import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1700 {
	static class Product implements Comparable<Product>{
		int index;
		int num;
		int priority;

		public Product(int num,int index, int priority) {
			this.num = num;
			this.index = index;
			this.priority = priority;
		}
		
		 @Override
		public int compareTo(Product o) {
			return -1*Integer.compare(this.priority, o.priority);
		}
	}

	static int k, n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] queue;
	static List<Product> list = new ArrayList<>();
	static PriorityQueue<Product> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //멀티탭 플러그 개수
		k = Integer.parseInt(st.nextToken()); //물건 개수
		st = new StringTokenizer(br.readLine());
		queue = new int [k];
		for(int i=0; i<k; i++) {
			int pNum = Integer.parseInt(st.nextToken());
			queue[i]=pNum;	
		}
		int cnt=0;
		for(int i=0; i<k; i++) {
			int pNum = queue[i];
			if(pq.size()==n) {
				if(!isIn(pNum)) {
					Product p = pq.poll();
					cnt++;
					list.remove(p);
					System.out.println(pNum+" "+p.index+" "+p.num+" "+p.priority);
					int prior = getDistance(i,pNum);
					Product product = new Product(pNum,i,prior);
					list.add(product);
					pq.add(product);
				}
			}
			else {
				if(isIn(pNum)) {
					Product tmp=null;
					for(int t=0; t<list.size(); t++) {
						tmp = list.get(t);
						if(tmp.num==pNum);
						break;
					}
					pq.remove(tmp);
					System.out.println(tmp.hashCode());
					list.remove(tmp);
				}
				int prior = getDistance(i,pNum);
				Product p = new Product(pNum,i,prior);
				list.add(p);
				pq.add(p);
			}
			for(Product p:list) {
				System.out.print(p.index+" "+p.num+" "+p.priority+"/ ");
			}
			System.out.println();
			refresh();
		}
		System.out.println(cnt);
	}

	static boolean isIn(int pNum) {
		for(Product product : list) {
			if(product.num == pNum) {
				return true;
			}
		}
		return false;
	}
	
	static int getDistance(int start, int target) {
		int distance=101;
		for(int i=start+1; i<k; i++) {
			if(queue[i]==target) {
				distance = i-start;
				break;
			}
		}
		return distance;
	}
	
	static void refresh() {
		for(Product p : list) {
			p.index++;
			p.priority = getDistance(p.index, p.num);
		}
	}
}
