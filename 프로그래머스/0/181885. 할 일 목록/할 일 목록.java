import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
     return   IntStream.range(0, todo_list.length)
            .mapToObj(i-> new AbstractMap.SimpleEntry<>(
                            todo_list[i], !finished[i]))
            .filter(AbstractMap.SimpleEntry::getValue)
            .map(AbstractMap.SimpleEntry::getKey)
            .toArray(String[]::new);
    }
}