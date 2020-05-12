package leetcode;

public class Test0038_CountAndSay {
    private static String mySolution(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            char[] chars = str.toCharArray();
            int start = 0, end = 0;
            StringBuilder temp = new StringBuilder();
            while (end < chars.length) {
                int count = 0;
                while (end < chars.length && chars[end] == (chars[start])) {
                    end++;
                    count++;
                }
                temp.append(count).append(chars[start]);
                start = end;
            }
            str = temp.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(5));
    }
}
