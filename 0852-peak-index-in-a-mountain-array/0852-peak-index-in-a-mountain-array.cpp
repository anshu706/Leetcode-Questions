class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int st = 1, end = arr.size() - 2;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            // Found the peak
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            // On descending slope -> peak is to the left
            else if(arr[mid+1] < arr[mid]) {
                end = mid - 1; // FIXED: shifted from st = mid + 1
            }
            // On ascending slope -> peak is to the right
            else {
                st = mid + 1;  // FIXED: shifted from end = mid - 1
            }
        }
        return -1;
    }
};
