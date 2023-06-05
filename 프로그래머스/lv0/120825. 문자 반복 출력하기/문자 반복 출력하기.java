import java.util.*;
class Solution {
    public String solution(String my_string, int n) {
        return Arrays.stream(my_string.split("")).reduce("", (s, s1) -> s + s1.repeat(n));
    }
}