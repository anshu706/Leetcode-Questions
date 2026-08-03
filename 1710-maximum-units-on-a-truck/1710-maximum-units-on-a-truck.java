class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int totalUnits = 0;
        int boxesUsed = 0;
        
        for (int i = 0; i < boxTypes.length; i++) {
            int numBoxes = boxTypes[i][0];      
            int unitsPerBox = boxTypes[i][1];   
            int boxesToTake = Math.min(numBoxes, truckSize - boxesUsed);
            
            totalUnits += boxesToTake * unitsPerBox;
            boxesUsed += boxesToTake;
            
            if (boxesUsed == truckSize) {
                break;
            }
        }
        
        return totalUnits;
    }
}