package leetcode;

public class Test0150_EvaluateReversePolishNotation {
//    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//    Note:
//    Division between two integers should truncate toward zero.
//    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
//    Example 1:
//    Input: ["2", "1", "+", "3", "*"]
//    Output: 9
//    Explanation: ((2 + 1) * 3) = 9
//    Example 2:
//    Input: ["4", "13", "5", "/", "+"]
//    Output: 6
//    Explanation: (4 + (13 / 5)) = 6
//    Example 3:
//    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//    Output: 22
//    Explanation:
//            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//            = ((10 * (6 / (12 * -11))) + 17) + 5
//            = ((10 * (6 / -132)) + 17) + 5
//            = ((10 * 0) + 17) + 5
//            = (0 + 17) + 5
//            = 17 + 5
//            = 22
    private static int evalRPN(String[] tokens) {
        int[] nums = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String str : tokens) {
            switch (str) {
                case  "+":
                    nums[index - 2] += nums[--index];
                    break;
                case "-":
                    nums[index - 2] -= nums[--index];
                    break;
                case "*":
                    nums[index - 2] *= nums[--index];
                    break;
                case "/":
                    nums[index - 2] /= nums[--index];
                    break;
                default:
                    nums[index++] = Integer.parseInt(str);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int a = evalRPN(new String[]{"2", "1", "+", "3", "*"});
        int b = evalRPN(new String[]{"4", "13", "5", "/", "+"});
        int c = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
