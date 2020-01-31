/**
 * File Name: Search12D.java 
 * Search12D concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Search12D.java Search12DBase.java
 *
 * We can do it in two ways.
 *
 * First method:
 * Copy the matrix into a one-dimensional array, then using binary search to find the target.
 * In this way, the Time Complexity is O( lg(n) ), Space Complexity is O(n).
 *
 * Second Method:
 * Using binary search directly, transfer the index between "one-dimensional array" and "two-dimensional array".
 * Time complexity is O( lg(n) ), Space Complexity is O(1).
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Search12D extends Search12DBase{
	Search12D() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}

	@Override
	protected boolean search12D(int t) {
		//NOTHING CAN BE CHANGED HERE
		return alg(t) ;
	}

	private boolean alg(int t) {
		//WRITE CODE
		int row = r();
		int col = c();
		int [][] matrix = copyMatrix(row, col);
		int n = row * col;
		//binary search,
		for(int left = 0, right = n - 1; left <= right; ) {
			int mid = (left + right)/2;
			//calculate the index of the middle point,
			int mMidRow = mid/col;
			int mMidCol = mid%col;
			if(t == matrix[mMidRow][mMidCol]){
				return true;
			}else if(t > matrix[mMidRow][mMidCol]){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return false;
		//-----------------------------------
	}

	//copy matrix into a new 2D array
	private int[][] copyMatrix(int row, int col){
		int [][] arr2D = new int [row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				arr2D[i][j] = get(i, j);
			}
		}
		return arr2D;
	}

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Search12D problem STARTS");
		Search12D m = new Search12D() ;
		System.out.println("All Search12D tests passed. You are genius");
		System.out.println("Search12D problem ENDS");
	}
}