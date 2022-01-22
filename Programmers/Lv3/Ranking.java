package programmers;

public class Ranking {
    static int[][] graph = new int[101][101];
    static int[] in = new int[101];
    static int[] out = new int[101];
    static boolean[] visited = new boolean[101];
    static void dfs(int v, int n) {
        for(int i = 1; i <= n; i++) {
            if(graph[v][i] == 1 && !visited[i]){
                in[i]++;
                visited[i] = true;
                dfs(i, n);
            }
        }
        return;
    }
    static void arrayInit(int n){
        for(int i = 1; i <= n; i++){
            visited[i] = false;
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        for(int i = 0; i < results.length; i++){
            int v1 = results[i][0], v2 = results[i][1];
            graph[v1][v2] = 1;
            out[v1]++;
        }
        for(int i = 1; i <= n; i++) {
            arrayInit(n);
            dfs(i, n);
        }
        for(int i = 1; i <= n; i++) {
            if(in[i] + out[i] == n-1) answer++;
            System.out.println("i = " + i);
        }
        return answer;
    }
}
