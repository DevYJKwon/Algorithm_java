import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17471 {
	static class Node{
		int i;
		int people;
		Node next;
		public Node(int i,int people, Node next) {
			this.i = i;
			this.people = people;
			this.next = next;
		}
	}
	
	static void subSet(int cnt) {
		if(cnt==n+1) {
			a.clear();
			b.clear();
			
			for(int i=1; i<=n; i++) {
				if(isSelected[i]) {
					a.add(i);
				}
				else {
					b.add(i);
				}
			}
			
			if(a.size() ==0 || b.size()==0) {
				return;
			}
			
			if(checkConnection(a)&& checkConnection(b)) {
				isNull = false;
				int aSum =0,bSum=0;
				for(int i: a) {
					aSum+=pArr[i];
				}
				for(int i:b) {
					bSum+=pArr[i];
				}
				min = Math.min(min, Math.abs(aSum-bSum));
			}
			return;
		}
		isSelected[cnt]=true;
		subSet(cnt+1);
		isSelected[cnt]=false;
		subSet(cnt+1);
	}
	
	static boolean checkConnection(List<Integer> l) {
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> visited = new ArrayList<>();
		for(int i : l) {
			visited.add(i);
		}
		q.add(l.get(0));
		visited.remove(l.get(0));
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Node next=list[cur]; next!=null; next=next.next) {
				if(visited.contains(next.i)) {
					visited.remove(Integer.valueOf(next.i));
					q.add(next.i);
				}
			}
		}
		if(visited.size()==0) {
			return true;
		}
		return false;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static Node [] list;
	static int [] pArr;
	static List<Integer> a = new ArrayList<>();
	static List<Integer> b = new ArrayList<>();
	static boolean [] isSelected;
	static boolean isNull = true;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		n = Integer.parseInt(br.readLine());
		list = new Node [n+1];
		pArr = new int[n+1];
		isSelected = new boolean [n+1];
		st= new StringTokenizer(br.readLine()); // ¿Œ±∏
		for(int i=1; i<=n; i++) {
			pArr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			for(int j=0; j<d; j++) {
				int node = Integer.parseInt(st.nextToken());
				list[i] = new Node(node,pArr[node],list[i]);
			}
		}
		subSet(1);
		if(isNull) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
}
