package com.example.helloworld;

public final class Foo implements Runnable {
    @Override public void run() {}

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(foo).run();
    }
}

class A {
    // Example for: THI00-J. Do not invoke Thread.run() method
    public void threadRunSample() {
        Object foo2 = new Object();
        Foo foo3 = new Foo();
        new Thread(foo3).run();
    }
}