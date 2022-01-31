class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minLength = 0;
        int maxLength = 0;
        for(int i = 0; i < sizes.length; i++){
            minLength = Math.max(minLength, Math.min(sizes[i][0], sizes[i][1]));
            maxLength = Math.max(maxLength, Math.max(sizes[i][0], sizes[i][1]));
        }
        answer = minLength * maxLength;
        return answer;
    }
}