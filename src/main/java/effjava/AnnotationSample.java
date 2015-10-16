package effjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by mwei on 15-10-8.
 */
public class AnnotationSample {
    String name;
    String value;
    int intValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public static void injectfeild(Object o){
        Class<?> clazz = o.getClass();  //获得传进来的类
        Constructor[] constructors = clazz.getConstructors();

    }

    @AnnotationP(name = "test1", value = "test2", intValue = 03)
    public AnnotationSample() {
        injectfeild(this);
//        setName(AnnotationSample.class.getAnnotation(AnnotationP.class).name());
//        setValue(AnnotationSample.class.getAnnotation(AnnotationP.class).value());
//        setIntValue(AnnotationSample.class.getAnnotation(AnnotationP.class).intValue());
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void display() {
        System.out.println("name " + getName() + " value " + getValue() + " intValue " + getIntValue());
    }

    public static void main(String[] args) {
        AnnotationSample sample = new AnnotationSample();
        sample.display();
    }


}
