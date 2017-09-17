package ProgramChallenge2;

import javax.swing.*;
import java.util.Stack;

/**
 * Created by twb on 2017/9/15.
 */
public class No3_Normal {

    public static int binarySearch(int key, int A[]){
        int left = 0;
        int right = A.length;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            if(key == A[mid]){
                return 1;
            }else if(key > A[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return 0;
    }



}
