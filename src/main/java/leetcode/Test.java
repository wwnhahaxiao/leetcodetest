package leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private int state;
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.state);
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
    }
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
}
