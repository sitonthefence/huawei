package LC;

import java.util.Stack;

public class LC224基本计算器 {

    public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int res = 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        for (int i = 0; i < n; i++) {
      /*      if (array[i] == ' ') {
                continue;
            }*/
            if (array[i] >= '0' && array[i] <= '9') {
                num = num * 10 + array[i] - '0';
            } else if (array[i] == '+' || array[i] == '-') {
                res = res + sign * num;

                //将参数重置
                num = 0;
                sign = array[i] == '+' ? 1 : -1;
                // 遇到左括号，将结果和括号前的运算保存，然后将参数重置
            } else if (array[i] == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (array[i] == ')') {
                // 将右括号前的运算结束
                res = res + sign * num;

                // 将之前的结果和操作取出来和当前结果进行运算
                int signBefore = stack.pop();
                int resBefore = stack.pop();
                res = resBefore + signBefore * res;

                // 将参数重置
                sign = 1;
                num = 0;
            }
        }
        res = res + sign * num;
        return res;
    }
}

/*    当然，因为只有加法和减法，所以可以不用上边通用的的方法，可以单独分析一下。

    首先，将问题简单化，如果没有括号的话，该怎么做？

            1 + 2 - 3 + 5

    我们把式子看成下边的样子。

            + 1 + 2 - 3 + 5

    用一个变量 op 记录数字前的运算，初始化为 +。然后用 res 进行累加结果，初始化为 0。用 num 保存当前的操作数。

    从上边第二个加号开始，每次遇到操作符的时候，根据之前保存的 op 进行累加结果 res = res op num，然后 op 更新为当前操作符。

    下边考虑包含括号的问题。

可能是这样 1 - (2 + 4) + 1，可能括号里包含括号 2 + (1 - (2 + 4)) - 2

做法也很简单，当遇到左括号的时候，我们只需要将当前累计的结果，以及当前的 op 进行压栈保存，然后各个参数恢复为初始状态，继续进行正常的扫描计算。

当遇到右括号的时候，将栈中保存的结果和 op 与当前结果进行计算，计算完成后将各个参数恢复为初始状态，然后继续进行正常的扫描计算。

举个例子，对于 2 + 1 - (2 + 4) + 1，遇到左括号的时候，我们就将已经累加的结果 3 和左括号前的 - 放入栈中。也就是 3 - (...) + 1。

接着如果遇到了右括号，括号里边 2 + 4 的结果是 6，已经算出来了，接着我们从栈里边把 3 和 - 取出来，也就是再计算 3 - 6 + 1 就可以了。

结合代码再看一下。*/

