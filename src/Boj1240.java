import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1240 {

    // 2차원 배열로 입력 받고 주어진 경로 탐색
    // 해당 노드부터 들어가서 연결된 모든 노드 bfs 탐색 -> 가장 먼저 찾아지는게 최단

    static Node [] list;
    static int n;
    static class Node{
        int to,cost;
        Node next;

        public Node(int to, int cost, Node next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
        }

        public void add(Node newNode){
            if(this.next == null){
                this.next=newNode;
                return;
            }
            this.next.add(newNode);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", cost=" + cost +
                    ", next=" + next +
                    '}';
        }
    }

    static class QNode{
        Node node;
        int sum;

        public QNode(Node node, int sum) {
            this.node = node;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "QNode{" +
                    "node=" + node +
                    ", sum=" + sum +
                    '}';
        }
    }
    static int bfs(int start, int dest){
        int dist = 0;
        Queue<QNode> q = new ArrayDeque<>();

        boolean [] visited = new boolean [n+1];
        visited[start]=true;
        for(Node node = list[start].next; node !=null; node = node.next){
            q.add(new QNode(node,node.cost));
        }
        while (!q.isEmpty()){
            QNode cur = q.poll();
            if(cur.node.to == dest){
               return cur.sum;
            }
            Node curNode =cur.node;
            for(Node node=list[curNode.to].next; node != null; node = node.next){
                if(!visited[node.to]){
                    q.add(new QNode(node,cur.sum+node.cost));
                    visited[node.to]=true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list= new Node[n+1];
        for(int i=1; i<=n; i++){
            list[i]= new Node(0,0,null);
        }

        for(int i=0; i<n-1; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost,null));
            list[to].add(new Node(from,cost,null));
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            sb.append(bfs(start,dest)).append("\n");
        }
        System.out.println(sb);
    }
}
