package app.web.pavelk.example1.reflection1;

import java.lang.reflect.Field;

public class R1 {
    public static void main(String[] args) {
        Dto1 dto1 = new Dto1();

        //получаем все публичьные поля
        Field[] fields1 = Dto1.class.getFields();
        System.out.println(fields1.length);
        //получаем все приватные поля
        Field[] fields2 = Dto1.class.getDeclaredFields();
        System.out.println("Declared " + fields2.length);

        try {

            //получам одно публичьное поле по имени
            for (Field field : fields1) {
                Field field1 = dto1.getClass().getField(field.getName());
                System.out.println("public " + field1.get(dto1) + " | " + field1.toGenericString());
            }

            //получаем приватное поле по имени
            for (Field field : fields2) {
                Field field2 = dto1.getClass().getDeclaredField(field.getName());
                //для приватного поля
                System.out.print(field2.toGenericString() + " | ");
                field2.setAccessible(true);//Доступный
                System.out.println("Declared " + field2.get(dto1));
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
