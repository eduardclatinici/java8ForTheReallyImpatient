import java.util.concurrent.locks.*;
import java.util.function.*;
import java.util.logging.*;

import javafx.application.*;

public class Main {

    public static void main(String[] args) {
//        ex1Runner();
//        ex2Runner();
//        ex3Runner();
        Application.launch(Exercise5.class);
    }

    //Exercise 1
    private static void ex1Runner(){
        System.out.println("Exercise 1");
        String[] array = {"unu","doi","trei","patru","cinci","sase","sapte","opt","noua","zece"};
        for(int i=1; i<=10; i++)
            exercise1(i,array);
    }

    private static void exercise1(int i, String[] a) {
        //Change Level.FINEST
        logIf(Level.INFO, () -> i==10, () -> "a[10] = " + a[i-1], i);
    }

    private static void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message, int i) {
        Logger logger = Logger.getGlobal();
        if (logger.isLoggable(level) && condition.get())
            logger.log(level, message.get());
        else
            System.out.println("step "+i+" no log");
    }

    //Exercise 2
    private static void ex2Runner(){
        System.out.println("Exercise 2");
        ReentrantLock myLock = new ReentrantLock();
        withLock(myLock, ()-> System.out.println("firstLock"));
        withLock(myLock, ()-> System.out.println("secondLock"));
        withLock(myLock, ()-> System.out.println("2+2=4-1=3 quick maths"));

    }

    private static void withLock(ReentrantLock myLock, Runnable runnable){
        myLock.lock();
        try {
            runnable.run();
        } finally {
            myLock.unlock();
        }
    }

    //Exercise 3
    private static void ex3Runner() {
        System.out.println("Exercise 3");
        assertMethod(() -> 2+2 == 3); //is 4-1 that's 3, quick maths
    }

    private static void assertMethod(Supplier<Boolean> condition) {
        if (!condition.get())
            throw new AssertionError();
    }
}
