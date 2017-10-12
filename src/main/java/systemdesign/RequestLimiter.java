package systemdesign;

import com.google.common.util.concurrent.RateLimiter;

/**
 * https://segmentfault.com/a/1190000007394128
 * token bucket
 *
 * http://blogread.cn/it/article/7579?f=sa
 * 有两种算法区别：
 * 基于漏桶(Leaky bucket)与令牌桶(Token bucket)
 * 区别：leaky bucket 控制平均速率，不太好控制输出突发性
 *      token bucket 能够达到一定突发性控制
 * 参考rateLimiter
 */
public class RequestLimiter {

    public static void main(String[] args) {
        //RateLimiter rateLimiter = RateLimiter.create();
    }
}
