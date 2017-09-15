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
}
