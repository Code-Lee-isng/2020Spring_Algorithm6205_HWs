class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //check validity
        if(matrix == null || matrix.length <=0 || matrix[0].length <= 0){
            return false;
        }
        //binary search, consider this 2D array as 1D array
        //only thing we need to do is convert mid into row and column,
        for(int left = 0, n = matrix.length * matrix[0].length, right = n - 1; left <= right; ){
            int mid = (left + right)/2;
            int midR = mid/matrix[0].length;
            int midC = mid%matrix[0].length;
            if(target == matrix[midR][midC]){
                return true;
            }else if(target > matrix[midR][midC]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
