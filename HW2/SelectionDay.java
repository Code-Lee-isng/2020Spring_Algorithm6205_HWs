package hw1;
import java.util.Arrays;
import java.util.Comparator;


/**
 * File Name: SelectionDay.java 
 * SelectionDay concrete class
 * 
 * To Compile: IntUtil.java RandomInt.java SelectionDay.java SelectionDayBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2020
 */

class SelectionDay extends SelectionDayBase{
	int itr ;
	SelectionDay() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}

	//create a two-dimensional array of Complex which is used to store values from array a;
	Complex [][] tempComplexForRacing = new Complex [5][5];

	@Override
	protected int race() {
		//NOTHING CAN BE CHANGED HERE
		//this is for recording the times of racing
		itr = 0 ;

		alg() ;

		return itr ;
	}

	protected void alg(){
		//assign array a into 2D Complex
		assignArrayToComplex2DArray();

		//process of sort,
		sortAll();
	}

	//You can have any number of private data structures and procedure
	//YOU WRITE YOUR CODE BELOW. DO NOT CRAM entire code in one procedure
	//Your output must be such that, any idiot, executes your steps should be able to conduct the race.

	protected void sortAll(){
		//sort every Array in this 2D Array of Complex
		sortArrayOfComplex();

		//Sorting 2D arrays based on the y value of first element of every array
		sortFirstColumnOf2DComplex();

		//sorting the last five elements
		sortLastFiveElements();
	}

	protected void sortLastFiveElements(){
		//for the last five students
		Complex [] lastFiveElements = new Complex[5];
		lastFiveElements[0] = tempComplexForRacing[0][1];
		lastFiveElements[1] = tempComplexForRacing[0][2];
		lastFiveElements[2] = tempComplexForRacing[1][0];
		lastFiveElements[3] = tempComplexForRacing[1][1];
		lastFiveElements[4] = tempComplexForRacing[2][0];

		SortArrayOfComplexComparator sortComparator = new SortArrayOfComplexComparator();
		Arrays.sort(lastFiveElements, sortComparator);

		itr++;
		s[1] = lastFiveElements[0].getY();
		s[2] = lastFiveElements[1].getY();
		print2DArray("After sorting last five elements", display);
	}

	class ArrayOf2DComplexComparator implements Comparator<Complex []>{
		@Override
		public int compare(Complex[] o1, Complex[] o2) {
			return o1[0].getX() - o2[0].getX();
		}
	}

	protected void sortFirstColumnOf2DComplex(){
		//either for loop, or Comparator,
		ArrayOf2DComplexComparator sortComparator = new ArrayOf2DComplexComparator();
		Arrays.sort(tempComplexForRacing, sortComparator);

		//recording the fastest student.
		s[0] = tempComplexForRacing[0][0].getY();
		itr++;

		print2DArray("After sortFirstColumnOf2DComplex", display);
	}

	public void print2DArray(String str, boolean display){
		if(display) {
			System.out.println("----------------  " + str + "  ----------------");
			for (Complex[] c1 : tempComplexForRacing) {
				for (Complex c2 : c1) {
					System.out.print(c2 + "	");
				}
				System.out.println();
			}
			System.out.println(">> So far, we have completed " + itr + " times of sorting. ");
			System.out.println();

			if (itr == 7) {
				System.out.print("The indexes of fastest three students are { ");
				for(int i = 0; i < 3; i++){
					if(i!=2){
						System.out.print( s[i] + ", ");
					}else{
						System.out.println(s[i] + " }");
					}
				}

				System.out.println();
				System.out.println("-------------------- One time of sorting is over --------------------");
				System.out.println();
				System.out.println();
			}
		}
	}

	protected void assignArrayToComplex2DArray(){
		int k = 0;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				//k: the index of that student; a[k]: which means speed of the student；
				tempComplexForRacing[i][j] = new Complex(a[k], k);
				k++;
			}
		}
		print2DArray("Before Sorting", display);
	}

	class SortArrayOfComplexComparator implements Comparator<Complex>{
		public int compare(Complex o1, Complex o2){
			return o1.getX() - o2.getX();
		}
	}

	protected void sortArrayOfComplex(){
		//sorting 5 arrays in 2D-array
		SortArrayOfComplexComparator complexComparator = new SortArrayOfComplexComparator();
		for(Complex [] tempComplex : tempComplexForRacing){
			//使用Complex的排序办法;
			Arrays.sort(tempComplex, complexComparator);
			itr++;
		}
		print2DArray("Sort Arrays Of 2D Complex", display);
	}

	//Number of tracks
	private int NT = N/5 ;

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("SelectionDay problem STARTS");
		SelectionDay m = new SelectionDay() ;
		System.out.println("SelectionDay problem ENDS");
	}
}