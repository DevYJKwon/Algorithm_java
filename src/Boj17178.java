import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17178 {
    static class Node implements Comparable<Node> {
        char alpha;
        int num;

        public Node(char alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "alpha=" + alpha +
                    ", num=" + num +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(this.alpha < o.alpha){
                return -1;
            }
            else if(this.alpha == o.alpha){
                return Integer.compare(this.num,o.num);
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Node> q= new ArrayDeque<>();
        Stack<Node> stack = new Stack<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                String str = st.nextToken();
                Node node = new Node(str.charAt(0), Integer.parseInt(str.substring(2)));
                q.add(node);
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            Node next = pq.peek();
            while(!q.isEmpty() || !stack.isEmpty()){
                if(!stack.isEmpty() && stack.peek() == next){
                    pq.poll();
                    stack.pop();
                    break;
                }
                Node cur = q.poll();

                if(cur==null){
                    System.out.println("BAD");
                    System.exit(0);
                }

                if(cur == next){
                    pq.poll();
                    break;
                }
                stack.push(cur);
            }
            if(pq.peek() == next){
                System.out.println("BAD");
                System.exit(0);
            }
        }
        System.out.println("GOOD");
    }
}
