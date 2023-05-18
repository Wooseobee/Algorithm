class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("E#", "E");
        int longestRunningTime = 0;
        for (String music : musicinfos) {
            String[] splitString = music.split(",");
            String[] start = splitString[0].split(":");
            String[] end = splitString[1].split(":");
            String title = splitString[2];
            String info = splitString[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("E#", "E");

            int startHour = Integer.parseInt(start[0]);
            int startMin = Integer.parseInt(start[1]);

            int endHour = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1]);

            int runningTime = (endHour * 60 + endMin) - (startHour * 60 + startMin);

            String runningMelody = "";
            int melodyLen = 0;
            while (melodyLen < runningTime) {
                runningMelody += info;
                melodyLen = runningMelody.length();
            }
            runningMelody = runningMelody.substring(0, runningTime);
            if (runningMelody.contains(m) && longestRunningTime < runningTime) {
                answer = title;
                longestRunningTime = runningTime;
            }
        }
        if (answer.equals("")) answer = "(None)";
        return answer;
    }
}