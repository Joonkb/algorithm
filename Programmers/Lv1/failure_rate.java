/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 1
 * @prob_name: 실패율
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
 *
 * class 를 따로 구현하고 정렬의 기준을 새롭게 함
 * Level 1이라고 하기엔 조금은 까다로움...
 *
 * 1. Double.compare를 새롭게 알게됨,
 * 2. 또한 주어진 문제의 조건을 잘 읽어야 됨...
 * 3. 문제를 시뮬레이션 하면서 어떠한 상황이 발생할 것인지 또한 생각해 보는 연습
 * 한참을 해맸던 문제임..
 */

import java.util.*;

class Stage implements Comparable<Stage> {
    int stageNum;
    int notClear;
    int total;
    double fail;
    Stage(int num, int stageNum, int total){
        this.stageNum = num;
        this.notClear = stageNum;
        this.total = total;
        if(stageNum == 0) this.fail = 0.0;
        else this.fail = (double)stageNum / total;
    }
    @Override
    public int compareTo(Stage s2){
        if(Double.compare(fail, s2.fail) != 0) return -1 * Double.compare(fail, s2.fail);
        else return stageNum - s2.stageNum;
    }
}

class failure_rate {
    static int[] st = new int[502];

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        for(int i = 0; i < stages.length; i++){
            st[stages[i]]++;
        }
        int size = N;
        ArrayList<Stage> ar = new ArrayList<>();
        int sum = stages.length;
        for(int i = 1; i <= N; i++) {
            ar.add(new Stage(i, st[i], sum));
            sum -= st[i];
        }
        Collections.sort(ar);
        for(int i = 0; i < N; i++) {
            answer[i] = ar.get(i).stageNum;
        }
        return answer;
    }
}