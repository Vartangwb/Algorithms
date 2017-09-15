package DesignPattern;

/**
 * Created by twb on 2017/9/14.
 */
public class Singleton {

    /**
     * 线程不安全的单例模式，线程A执行到 singleton_unsafe = new Singleton_unsafe(); 但是还没有获得对象，线程B也会判断S==null,
     */
    public static class Singleton_unsafe{
        private static Singleton_unsafe singleton_unsafe = null;
        private Singleton_unsafe(){};

        public Singleton_unsafe getSingleton_unsafe(){
            if(singleton_unsafe == null){
                singleton_unsafe = new Singleton_unsafe();
            }
            return singleton_unsafe;
        }
    }


    /**
     * 安全模式
     */
    public static class Singleton_safe{
        private static Singleton_safe singleton_safe = new Singleton_safe();
        private Singleton_safe(){};

        public Singleton_safe getSingleton_safe(){

            return singleton_safe;
        }
    }
}
