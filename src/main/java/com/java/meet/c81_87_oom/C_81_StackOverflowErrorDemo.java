package com.java.meet.c81_87_oom;


/**
 * 81_SOFE之StackOverflowError
 *
 * 请谈谈你对OOM的认识
 *      java.lang.StackOverflowError
 *                  是错误，还是异常。答案是错误
 *      java.lang.OutOfMemoryError:Java heap space
 *                  是错误，还是异常。答案是错误
 *      java.lang.OutOfMemoryError:GC overhead limit exceeded
 *
 *      java.lang.OutOfMemoryError:Direct buffer memory
 *      java.lang.OutOfMemoryError:unable to create new native thread
 *      java.lang.OutOfMemoryError:Metaspace
 *
 *
 *
 *      Error:
 *              StackOverflowError
 *              OutOfMemoryError
 *      Exception:
 *              RuntimeException
 *
 */
public class C_81_StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError(); // Exception in thread "main" java.lang.StackOverflowError
        // 是错误，还是异常。答案是错误
    }
}
