package karvein.algorithem;

import org.junit.jupiter.api.Test;

/**
 * @Author: karvein
 * @Date: 2022/9/20
 * @Description:
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse((int)Math.pow(2,31)));
        System.out.println(reverse(0));
        System.out.println(reverse(-120232));
    }

    public static int reverse(int x) {
//        Object
        if (x == 0) {
            return 0;
        }
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = x * flag;
        }
        int ans = 0;
        int tmp = 0;
        while (true) {
            tmp = (x % 10);
            ans += tmp;
            x /= 10;
            if (x == 0) {
                break;
            }
            ans *= 10;
        }
        return ans * flag;
    }
}
