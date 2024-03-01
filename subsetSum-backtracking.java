class SubsetSum {
private boolean getSum(int[] arr, int target) {
    return backtrack(arr, 0, 0, target);
}

private boolean backtrack(int[] arr, int index, int currSum, int target) {
    // Base case: If the current sum equals the target
    if (currSum == target) {
        return true;
    }

    // Explore all possibilities
    for (int i = index; i < arr.length; i++) {
        // Include the current element in the subset
        currSum += arr[i];

        // Recur with the updated current sum and index
        if (backtrack(arr, i + 1, currSum, target)) {
            return true;
        }

        // Exclude the current element from the subset (backtrack)
        currSum -= arr[i];
    }

    // No subset found
    return false;
}
}
