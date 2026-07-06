class Solution {
public:
    void quickSort(vector<int>& nums, int low, int high) {
        if (low >= high) return;

        // Randomized pivot to avoid worst-case O(n^2) on sorted/patterned input
        int randIndex = low + rand() % (high - low + 1);
        swap(nums[randIndex], nums[high]);

        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums[i], nums[j]);
                i++;
            }
        }
        swap(nums[i], nums[high]);

        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    vector<int> sortArray(vector<int>& nums) {
        srand(time(0)); // seed once; fine here since sortArray is the entry point
        quickSort(nums, 0, nums.size() - 1);
        return nums;
    }
};