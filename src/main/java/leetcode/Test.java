package leetcode;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test {

    /*
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择再加入选择列表
     */

    @org.junit.Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("aa", "1");
        map.put("bB", "1");
    }

}
