package ProgramChallenge2;

/**
 * Created by twb on 2017/9/15.
 */
public class No2_Sort {

    /**
     * 插入排序
     * @param A
     * @param len
     */
    public static void insertSort(int A[], int len){

        int j = 0;
        for(int i = 1; i < len; i++){
            int tmp = A[i];
            j = i - 1 ;
            while(j>=0 && A[j] < tmp){
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = tmp;
        }
        for(int ii : A){
            System.out.println(ii);
        }
    }


    public static void main(String[] args) {
        insertSort(new int[]{1,2,3,4,5}, 5);
    }

}
