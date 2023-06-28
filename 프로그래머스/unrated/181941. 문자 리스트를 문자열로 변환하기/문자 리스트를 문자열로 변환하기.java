import java.util.*;
class Solution {
    public String solution(String[] arr) {
        return new StringBuilder().append(Arrays.toString(arr)).toString().replaceAll("[^a-z]", "");
    }
}