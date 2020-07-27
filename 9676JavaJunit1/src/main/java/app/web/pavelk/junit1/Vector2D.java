package app.web.pavelk.junit1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Vector2D {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double divide(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Can't divide by 0");
        }
        return n1 / n2;
    }

    public void connect() {
        try {
            Thread.sleep(996);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    //@Ignore тест не выполняеться
    //Assume
    //@BeforeClass при запуске один раз
    //@Before перед каждым тестом
    //@After после каждого теста
    //@AfterClass после класса

    //1e-9 равно девять нулей 0,0..01
    private double ESP = 1e-9;
    private Vector2D v1;

    @Before
    public void create() {
        v1 = new Vector2D();
    }

    @Test
    public void newVector() {
        //1 ожидаемое 2 факт 3 точьность
        Assert.assertEquals(0, v1.length(), ESP);
    }

    @Test
    public void newVector2y() {
        Assert.assertEquals(0, v1.getX(), ESP);
    }

    @Test
    public void newVector3x() {
        Assert.assertEquals(0, v1.getY(), ESP);
    }

    @Test(expected = ArithmeticException.class) // ожижаем исключение
    public void divide1() {
        v1.divide(1, 0);
    }

    @Test(timeout = 1000) // время выполнения
    public void connect1() {
        v1.connect();
    }

}


