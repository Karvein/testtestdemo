package karvein.test04;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "童话";
        String str3 = "童话";
        StringBuffer stringBuffer = new StringBuffer("Joker");
        StringBuilder stringBuilder = new StringBuilder("Rider");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        str3 = "DeathTop";
        System.out.println(str3.hashCode());

        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuilder.hashCode());
        System.out.println(stringBuffer.substring(1));
        System.out.println(stringBuilder.substring(3,5));
        System.out.println(stringBuffer.reverse());
        System.out.println(stringBuilder);
        System.out.println(stringBuffer.append("no"));
        for (char i :
                stringBuffer.toString().toCharArray()) {
            System.out.println(i);
        }

    }
}
