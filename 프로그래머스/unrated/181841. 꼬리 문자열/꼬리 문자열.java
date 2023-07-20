import java.util.*;
class Solution {
    public String solution(String[] str_list, String ex) {
        return Arrays.stream(str_list).reduce("",(i,j)-> {
            if (!j.contains(ex)) {
                return i + j;
            }
            return i;
        });
    }
}