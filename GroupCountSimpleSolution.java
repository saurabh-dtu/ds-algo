//counting groups based on the positions of specific house numbers in an array.
import java.util.HashMap;

public class GroupCountSimpleSolution {

    public static void main(String[] args) {
        int[] houseNumbers = {5, 4, 3, 1, 2, 7, 0, 11, 8, 6};
        int[] numbersToFind = {11, 5};

        int groupCount = countGroups(houseNumbers, numbersToFind);
        System.out.println("Number of groups: " + groupCount);
    }

    private static int countGroups(int[] houseNumbers, int[] numbersToFind) {
        HashMap<Integer, Boolean> numbersMap = new HashMap<>();
        int groups = 0;

        // Mark numbers to find in the map
        for (int num : numbersToFind) {
            numbersMap.put(num, true);
        }

        boolean inGroup = false;
        for (int num : houseNumbers) {
            if (numbersMap.containsKey(num)) {
                if (!inGroup) {
                    groups++;
                    inGroup = true;
                }
            } else {
                inGroup = false;
            }
        }
        return groups;
    }
}
