class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum = sum + (price * i);
        }

        answer = 0 > (sum - money) ? 0 : sum - money;
        return answer;
    }
}