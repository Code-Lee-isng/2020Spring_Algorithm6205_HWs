package hw4;

/**
 * File Name: duplicateN.java
 * duplicateN concrete class
 * <p>
 * To Compile: IntUtil.java RandomInt.java duplicateN.java duplicateNBase.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class duplicateN extends duplicateNBase {
    duplicateN() {
        //NOTHING CAN BE CHANGED HERE
        testBed();
    }


    @Override
    protected int nsquare_time_constant_space() {
        //NOTHING CAN BE CHANGED HERE
        return alg_nsquare_time_constant_space();
    }

    private int alg_nsquare_time_constant_space(){
        int count = 0;
        boolean nSwitchOn = true;
        boolean nSwitchOff = false;
        for(int i = 0; i < a.length; i++){
            int num = 0;
            for(int j = 0; j < a.length; j++){
                if(a[j] == i){
                    num++;
                }
            }
            if(num > 1){
                count++;
                if(nSwitchOn && show) {
                    System.out.print("{");
                    nSwitchOn = false;
                    nSwitchOff = true;
                }
                if(show) {
                    System.out.print(i + " ");
                }
            }
        }
        if(nSwitchOff && show){
            System.out.println("}");
        }
        return count;
    }

    @Override
    protected int ntime_n_space() {
        //NOTHING CAN BE CHANGED HERE
        return alg_ntime_n_space();
    }

    private int alg_ntime_n_space() {
        int count = 0;
        int[] brr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            brr[a[i]]++;
        }

        boolean switchOff = false;
        boolean switchOn = true;

        for (int i = 0; i < brr.length; i++) {

            if (brr[i] > 1) {
                count++;
                if(switchOn && show){
                    System.out.print("{");
                    switchOn = false;
                    switchOff = true;
                }
                if(show) {
                    System.out.print(i + " ");
                }
            }
        }
        if(switchOff && show){
            System.out.println("}");
        }
        return count;
    }

    @Override
    protected int ntime_constant_space() {
        //NOTHING CAN BE CHANGED HERE
        return alg_ntime_constant_space();
    }

    private int alg_ntime_constant_space() {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[a[i]%n] < 2*n){
                a[a[i]%n] += n;
            }
        }
        boolean switchOff = false;
        boolean switchOn = true;

        for (int i = 0; i < n; i++) {
            if (a[i] / n >= 2) {
                count++;
                if(switchOn && show){
                    System.out.print("{");
                    switchOn = false;
                    switchOff = true;
                }
                if(show) {
                    System.out.print(i + " ");
                }
            }
            a[i] = a[i] % n;
        }
        if(switchOff && show){
            System.out.println("}");
        }
        return count;
    }

    //You can have any number of private data structures and procedure
    //YOU WRITE YOUR CODE BELOW. DO NOT CRAM entire code in one procedure


    public static void main(String[] args) {
        //NOTHING CAN BE CHANGED HERE
        System.out.println("duplicateN problem STARTS");
        duplicateN m = new duplicateN();
        System.out.println("You now understand why we should reduce O(n^2) algorithm to O(n) algorithm");
        System.out.println("duplicateN problem ENDS");
    }
}