import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger a = new BigInteger("1");

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0 ;i < n ; i++)
            a= a.multiply(new BigInteger(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BigInteger b = new BigInteger("1");

        for(int i =0 ; i < m ; i++)
            b= b.multiply(new BigInteger(st.nextToken()));

        findGCD(a,b);
    }

    public static void findGCD(BigInteger a , BigInteger b) {
        BigInteger big = a.compareTo(b) > 0 ? a : b;
        BigInteger small = a.compareTo(b) > 0 ? b : a;
        BigInteger zero = new BigInteger("0");
        while(true) {
            BigInteger mod = big.mod(small);

            if(mod.compareTo(zero) == 0)
                break;

            big = small;
            small = mod;
        }

        String ans = small.toString();

        if(ans.length() > 9) {
            ans = ans.substring(ans.length()-9);
        }

        System.out.println(ans);
    }
}
// 출처 : https://velog.io/@jms8732/2824.-%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98