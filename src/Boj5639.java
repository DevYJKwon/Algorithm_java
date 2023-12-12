import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639 {
	static class Node {
		int data;
		Node left = null;
		Node right = null;
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		 
	}

	static StringBuilder sb = new StringBuilder();

	static void addChild(Node oldNode, Node newNode) {
		if (oldNode.data > newNode.data) {
			if (oldNode.left == null) {
				oldNode.left = newNode;
			} else {
				addChild(oldNode.left, newNode);
			}
		} else {
			if (oldNode.right == null) {
				oldNode.right = newNode;
			} else {
				addChild(oldNode.right, newNode);
			}
		}
	}

	static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data).append("\n");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node tree = new Node(Integer.parseInt(br.readLine()),null,null);
		String str = "";
		while (true) {
			str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			Node newNode = new Node(Integer.parseInt(str),null,null);
			addChild(tree, newNode);
		}
		postOrder(tree);
		System.out.println(sb);
	}

}
