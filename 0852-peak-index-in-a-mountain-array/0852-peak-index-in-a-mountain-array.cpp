class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int st = 0, end = arr.size() - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            // If mid element is smaller than the next, we are on the ascending slope.
            // The peak must be to the right, strictly after mid.
            if (arr[mid] < arr[mid + 1]) {
                st = mid + 1;
            } 
            // If mid element is larger than or equal to the next, we are on the descending slope.
            // The peak could be mid itself or to the left of mid.
            else {
                end = mid;
            }
        }
        
        // st and end converge to the peak index
        return st;
    }
};
