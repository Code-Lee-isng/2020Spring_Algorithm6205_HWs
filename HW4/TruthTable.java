package hw4;


public class TruthTable {
    private int n ;
    private boolean display ;
    static IntUtil u = new IntUtil() ;

    TruthTable(int n, boolean b) {
        this.n = n ;
        this.display = b ;
        printTruthTable() ;
    }
    //T: O(n * 2^n)
    //S: O(n)
    private void printTruthTable(){
        int [] arr = new int [n];

        for(int i = 0; i < Math.pow(2, n); i++) {
            if(display) {
                printArray(arr);
            }
            addArray(arr);
        }
    }
    private void printArray(int [] arr){

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private void addArray(int [] arr){
        for(int i = arr.length - 1; i >= 0; ){
            if(arr[i] == 0){
                arr[i] = 1;
                return;
            }else{
                arr[i] = 0;
                i--;
            }
        }
    }

    /*
     * ----------  YOU CANNOT CHANGE ANYTHING BELOW--------------------------
     */
    private static void testBench() {
        for (int i = 1 ; i < 31; ++i) {
            boolean display = (i > 10) ? false : true ;
            System.out.println("------------Truth table of " + i + " inputs function --------------");
            long startTime = System.nanoTime();
            //If display is true, you should print like this:
            //------------Truth table of 2 inputs function --------------
            //00
            //01
            //10
            //11
            //For 2 inputs, table size is 4


            //If display is false, you must go through the same procedure
            //buy you should print only the last line like this
            //------------Truth table of 29 inputs function --------------
            //For 29 inputs, table size is 536870912

            TruthTable t = new TruthTable(i,display) ;
            long endTime = System.nanoTime();
            double d = u.timeInSec(endTime,startTime) ;
            System.out.println("Cpu time for n = " + i + " is " + d + " seconds");
        }
    }

    public static void main(String[] args) {
        System.out.println("TruthTable.java Starts array in 2002");
        testBench();
        System.out.println("YOU CANNOT USE bigInteger class");
        System.out.println("Must use only basic java to solve this problem");
        System.out.println("Attach TruthTable.java and output of this program as a pdf file for full grade");
        System.out.println("TruthTable.java ends");
    }
}
