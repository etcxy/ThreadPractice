BlockQueue可能会出现以下"不安全现象"：
1. 生产者还没生产出来，消费者已经消费了。
2. BlockQueue是FIFO队列，但会出现后进先出的假象。

个人愚见：
BlockQueue只能保证put()和take()调用的原子性。出现以上两种情况
1. 生产者put()生产好了，还没来得及sout，cpu执行权交给了消费者take()。
2. 消费者1 take()消费了1，还没来得及sout，cpu执行权交给了消费者2take()操作，并执行了sout操作。