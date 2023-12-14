import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1991 {
	static Tree head = new Tree('A',null,null);
	static StringBuilder sb = new StringBuilder();
	static class Tree{
		char value;
		Tree leftChild;
		Tree rightChild;
		
		public Tree(char value, Tree leftChild, Tree rightChild) {
			super();
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		public static void insert (Tree cur, char target, char left, char right) {
			if(cur.value == target) {
				if(left != '.') {
					cur.leftChild=new Tree(left,null,null);					
				}
				if(right != '.') {
					cur.rightChild=new Tree(right,null,null);					
				}
				return;
			}
			else {
				if(cur.leftChild!=null) {
					insert(cur.leftChild,target,left,right);
				}
				
				if(cur.rightChild!=null) {
					insert(cur.rightChild,target,left,right);
				}
			}
		}
		
		public static void preOrder(Tree cur) {
			sb.append(cur.value);
			if(cur.leftChild!=null) {
				preOrder(cur.leftChild);
			}
			if(cur.rightChild!=null) {
				preOrder(cur.rightChild);
			}
		}
		public static void inOrder(Tree cur) {
			if(cur.leftChild!=null) {
				inOrder(cur.leftChild);
			}
			sb.append(cur.value);
			if(cur.rightChild!=null) {
				inOrder(cur.rightChild);
			}
		}
		public static void postOrder(Tree cur) {
			if(cur.leftChild!=null) {
				postOrder(cur.leftChild);
			}
			if(cur.rightChild!=null) {
				postOrder(cur.rightChild);
			}
			sb.append(cur.value);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			char target = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			head.insert(head, target, left, right);
		}
		
		head.preOrder(head);
		sb.append("\n");
		head.inOrder(head);
		sb.append("\n");
		head.postOrder(head);
		sb.append("\n");
		System.out.println(sb);
		
	}

}
