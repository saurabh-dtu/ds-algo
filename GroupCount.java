import java.util.*;

public class GroupCount {

    public static void main(String[] args) {
        int[] houseNumbers = {5, 4, 3, 1, 2, 7, 0, 11, 8, 6};
        int[] numbersToFind = {11, 5};

        int groupCount = countGroups(houseNumbers, numbersToFind);
        System.out.println("Number of groups: " + groupCount);
    }

    private static int countGroups(int[] houseNumbers, int[] numbersToFind) { HashMap<Integer, Integer> hm = new HashMap<>();
        int[] visited = new int[12];
        int groups = 0;
        for(int i=0;i<houseNumbers.length;i++) {
            hm.put(houseNumbers[i], i);
        }
        for(int i=0;i<numbersToFind.length;i++) {
            int index = hm.get(numbersToFind[i]);
            int prev = index - 1;
            int next = index + 1;
            if (((prev >= 0 && visited[houseNumbers[prev]] != 1) &&
            (next < houseNumbers.length - 1 && visited[houseNumbers[next]] != 1)) || (index == houseNumbers.length - 1 && visited[houseNumbers[prev]] != 1) || (index == 0 && visited[houseNumbers[next]] != 1)) {
                groups++;
            } else if (prev >= 0 && next < houseNumbers.length) {
                int prevHouse = houseNumbers[prev];
                int nextHouse = houseNumbers[next];
                if((visited[prevHouse] > 0 && visited[nextHouse] > 0) ||  ((index == houseNumbers.length - 1 && visited[houseNumbers[prev]] == 1) || (index == 0 && visited[houseNumbers[next]] == 1))) {
                    groups--;
                }
            }
            visited[houseNumbers[index]] = 1;
        }
        return groups;
    }
}
//output - Number of groups: 2
