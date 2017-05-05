package company.amazon.amazon126;

/**
 * http://blog.csdn.net/wlqingwei/article/details/44037693
 *
 * the conclusion:
 *
 * 固定m, 视n为变量。定义F(n)为: n人时，胜利者的编号。
    则n 人时，胜利者编号为
    0,  1,  2,  3,  ...,  m-1(*), m, m+1,  ..., n-1;
    去掉一人后，还剩余n-1人。 且这n - 1 人与n人时的index对应关系如下：
    m,   m+1, ...., n-1,  0, 1, 2, 3, ....., m -2
    0,     1,      ...,       ...,       ......... ,       n-2.  (总共n-1个人)
    则F(n)  = F(n-1) + m;

    最后再考虑 m与n的关系， m可能会大于n. 所以需要取模
    F(n) = ( F(n-1) + m  ) %n.
 */
public class JosephProblem {
}
