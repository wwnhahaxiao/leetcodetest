package leetcode;

import java.util.ArrayList;
import java.util.List;

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

    public enum MyEnum {
        aa("a", (byte) 0),
        bb("b", (byte) 1),
        cc("c", (byte) 2);

        private final String name;
        private final Byte index;

        MyEnum(String name, Byte index) {
            this.name = name;
            this.index = index;
        }

        public Byte getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "{'name':'" + name + "', 'index':'" + index +"'}";
        }
    }

    public static void main(String[] args) {
        List<MyEnum> list = new ArrayList<>();
        list.add(MyEnum.aa);
        list.add(MyEnum.bb);
        list.add(MyEnum.cc);
        System.out.println(list.toString());
    }
}
