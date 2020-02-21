package hw3;
/**
 * File Name: Range.java 
 * Range concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Range.java RangeBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Range extends RangeBase{
	Range() {
		//NOTHING CAN BE CHANGED HERE
		testBed() ;
	}

	@Override
	int[] Range(int [] a, int n)  {
		//NOTHING CAN BE CHANGED HERE
		numSteps = 0 ; //MUST update this data. Without this assert fails
		return alg(a,n) ;
	}

	private int[] alg(int [] a, int n) {
		//WRITE CODE
		//robustness
		if(a == null || a.length <= 0 ){
			return null;
		}
		//processing
		return findTarget(a, n);
	}

	//first, find whether target is inside of arr or not
	private int [] findTarget(int [] arr, int target){
		int [] result = {-1, -1};

		for(int left = 0, right = arr.length - 1; left <= right; ){
			int mid = ((right - left)>>1)+ left;

			numSteps++;

			if(target == arr[mid]){
				result[0] = mid;
				result[1] = mid;
				//target exits, then find two sides of it,
				findLeftSide(arr, left, mid - 1, (mid - 1 - left)/2 + left, target, result);
				findRightSide(arr, mid + 1, right, (right - mid - 1)/2 + mid + 1, target, result);
				return result;
			}else if(target < arr[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return result;
	}

	//find the left side of the target
	private void findLeftSide(int [] arr, int left, int right, int mid, int target, int [] result){
		//binary search, for loop, in array
		for( ; left <= right; mid = ((right - left)>>1) + left){
			numSteps++;
			//only two circumstance, either ==, or target is greater,
			if(target == arr[mid]){
				result[0] = mid;
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
	}

	//find the right side of the target
	private void findRightSide(int [] arr, int left, int right, int mid, int target, int [] result){
		//binary search, for loop, in array
		for( ; left <= right; mid = ((right - left)>>1) + left) {
			numSteps++;
			//only two cases, either "equal", or target is lesser,
			if(target == arr[mid]){
				result[1] = mid;
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
	}

	/**
	 * the following is another way:
	 * 	First step, using binary search to find the left side;
	 * 	Second step. using binary search to find the right side;
	 * However, sometimes the time complexity is greater than 2 * (Math.log(a.length)/Math.log(2)) + 1;
	 * -----------------------------------------------------------------------------------------------------|
	 * For a specific array, the time complexity could be greater than lg(n) using binary search
	 *
	 * Example
	 *  int [] arr = {1, 2, 3, 4}; to find target(4) inside of this array
	 * 	Theoretically, lg(n) = lg(4) = 2; --> two steps
	 * 	However,
	 *	It needs 3 steps using Binary Search to find 4.
	 * -----------------------------------------------------------------------------------------------------|
	 *
	 * After all, for optimizing, first we can have a check whether this is a target inside of the array.
	 *
	 * If it exits, we can track to two sides to find two borders of it.
	 * Otherwise, return {-1, -1};
	 *
	 * @param args
	 */
	/*
	private int[] alg(int [] a, int n) {
		//WRITE CODE
		if(a == null || a.length <= 0){
			return new int[]{-1, -1};
		}
		return new int [] {findLeftSide(a, n), findRightSide(a, n)};
	}

	private int findLeftSide(int [] arr, int target){
		int temp = -1;
		for(int left = 0, right = arr.length - 1, mid = (left + right)/2; left <= right; mid = (left + right)/2) {
			//numSteps++;
			//System.out.println("steps=" + numSteps + ", left=" + left + ", mid=" + mid + ", right=" + right);
			if(target == arr[mid]){
				temp = mid;
				right = mid - 1;
			}else if(target < arr[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
			//numSteps++;
			//System.out.println("steps=" + numSteps + ", left=" + left + ", mid=" + mid + ", right=" + right);
		}
		//System.out.println("steps=" + numSteps + ", left=" + left + ", mid=" + mid + ", right=" + right);
		return temp;
	}

	private int findRightSide(int [] arr, int target){
		int temp = -1;
		for(int left = 0, right = arr.length - 1, mid = (left + right)/2; left <= right; mid = (left +  right)/2) {
			//numSteps++;
			//System.out.println("steps=" + numSteps + ", left=" + left + ", mid=" + mid + ", right=" + right);
			if(target == arr[mid]){
				temp = mid;
				left = mid + 1;
			}else if(target < arr[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return temp;
	}
	 */

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Range problem STARTS");
		Range m = new Range() ;
		System.out.println("All Range tests passed. Get me a bar of candy");
		System.out.println("Range problem ENDS");
	}
}
