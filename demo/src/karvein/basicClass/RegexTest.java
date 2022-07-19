package karvein.basicClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is an annotation.
 * @author wwn
 * @since 2022.07.14
 * @version 1.0
 */
public class RegexTest {

    /**
     * Here are regEx tests.
     * @param args this element is from main function .
     */
    public static void main(String[] args) {

        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则 +至少一次 *至少0次 ?有或无 只对前一个子表达有效
        String regEx = "\\w+\\d*@((\\w\\d*)+\\.){1,3}\\w+";
        // 编译正则表达式
        Pattern pattern1 = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs1 = matcher1.matches();
        System.out.println(rs1);

        String content = "HELLO world 1.";
        String regex = "^\\w?(\\w+\\s+\\d*)+\\.?$";
        Pattern pattern2 = Pattern.compile(regex);
        Matcher matcher2 = pattern2.matcher(content);
        boolean rs2 = matcher2.matches();
        System.out.printf("Contains: %s" , rs2);
    }
}
