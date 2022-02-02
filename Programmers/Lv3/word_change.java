/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 3
 * @prob_name: 단어변환
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/43163
 *
 * 최단거리 문제,
 * 단어들을 그래프 형태로 구성 -> BFS 형태로 문제의 변환
 *
 * map을 굳이 사용하지 않아도 단어들간의 번호는 유일하므로 사용않고 풀이가 가능함.
 *
 */


import java.util.*;

class Solution {

    static ArrayList<Integer> graph[];
    static ArrayList<String> arrWord;
    static int dist[];

    public boolean isDiffOne(String word1, String word2) {
        int diff = 0;
        for(int idx = 0; idx < word1.length(); idx++){
            if(word1.charAt(idx) != word2.charAt(idx)) diff++;
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        arrWord = new ArrayList<String>();
        arrWord.add(begin);
        for(int i = 0; i < words.length; i++){
            arrWord.add(words[i]);
        }
        int n = arrWord.size();
        graph = new ArrayList[n];
        dist = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arrWord.get(i), i);
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }

        // 그래프 구성
        for(int i = 0; i < n; i++) {
            String word = arrWord.get(i);
            for(int j = i + 1; j < n; j++) {
                String word2 = arrWord.get(j);
                if(isDiffOne(word, word2)) {
                    graph[map.get(word)].add(map.get(word2));
                    graph[map.get(word2)].add(map.get(word));
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(map.get(begin));
        dist[map.get(begin)] = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int i = 0; i < graph[x].size(); i++){
                int y = graph[x].get(i);
                if(dist[y] == -1) {
                    q.add(y);
                    dist[y] = dist[x] + 1;
                }
            }
        }
        if(arrWord.contains(target)) answer = dist[map.get(target)];
        return answer;
    }
}