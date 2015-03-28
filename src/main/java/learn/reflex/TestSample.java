package learn.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wmc on 2014/12/9.
 */
public class TestSample {

    private void test1() {
        System.out.println("Hello world, private !!!");
    }

    public void test2() {
        System.out.println("Hello world, public !!!");
        test1();
    }

    public static void main(String[] args) {
        try {
            Class actionClass = Class.forName(TestSample.class.getName());
            Method method1 = actionClass.getMethod("test2", null);
            Object action = actionClass.newInstance();
            method1.invoke(action, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
