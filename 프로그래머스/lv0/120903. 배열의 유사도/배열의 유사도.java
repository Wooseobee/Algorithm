import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        List<String> s1List = List.of(s1);
        return (int) Arrays.stream(s2).filter(s -> s1List.contains(s)).count();
    }
}