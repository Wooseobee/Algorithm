import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        int len = list.size() - 1;
        if (list.get(len) > list.get(len - 1)) list.add(list.get(len) - list.get(len - 1));
        else list.add(list.get(len) * 2);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}