package Team2.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class List {
    static long ms(Runnable r) {
        long s = System.nanoTime();
        r.run();
        return (System.nanoTime() - s)/1_000_000;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        LinkedList<Integer> b = new LinkedList<>();

        long t1 = ms(() -> {
            for(int i = 0; i <= 1000000; i++) {
                a.add(i);
            }
        });

        long t2 = ms(() -> {
            for(int i = 0; i <= 1000000; i++) {
                b.add(i);
            }
        });
        System.out.println("ArrayList: " + t1 + " "+ "LinkdList: " + t2);


        long t3 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                a.add(0, i);
            }
        });

        long t4 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                b.addFirst(i);
            }
        });
        System.out.println("ArrayList: " + t3 + " "+ "LinkdList: " + t4);

        ArrayList<Integer> c = new ArrayList<>();
        LinkedList<Integer> d = new LinkedList<>();
        for(int i = 0; i <= 1000000; i++) {
            c.add(i);
            d.add(i);
        }

        Random rand = new Random();

        long t5 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                c.get(rand.nextInt(c.size()));
            }
        });

        rand.setSeed(0);

        long t6 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                d.get(rand.nextInt(d.size()));
            }
        });

        System.out.println("ArrayList: " + t5 + " "+ "LinkdList: " + t6);

        long t7 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                a.removeFirst();
            }
        });

        long t8 = ms(() -> {
            for(int i = 0; i <= 10000; i++) {
                b.removeFirst();
            }
        });
        System.out.println("ArrayList: " + t7 + " "+ "LinkdList: " + t8);


    }
}
