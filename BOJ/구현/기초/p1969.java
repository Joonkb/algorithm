import java.util.Scanner;

public class p1969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        String[] dna = new String[n];
        int[] dist = new int[n];
        int[][] alpha = new int[m][26];
        for(int i = 0; i < n; i++){
            dna[i] = sc.nextLine();
        }
        String answer = "";
        int diff = 0;
        for(int i= 0 ; i < n; i++){
            for(int k = 0; k < m; k++) {
                int what = dna[i].charAt(k) - 'A';
                alpha[k][what]++;
            }
        }
        for(int i = 0; i < m; i++){
            int high = -1, index  = 0;
            for(int j = 0; j < 26; j++){
                if(high == -1 || alpha[i][j] > high) {
                    high = alpha[i][j];
                    index = j;
                }
            }
            answer += (char)((index) + 'A');
        }
        for(int i =0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if (dna[i].charAt(j) != answer.charAt(j)) {
                    diff++;
                }
            }
        }
        System.out.println(answer);
        System.out.println(diff);
    }
}
