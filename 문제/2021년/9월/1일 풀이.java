class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        for (int i = 0; i < scores.length; i++) {
            int me = scores[i][i];
            int sum = 0;
            int min = 101;
            int max = -1;
            boolean isEqual = false;
            for (int j = 0; j < scores[i].length; j++) {
                if(max < scores[j][i]) max = scores[j][i];
                if(min > scores[j][i]) min = scores[j][i];
                if(i != j && me == scores[j][i]) {
                    isEqual = true;
                }
                sum = sum + scores[j][i];
            }

            int cnt = scores.length;

            if (!isEqual && (me == max || me == min)) {
                if(me == min) {
                    sum = sum - min;
                }
                else if(me == max) {
                    sum = sum - max;
                }

                cnt = cnt - 1;
            }

            sum = sum / cnt;

            if(sum >= 90) {
                answer = answer + "A";
            }
            else if(sum >= 80) {
                answer = answer + "B";
            }
            else if(sum >= 70) {
                answer = answer + "C";
            }
            else if(sum >= 50) {
                answer = answer + "D";
            }
            else {
                answer = answer + "F";
            }
        }

        return answer;
    }
}