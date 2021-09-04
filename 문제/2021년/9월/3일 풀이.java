import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) { 
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer += participant[i];
                break;
            }
        }

        return answer;
    }

    public String 틀린버전(String[] participant, String[] completion) {
        String answer = "";

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(i, participant[i]);
        }

        Map<Integer, String> map1 = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            map1.put(i, completion[i]);
        }

        for (int i = 0; i < participant.length; i++) {
            if(map1.size() > 0) {
                for (Integer temp : map1.keySet()) {
                    if(participant[i].equals(map1.get(temp))) {
                        map1.remove(temp);
                        map.remove(i);
                        break;
                    }
                }
            }
        }

        for (Integer temp : map.keySet()) {
            answer = answer + map.get(temp);
        }

        return answer;
    }
}