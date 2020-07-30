package ex4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class LogicService {
    // создает вопрос проверяет ответ
    Random random;
    int resultRandom;
    public String answerStr;
    AtomicInteger a = new AtomicInteger();
    AtomicInteger b = new AtomicInteger();

    public LogicService() {
        this.random = new Random();
    }

    public String nextExample() { // пример example logic
        resultRandom = random.nextInt() % 10;
        if (resultRandom == 0) {
            a.set(Math.abs(random.nextInt() % 10));
            b.set(Math.abs(random.nextInt() % 10));
            int s = a.get() + b.get();
            answerStr = "" + s;
            return a + " + " + b + " = ";
        } else if (resultRandom == 1) {
            a.set(Math.abs(random.nextInt() % 10));
            b.set(Math.abs(random.nextInt() % 10));
            int s = a.get() - b.get();
            answerStr = "" + s;
            return a + " - " + b + " = ";
        } else if (resultRandom == 2) {
            a.set(Math.abs(random.nextInt() % 10));
            b.set(Math.abs(random.nextInt() % 10));
            int s = a.get() * b.get();
            answerStr = "" + s;
            return a + " * " + b + " = ";
        } else if (resultRandom == 3) {
            a.set(Math.abs(random.nextInt() % 10));
            b.set(Math.abs(random.nextInt() % 10));
            double s = a.doubleValue() / b.doubleValue();
            answerStr = "" + s;
            return a + " / " + b + " = ";
        } else if (resultRandom == 4) {
            a.set(Math.abs(random.nextInt() % 100));
            b.set(Math.abs(random.nextInt() % 100));
            int s = a.get() - b.get();
            answerStr = "" + s;
            return a + " - " + b + " = ";
        } else if (resultRandom == 5) {
            a.set(Math.abs(random.nextInt() % 100));
            b.set(Math.abs(random.nextInt() % 100));
            double s = a.doubleValue() / b.doubleValue();
            answerStr = "" + s;
            return a + " / " + b + " = ";

        } else if (resultRandom == 6) {
            a.set(Math.abs(random.nextInt() % 100));
            b.set(Math.abs(random.nextInt() % 100));
            int s = a.get() * b.get();
            answerStr = "" + s;
            return a + " * " + b + " = ";
        } else if (resultRandom == 7) {
            a.set(Math.abs(random.nextInt() % 1000));
            b.set(Math.abs(random.nextInt() % 1000));
            int s = a.get() + b.get();
            answerStr = "" + s;
            return a + " + " + b + " = ";
        } else if (resultRandom == 8) {
            a.set(Math.abs(random.nextInt() % 1000));
            b.set(Math.abs(random.nextInt() % 1000));
            int s = a.get() - b.get();
            answerStr = "" + s;
            return a + " - " + b + " = ";
        } else {
            a.set(Math.abs(random.nextInt() % 100));
            b.set(Math.abs(random.nextInt() % 100));
            int s = a.get() + b.get();
            answerStr = "" + s;
            return a + " + " + b + " = ";
        }
    }

    public boolean checkAnswer(String answerGui) {    // проверка checkAnswer
        return answerStr.equals(answerGui);
    }
}
