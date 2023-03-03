import java.util.*;

class Solution {
    static Map<String, String> userNickname = new HashMap<>();
    static Map<String, List<Integer>> userLog = new HashMap<>();
    static List<String> logs = new ArrayList<>();
    static int logCnt = 0;

    public String[] solution(String[] record) {
        String[] answer = {};

        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");
            String behavior = input[0];
            String id = input[1];
            switch (behavior) {
                case "Enter":
                    String nickname = input[2];
                    enterLogic(id, nickname);
                    break;
                case "Leave":
                    leaveLogic(id);
                    break;
                case "Change":
                    nickname = input[2];
                    changeLogic(id, nickname);
                    break;
            }
        }

        return logs.toArray(new String[logs.size()]);
    }

    static void enterLogic(String id, String nickname) {

        if (userNickname.containsKey(id)) {
            changeLogic(id, nickname);
            userLog.get(id).add(logCnt++);
            userNickname.put(id, nickname);
        } else {
            userNickname.put(id, nickname);
            userLog.put(id, new ArrayList<>());
            userLog.get(id).add(logCnt++);
        }
        printLog(nickname + "님이 들어왔습니다.");
    }

    static void leaveLogic(String id) {
        userLog.get(id).add(logCnt++);
        printLog(userNickname.get(id) + "님이 나갔습니다.");
    }

    static void changeLogic(String id, String changeNickname) {
        String beforeNickname = userNickname.get(id);
        userNickname.put(id, changeNickname);
        for (int idx : userLog.get(id)) {
            logs.set(idx, logs.get(idx).replace(beforeNickname, changeNickname));
        }
    }

    static void printLog(String str) {
        logs.add(str);
    }
}