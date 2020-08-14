package com.vincent.algorithm.jdk;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    }

    public static class MyThread {
        public MyThreadLocal.MyThreadLocalMap myThreadLocalMap;
    }

    public static class MyThreadLocal<T> {

        public MyThreadLocalMap getMap(MyThread t) {
            return t.myThreadLocalMap;
        }

        public T get() {
            // 模拟线程获取
            MyThread t = new MyThread();
            MyThreadLocalMap map = getMap(t);
            if (map != null) {
                MyThreadLocalMap.MyEntry e = map.getEntry(this);
                if (e != null) {
                    T result = (T) e.value;
                    return result;
                }
            }

            return setInitValue();

        }


        public void set(T value) {
            // 模拟获取线程
            MyThread t = new MyThread();
            MyThreadLocalMap map = getMap(t);
            if (map != null) {
                map.set(this,value);
            }
            else {
                t.myThreadLocalMap = new MyThreadLocalMap(this,value);
            }
        }

        private T setInitValue() {
            T value = initialValue();
            // 模拟线程
            MyThread t = new MyThread();
            MyThreadLocalMap map = getMap(t);
            if (map != null) {
                map.set(this, value);
            } else {

            }

            return value;

        }

        protected T initialValue() {
            return null;
        }


        static class MyThreadLocalMap {

            public void set(MyThreadLocal<?> key, Object value) {
                table.put(key, new MyEntry(key, value));
            }

            static class MyEntry extends WeakReference<MyThreadLocal<?>> {
                Object value;

                MyEntry(MyThreadLocal<?> k, Object v) {
                    super(k);
                    value = v;
                }
            }

            private HashMap<MyThreadLocal<?>, MyEntry> table;

            public MyThreadLocalMap(MyThreadLocal<?> firstKey, Object value) {
                table = new HashMap<>();
                table.put(firstKey, new MyEntry(firstKey, value));
            }

            private MyEntry getEntry(MyThreadLocal<?> key) {
                return table.get(key);
            }
        }
    }
}
