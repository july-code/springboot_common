package com.example.demo.study;

public class ExceptionDemo {

    public static void main(String[] args) throws NoGrilException {
//        Demo1();
//        Demo2();
//        以下的捕获或者抛出二选一；
//        进行捕获
        try {
            buyOneFreeOne(false);
        } catch (NoGrilException e) {
            e.printStackTrace();
        }

        //进行抛出
        buyOneFreeOne(true);  //这里是抛出，所以上面需要加throws
    }

    private static void Demo2() {
        //Error:这里假设系统的内存空间为8GB
        long[] arr = new long[1024 * 1024 * 1024];
        //Exception in thread "main"java.lang.OutOfMemoryError:
        //根据末尾知道这是错误：程序使用的内存空间超过了当前硬件限制

        int[] arr1 = null; //数组名为arr1的引用类型变量保存的是null;
        arr1[0] = 7;
        //Exception in thread "main" java.lang.NullPointerException
        //异常，空指针异常，表示当前代码操作Null地址空间
    }

    private static void Demo1() {
        //首先创建一个异常类，
        //调用的无参的构造方法，创建了一个异常信息为null的Throwable类对象
        //调用有参的构造方法，创建一个异常信息为message的Throwable类对象

        //Throwable throwable = new Throwable(); //调用无参构造方法
        Throwable throwable2 = new Throwable("这里出错啦"); //调用有参构造方法

        System.out.println(throwable2.getMessage());
        System.out.println(throwable2.toString());
        //throwable2.printStackTrace();

        testThrowable(); //调用该异常位置；
    }

    public static void testThrowable(){
        Throwable throwable = new Throwable("这里有问题"); //创建该异常位置；
        throwable.printStackTrace();
    }

    public static void buyOneFreeOne(boolean isLonely) throws NoGrilException {
        if (isLonely) {
            //直接创建自定义异常的匿名类对象，通过throw关键字跳出
            throw new NoGrilException("不用，谢谢");
        }
        System.out.println("阔以");
    }
}


class NoGrilException extends Exception {
    //String message 是当前异常的详细信息，用来传递给Exception的构造方法，保存该异常信息；
    public NoGrilException(String message) {
        super(message);
    }

}
