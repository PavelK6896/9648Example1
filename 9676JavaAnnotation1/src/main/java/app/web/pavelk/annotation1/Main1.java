package app.web.pavelk.annotation1;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main1 {
    String p1 = "p1";

    @Annotation1(author = "cat1", dateOf = 100115)//библеотека
    private String f1(){//
        System.out.println("f1");
        return "f1";
    }

    public String f2(){//
        System.out.println("f2");
        return "f1";
    }
    //class Class name, packageName, attributes, methods;
    //Class c = Main1.class;
    //Class c = obj.getClass();
    //Class c = Class.forName("package.Class");


    public static void main( String[] args) {
        Class c = Main1.class;
        Method[] methods = c.getMethods();//to public
        Method[] methods2 = c.getDeclaredMethods();//to private  // Declared - Объявленный

        Arrays.stream(methods2).forEach(f -> {
            System.out.println("name " + f.getName());//имя метода
            System.out.println("return t " + f.getReturnType());//возврощаемое знч
            System.out.println("init p " + Arrays.toString(f.getParameterTypes()));//тип параметра
            System.out.println("a " + Arrays.toString(f.getAnnotations()));
          //  System.out.println("da " + Arrays.toString(f.getDeclaredAnnotations()));
            System.out.println("-- -- --");
        });

        Annotation[] annotations1 = c.getAnnotations();
        Annotation[] annotations2 = c.getDeclaredAnnotations();

        Arrays.stream(annotations2).forEach(a -> {
            System.out.println(a);
        });

        //////
        //c.newInstance(); пустой конструктор
        //c.getMethod(...); метод по параметрам
        //c.getConstructor(...).newInstance(); конструктор по параметрам
        //methods[0].invoke(); взывать

        try {
            Method m1 = c.getDeclaredMethod("f1");//получить метод
            Method m2 = c.getMethod("f2");
            Object o = c.getConstructor().newInstance();//создать обьект
            m1.invoke(o);//вызвать у объекта
            m2.invoke(o);//вызвать у обекта
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
