import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1922 {

    static int [] parents;


    static class Node implements Comparable<Node> {
        int from, to ,cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }

    static int find(int a){
        if(parents[a] ==a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);
        if(aParent == bParent){
            return false;
        }

        if(aParent > bParent){
            int temp = aParent;
            aParent = bParent;
            bParent = temp;
        }
        parents[bParent]=aParent;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        parents = new int[v+1];

        //make set
        for(int i=1; i<=v; i++){
            parents[i]=i;
        }

        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(from,to,cost));
        }

        int n = 0;
        int sum=0;
        while(n < v-1){
            Node next = pq.poll();
            if(union(next.from,next.to)){
                sum+=next.cost;
                n++;
            }
        }
        System.out.println(sum);
    }
}
