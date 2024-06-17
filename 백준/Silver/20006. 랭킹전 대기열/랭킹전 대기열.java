import java.io.*;
import java.util.*;

public class Main {

    private static class Room {
        int level;
        int playerNum;

        public Room(int level, int playerNum) {
            this.level = level;
            this.playerNum = playerNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int roomNum = 0;
        // 방정보<방 번호, 처음 입장 플레이어 레벨 + 인원 수>
        Map<Integer, Room> roomInfo = new HashMap<>();
        // 플레이어 정보<방 번호, [레벨, 닉네임]>
        Map<Integer, List<String[]>> playerInfo = new TreeMap<>();

        String[] in = br.readLine().split(" ");
        int p = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        for (int i = 0; i < p; i++) {
            in = br.readLine().split(" ");
            int l = Integer.parseInt(in[0]);
            String n = in[1];
            boolean findRoom = false;

            for (int j = 0; j < roomNum; j++) {
                Room room = roomInfo.getOrDefault(j, null);

                if (room != null && l >= room.level - 10 && l <= room.level + 10 && room.playerNum < m) {
                    room.playerNum++;
                    List<String[]> playerList = playerInfo.get(j);
                    playerList.add(new String[]{String.valueOf(l), n});
                    findRoom = true;
                    break;
                }
            }

            if (!findRoom) {
                roomInfo.put(roomNum, new Room(l, 1));
                List<String[]> playerList = new ArrayList<>();
                playerList.add(new String[]{String.valueOf(l), n});
                playerInfo.put(roomNum, playerList);
                roomNum++;
            }
        }

        for (int i = 0; i < roomNum; i++) {
            if (roomInfo.get(i).playerNum == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            List<String[]> players = playerInfo.get(i);
            players.sort(Comparator.comparing(o -> o[1]));
            for (String[] strings : players) {
                sb.append(strings[0]).append(" ").append(strings[1]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
