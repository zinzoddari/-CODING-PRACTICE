import java.util.*;

public class Test {
    public static void main(String[] args) {
        String arry1[] = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(arry1));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> nicknameMap = new HashMap<>();
        List<String> message = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String temp[] = record[i].split(" ");

            if(temp.length > 2) {
                nicknameMap.put(temp[1], temp[2]);
            }

            if(!temp[0].equals("Change")) {
                switch (temp[0]) {
                    case "Enter":
                        message.add(temp[1] + "님이 들어왔습니다.");
                        break;
                    case "Leave":
                        message.add( temp[1] + "님이 나갔습니다.");
                        break;
                }
            }
        }
        answer = new String[message.size()];
        for (int i = 0; i < message.size(); i++) {
            String userId = message.get(i).substring(0, message.get(i).indexOf("님"));

            answer[i] = message.get(i).replaceAll(userId, nicknameMap.get(userId));
        }

        return answer;
    }
}