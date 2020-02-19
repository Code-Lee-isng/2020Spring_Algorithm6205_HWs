package hw5_part2;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * File Name: ThreeSum.java
 * ThreeSum  class
 * <p>
 * To Compile: IntUtil.java RandomInt.java Tuple.java ThreeSumBase.java ThreeSum.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class ThreeSum extends ThreeSumBase {
    ThreeSum() {
        //NOTHING CAN BE CHANGED HERE
        testBench();
    }

    @Override
    protected String inputFileBase() {
        //Where is the input file?
        //Change this to your location
        return "/Users/mingwang/Files/";
    }

    @Override
    protected List<List<Integer>> threeSum(int[] nums, int n, int method) {
        System.out.println("method = " + method);
        //NOTHING CAN BE CHANGED HERE
        if (method == 1) {
            return N3TimeConstantSpace(nums, n);
        }
        if (method == 2) {
            return N2TimeNSpace(nums, n);
        }
        if (method == 3) {
            return N2TimeConstantSpace(nums, n);
        }
        return null;
    }

    /*
     * Time complexity O(N^3)
     * Space complexity O(1)
     */
    private List<List<Integer>> N3TimeConstantSpace(int[] nums, int n) {
        //WRITE CODE
        /*System.out.println("第一个方法重新在线");*/
        //sort the array
        Arrays.sort(nums);
        //new List
        List<List<Integer>> lists = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //dealing repetitions
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //dealing repetitions
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    //error 1, overflow, died here one day
                    if ((long) nums[i] + (long) nums[k] + (long) nums[j] == n) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                        break;
                    }
                }
            }
        }

        return lists;
    }

    /*
     * Time complexity O(N^2)
     * Space complexity O(N)
     */
    private List<List<Integer>> N2TimeNSpace(int[] nums, int n) {
        //WRITE CODE
        /*System.out.println("Before sort....." + Arrays.toString(nums));*/
        //sort the array
        Arrays.sort(nums);
        /*System.out.println("After sort....." + Arrays.toString(nums));*/
        //new lists
        List<List<Integer>> lists = new LinkedList<>();
        //store the array
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //long is important
            hm.put((long) nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long dif = (long) n - nums[i] - nums[j];
                if (hm.containsKey(dif) && hm.get(dif) > j) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add((int) dif);
                    lists.add(list);
                }
            }
        }
        /*System.out.println("printing list to see...");
        printList(lists);*/

        return lists;
    }

    /*
     * Time complexity O(N^2)
     * Space complexity O(1)
     */
    private List<List<Integer>> N2TimeConstantSpace(int[] nums, int n) {
        //WRITE CODE
        //new List

        List<List<Integer>> lists = new LinkedList<>();
        //sort
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //another exception, duplicate ans,
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            long dif = (long) n - nums[i];
            while (left < right) {
                if ((long) nums[left] + nums[right] > dif) {
                    right--;
                } else if ((long) nums[left] + nums[right] < dif) {
                    left++;
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //almost endless loop
                    left++;
                    right--;
                }
            }

        }
        return lists;
    }

    public static void main(String[] args) {
        if (false) { //Change it true, if you want to dump all output to a file
            System.out.println("Writing to 3sumoutput.txt");
            try {
                System.setOut(new PrintStream(new FileOutputStream("3sumoutput.txt")));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("ThreeSum.java STARTS");
        String version = System.getProperty("java.version");
        System.out.println("Java version used for this program is " + version);
        ThreeSum p = new ThreeSum();
        System.out.println("ThreeSum.java ENDS");
    }
}
