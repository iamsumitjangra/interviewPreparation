import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l] <= nums[mid]){ //checking if first half array is sorted if so
                if(nums[l] <= target && target < nums[mid]){ //check if target lies in the range if so
                    r = mid - 1;                              // search in first half only
                }else                                         //else search in second half
                    l = mid + 1;
            }else{  //if first half isn't sorted go and check for second
                if(nums[mid] < target && target <= nums[r]){ //check if target lies in second half
                    l = mid + 1;                             //if so search in second half
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }

    static void convert_to_words(char[] num) 
    { 
        // Get number of digits 
        // in given number 
        int len = num.length;  
      
        // Base cases  
        if (len == 0)  
        { 
            System.out.println("empty string"); 
            return; 
        } 
        if (len > 4)  
        { 
            System.out.println("Length more than 4 is not supported"); 
            return; 
        } 
      
        String[] single_digits = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        String[] two_digits = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; 
        String[] tens_multiple = new String[]{"", "", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety"}; 
        String[] tens_power = new String[] {"hundred", "thousand"}; 
        System.out.println(String.valueOf(num)+": "); 
      
        /* For single digit number */
        if (len == 1){ 
            System.out.println(single_digits[num[0] - '0']); 
            return; 
        } 
      
        /* Iterate while num is not '\0' */
        int x = 0; 
        while (x < num.length){ 
      
            /* Code path for first 2 digits */
            if (len >= 3){ 
                if (num[x]-'0' != 0){ 
                    // System.out.print(single_digits[num[x] - '0']+" "); 
                    // System.out.print(tens_power[len - 3]+" ");  
                    System.out.println(single_digits[num[x] - '0']+" "); 
                    System.out.println(tens_power[len - 3]+" ");  

                    // here len can be 3 or 4 
                } 
                --len; 
            } else{ 
                /* Code path for last 2 digits */
            
                /* Need to explicitly handle 10-19. Sum of the two digits is used as index of "two_digits" array of strings */
                if (num[x] - '0' == 1){ 
                    int sum = num[x] - '0' +  num[x+1] - '0';
                    System.out.println("x = " + Integer.toString(x) + ", " + two_digits[sum]); 
                    return; 
                } else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0){ 
                    System.out.println("x = " + Integer.toString(x) + ", " + "twenty"); 
                    return; 
                } else { 
                    int i = (num[x] - '0'); 
                    if(i > 0) 
                    System.out.println("x = " + Integer.toString(x) + ", " + tens_multiple[i]+" "); 
                    else
                    System.out.println("x = " + Integer.toString(x) + ", " + ""); 
                    ++x; 
                    if (num[x] - '0' != 0) 
                        System.out.println("x = " + Integer.toString(x) + ", " + single_digits[num[x] - '0']); 
                } 
            } 
            ++x; 
        } 
    } 
      
    // Driver Code 
    public static void main(String[] args) throws Exception
    { 
        // BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        // Integer n = Integer.parseInt(reader.readLine());
        // int[] arr = {4,6,5,9,3,1,8,7};

        // Arrays.sort(arr);
        // System.out.println(arr[0]);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("vishal", 10); 
        map.put("sachin", 30); 
        map.put("vaibhav", 20); 

        // int val = map.get('sumit');
        // System.out.println(val);

    } 
}