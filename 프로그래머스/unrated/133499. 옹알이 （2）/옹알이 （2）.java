class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            if (str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama"))
                continue;
            str = str.replace("aya", "*").replace("ye", "*").replace("woo", "*").replace("ma", "*").replace("*", "");
            if (str.length() == 0) answer++;
        }
        return answer;
    }
}