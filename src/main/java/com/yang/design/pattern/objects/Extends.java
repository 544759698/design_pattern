package com.yang.design.pattern.objects;

/**
 * 1.当一个类继承于另一个类，子类中没有父类的方法时，用子类的对象调用方法时，
 * 会首先在子类中查找，如果子类中没有该方法，再到父类中查找。
 * 2.当一个方法只在父类中定义时，调用该方法时会使用父类中的属性。
 * 3.如果该方法中又调用了其他方法，那么还是按照之前的顺序，先在子类中查找，再在父类中查找。
 *
 * @Author: yangguojun01
 * @Date: 2023/2/9
 */
public class Extends {
    public static void main(String[] args) {
        new T3().test1();
    }
}

class T1 {
    public void test() {
        System.out.println("T1");
        System.out.println("T1");
    }
}

class T2 extends T1 {
    @Override
    public void test() {
        System.out.println("T2");
        System.out.println("T2");
    }
}

class T3 extends T2 {
    public void test1() {
        ((T1) this).test();
    }
}
