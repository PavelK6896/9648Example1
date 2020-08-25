package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {
        //1. Создать и запустить программу для построения двоичного дерева.
        // В цикле построить двадцать деревьев с глубиной в 6 уровней.
        // Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
        // Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.

        //создаем деревья
        Random rnd = new Random();
        int value;
        ArrayList<Tree> treeArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            treeArrayList.add(new Tree());
        }
        int balans = 0;



        for (Tree tr : treeArrayList) {//обходим деревья
            for (int j = 0; j < 20; j++) {//заполняем

                value = -99 + rnd.nextInt(99 - (-99) + 1);

                tr.insert(new Person(value, value, j));
            }
            tr.displayTree();
            if (tr.balans3()) {
                balans++;
            }
            System.out.println("----------------------------------");
        }
        //2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
        System.out.println((100.0 / treeArrayList.size()) * balans + " % balans");

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
