import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static class Team {
        int teamID;
        int submit;
        int lastSubmit;
        int[] scores;
        int totalScore;

        private Team(int question, int teamID) {
            this.teamID = teamID;
            this.submit = 0;
            this.lastSubmit = 0;
            this.scores = new int[question + 1];
            totalScore = 0;
        }

        private void solveQuestion(int questionNum, int score, int idx) {
            totalScore -= scores[questionNum];
            lastSubmit = idx;
            scores[questionNum] = Math.max(scores[questionNum], score);
            submit++;
            totalScore += scores[questionNum];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            int t = Integer.parseInt(in[2]);
            int m = Integer.parseInt(in[3]);

            List<Team> teams = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                teams.add(new Team(k, j));
            }
            for (int j = 0; j < m; j++) {
                in = br.readLine().split(" ");
                int teamId = Integer.parseInt(in[0]);
                int questionNum = Integer.parseInt(in[1]);
                int s = Integer.parseInt(in[2]);

                Team team = teams.get(teamId - 1);
                team.solveQuestion(questionNum, s, j);
            }

            teams.sort((o1, o2) -> {
                if (o1.totalScore == o2.totalScore) {
                    if (o1.submit == o2.submit) {
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.submit - o2.submit;
                }
                return o2.totalScore - o1.totalScore;
            });

            for (int j = 0; j <= n; j++) {
                Team team = teams.get(j);
                if (team.teamID == t - 1) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

}