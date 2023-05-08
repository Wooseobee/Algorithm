import java.util.*;

class Solution {
    static Map<Character, Integer> skill_map = new HashMap<>();
    static boolean[] learnSkill;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        learnSkill = new boolean[skill.length()];

        for (int i = 0; i < skill.length(); i++) {
            skill_map.put(skill.charAt(i), i);
        }

        for (String skill_tree : skill_trees) {
            if (canSkillTree(skill_tree)) answer++;
        }

        return answer;
    }

    private static boolean canSkillTree(String skill_tree) {
        int idx = 0;
        Arrays.fill(learnSkill, false);
        for (int i = 0; i < skill_tree.length(); i++) {
            char ch = skill_tree.charAt(i);
            if (skill_map.containsKey(ch)) {
                if (!checkPrev(skill_map.get(ch))) return false;
                learnSkill[idx++] = true;
            }
        }

        return true;
    }

    private static boolean checkPrev(int idx) {
        for (int i = 0; i < idx; i++) {
            if (!learnSkill[i]) return false;
        }
        return true;
    }
    
    // // 정규표현식 + indexOf 이용
    // public int solution(String skill, String[] skill_trees) {
    //     int answer = 0;
    //     for (String s : skill_trees) {
    //         s = s.replaceAll("[^" + skill + "]", "");
    //         if (skill.indexOf(s) == 0) answer++;
    //     }
    //     return answer;
    // }
}