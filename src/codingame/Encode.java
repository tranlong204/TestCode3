package codingame;
/*
PlainText
aabaa
EncodedText
2a1b2a

PlainText
aaaabcccaaa
EncodedText
4a1b3c3a
 */
public class Encode {
    public static String encode(String plainText) {
        if (plainText == null || plainText.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int n = plainText.length();

        for (int i = 0; i < n;) {
            char c = plainText.charAt(i);
            int j = i + 1;
            while (j < n && plainText.charAt(j) == c) ++j;
            sb.append(j - i).append(c);
            i = j; // jump to next run
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabcccaaad";
        System.out.println(encode(s));
    }
}
