package app.web.pavelk.example1.reflection1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class R2 {
    public static void main(String[] args) {
        Dto2 dto2 = new Dto2();

        //получаем все публичьные методы
        Method[] methods1 = Dto2.class.getMethods();
        System.out.println(methods1.length);

        //получаем все объявленный методы
        Method[] methods2 = Dto2.class.getDeclaredMethods();
        System.out.println("Declared " + methods2.length);

        try {
            for (Method method : methods2) {
                //доступный для приватных методов
                method.setAccessible(true);
                System.out.println(method.getName() + " | " + method.invoke(dto2));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
