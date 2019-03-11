package tool;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author Hearts
 * @date 2019/2/20
 * @desc
 */
public class ThreadTool {

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void println(Object message){
        System.out.println(message);
    }

    public static void println(String format,Object ...args){
        println(String.format(format,args));
    }

    public static void wait(Object obj){
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void notify(Object obj){
        obj.notify();
    }

    public static void notifyAll(Object obj){
        obj.notifyAll();
    }



}
