import java.util.PriorityQueue;

public class spicier {
    public int solution(int[] scoville, int K) {
        int answer = 0
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int num : scoville) {
            q.offer(num);
        }
        int cnt = 0;
        while(q.size() >= 2) {
            int x = q.poll();
            int y = q.poll();
            q.offer(x + 2 * y);
            answer++;
            if(q.peek() >= K) return answer;
        }
        return -1;
    }
}
