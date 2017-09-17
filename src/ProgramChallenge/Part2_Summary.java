package ProgramChallenge;

/**
 * Created by twb on 2017/9/14.
 */
public class Part2_Summary {


    public static final int MAX_N = 1000;
    /**
     *最大公约数
     * gcd(a, b) = gcd(b, a%b);
     * ===>gcd(a, b) = gcd(c, 0);
     */
    int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 求解整数x,y使得ax+by=1
     * 如果gcd(a,b)!=1则无解
     */


    /**
     * 判断是否是素数问题
     * d是n的约数，那么n/d也是n的约数，由n = d*n/d可知，min(d,n/d)<=根号n
     * 所以只要检查2-根号n就足够了
     */

    boolean isPrime(int n){
        for(int i = 2; i * i <= n;i++){
            if(n % i == 0)
                return false;
        }
        return n != 1;
    }
    /**
     * 埃式筛法
     */

    int prime[] = new int[MAX_N];
    boolean isPrime[] = new boolean[MAX_N + 1];

    int sieve(int n){
        int p = 0;
        for(int i = 0; i <= n; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for(int i = 2;i<=n;i++){
            if(isPrime[i]){
                prime[p++] = i;
                for(int j = 2*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return p;
    }

    /**
     * 模运算
     *
     * 0 <= a mod m <= m-1
     * a是负数a%m的结果也是负的
     * 改为a%m +m保证结果在0-m-1之间
     */


    /**
     * 快速幂运算
     */
    int mod_pow(int x, int n, int mod){
        int res = 1;
        while(n > 0){
            if((n & 1) == 1)
                res = res * x % mod; //如果二进制最低位为1，则乘上x
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    /**
     * 对0,1矩阵排序直到变成上三角矩阵
     * @param n
     * @param M
     */
    public static void solve(int n, int M[][]){
        int res = 0;
        int[] a = new int[n];
        for(int i = 0; i < n;i++){
            a[i] = -1;
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    a[i] = j;
                }
            }
        }

        for(int i = 0; i < n; i++){
            int pos = -1;
            for(int j = i; j<n;j++){
                if(a[j] <= i){
                    pos = j;
                    break;
                }
            }

            for(int j = pos; j > i; j--){
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
                res++;
            }
        }
        System.out.println(res);
    }
    //通用的二分搜索
    public int binarySearch(int[] a, int n, int key){
        int low = 0;
        int high = n;
        int mid = 0;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(key == a[mid]){
                return mid;
            }else if(key < a[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    //第一个大于等于key的下标
    public int firstGreatOrEqual(int[] a, int n, int key){
        int low = 0;
        int high = n;
        int mid = 0;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(key <= a[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low <= n ? low : -1;
    }

    //第一个大于某个数的下标
    public int firstGreat(int[] a, int n, int key){
        //n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if(key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low <= n ? low : -1;
    }
    //查找数组中某个数的位置的最小下标
    public int firstIndex(int[] a, int n, int key){
        //n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if(key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low <= n) && (a[low] == key) ? low : -1;
    }

    //查找某个数位置的最大下标
    public int lastIndex(int[] a, int n, int key){
        //n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while(low <= high) {
            mid = low + ((high-low) >> 1);
            if(key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low - 1 >= 0 && (a[low - 1] == key))? low - 1: -1;
    }
    //查找数组中小于某个数的最大下标
    public int firstLess(int[] a, int n, int key) {
        // n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low - 1 >= 0) ? low - 1 : -1;
    }

    //返回区间
    public int getCount(int[] a, int n, int key) {
        // n + 1 个数
        int first = firstGreatOrEqual2(a, n, key);
        int last = firstGreat2(a, n, key);
        return last - first;
    }

    public int firstGreatOrEqual2(int[] a, int n, int key) {
        // n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (key <= a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int firstGreat2(int[] a, int n, int key) {
        // n + 1 个数
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        solve(4,new int[][]{{1,1,1,0},{1,1,0,0},{1,1,0,0},{1,0,0,0}});
    }
}
