import java.util.*;

/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 전화번호 목록
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 *
 *  해쉬의 유형이지만, Trie 알고리즘을 사용해서 해결
 */

class Trie{
    class Node{
        boolean valid;
        int children[] = new int[26];
        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = -1;
            }
            valid = false;
        }
    }
    int root;
    ArrayList<Node> trie;
    Trie(){
        trie = new ArrayList<>();
        root = init();
    }
    int init(){
        trie.add(new Node());
        return trie.size() - 1;
    }
    boolean add(int node, String s, int index){
        if(trie.get(node).valid) return true;
        if(index == s.length()){
            trie.get(node).valid = true;
            return false;
        }
        int c = s.charAt(index) - '0';
        if(trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        return add(trie.get(node).children[c], s, index+1);
    }
}

public class phoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        for(String s : phone_book){
            if(trie.add(trie.root, s, 0)) answer = false;
        }
        return answer;
    }
}
