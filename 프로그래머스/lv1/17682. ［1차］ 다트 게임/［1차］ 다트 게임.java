class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        String[] str1 = dartResult.replaceAll("[*#A-Z]", " ").split("\\s+");
        String[] str2 = dartResult.split("[0-9]+");
        String[] str3 = new String[3];
        for (int i = 0; i < 3; i++) {
            str3[i] = str1[i] + str2[i + 1];
            System.out.println(str3[i]);
        }

        int before = 0;
        for (int i = 0; i < 3; i++) {
            int score = 0;
            switch (str2[i + 1].charAt(0)) {
                case 'S':
                    score = (int) Math.pow(Integer.parseInt(str1[i]), 1);
                    break;
                case 'D':
                    score = (int) Math.pow(Integer.parseInt(str1[i]), 2);
                    break;
                case 'T':
                    score = (int) Math.pow(Integer.parseInt(str1[i]), 3);
                    break;
            }
            if (str3[i].contains("*")) {
                answer += before + (score * 2);
                before = score * 2;
            } else if (str3[i].contains("#")) {
                answer += score * (-1);
                before = score * (-1);
            } else {
                answer += score;
                before = score;
            }
        }
        return answer;
    }
}