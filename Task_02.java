import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task_02 {
    public static void main(String[] args) {
        String list = "Иванов Алексей,Петров Иван,Сидоров Иван,Петров Алексей" +
                "Кирилл Кириллов,Иван Сидоров,Алексей Музюкин,Иван Петров";
        Map<String, Integer> newMap = StringToHashmap(list);
        System.out.println(newMap);
        SortHashMap(newMap);
        Map<String,Integer> sortedMap = SortHashMap(newMap);
        System.out.println(sortedMap);
    }
    public static Map<String, Integer> SortHashMap(Map<String,Integer> mapToSort){
        Map<String, Integer> sortedMap = mapToSort.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new));
        return sortedMap;
    }
    public static Map<String, Integer> StringToHashmap(String employees){
        String[] empl = employees.split(",");
        String[][] emplSplit = new String[2][empl.length];
        for (int i = 0; i < empl.length; i++) {
            emplSplit[0][i] = empl[i].split(" ")[0];
            emplSplit[1][i] = empl[i].split(" ")[1];
        }
        Map<String, Integer> newMap = new HashMap<>();
        for (int i = 0; i < emplSplit[0].length; i++) {
            if((newMap.isEmpty() == false) && (newMap.containsKey(emplSplit[0][i]) == true)){
                int tmp = newMap.get(emplSplit[0][i]);
                newMap.put(emplSplit[0][i], tmp + 1);
            }
            else newMap.put(emplSplit[0][i], 1);
        }
        return newMap;
    }

}
