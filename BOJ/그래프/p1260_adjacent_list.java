import java.util.*;

public class p1260_adjacent_list {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int n){
        visited[n] = true;
        System.out.print(n +" ");
        for(int i = 0; i < graph[n].size(); i++){
            int next = graph[n].get(i);
            if(!visited[next]) dfs(next);
        }
    }
    static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            visited[x] = true;
            System.out.print(x+" ");
            for(int i = 0; i < graph[x].size(); i++){
                int y = graph[x].get(i);
                if(!visited[y]){
                    queue.add(y);
                    visited[y] = true;
                }
            }
        }
    }
    static void init(int n){
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <=n; i++){
            graph[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt();
        init(n);
        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
}