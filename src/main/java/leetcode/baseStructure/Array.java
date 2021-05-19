package leetcode.baseStructure;

public class Array {
    public static int[][] convert(String arrStr) {
        String[] split = arrStr.replaceAll(" ","")
                .replaceAll("\\[\\[|]]", "")
                .split("],\\[");
        int length = split[0].split(",").length;
        int[][] result = new int[split.length][length];
        for (int i = 0; i < split.length; i++) {
            String[] sub = split[i].split(",");
            for (int j = 0; j < sub.length; j++) {
                result[i][j] = Integer.parseInt(sub[j]);
            }
        }
        return result;
    }
}
