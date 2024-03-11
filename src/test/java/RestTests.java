import org.itmo.GroupOfVisitors;
import org.itmo.Menu;
import org.itmo.Restaurant;
import org.itmo.Visitor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RestTests {

    @Test
    void day1() throws IOException {
        Menu m = new Menu();
        Restaurant r = new Restaurant(2, 0, 0);
        Visitor v1 = new Visitor("Паста Карбонара", 1);
        Visitor v2 = new Visitor("Салат Цезарь", 1);
        Visitor v3 = new Visitor("Суп куриный с рисом", 1);
        Visitor v4 = new Visitor("Набор суши", 1);
        Visitor v5 = new Visitor("Набор суши", 1);
        Visitor v6 = new Visitor("Набор суши", 1);
        GroupOfVisitors g1 = new GroupOfVisitors(Arrays.asList(v1, v2), 100, 100);
        GroupOfVisitors g2 = new GroupOfVisitors(Arrays.asList(v3, v4), 100, 100);
        GroupOfVisitors g3 = new GroupOfVisitors(Arrays.asList(v5, v6), 100, 200);
        r.serveVisitors(g1);
        r.serveVisitors(g2);
        r.serveVisitors(g3);
        r.close();
        System.out.println("TOTAL: " + r.income.get());
    }

    @Test
    void day2() throws InterruptedException, IOException {
        Random r = new Random(42);
        Menu m = new Menu();
        Restaurant rest = new Restaurant(2, 2, 2);
        List<Visitor> visitors = new ArrayList<Visitor>();
        for (int i = 0; i < 100; i++) {
            int dishIndex = r.nextInt(m.dishes.size());
            visitors.add(new Visitor(m.getDishByIndex(dishIndex).getName(), 1));
        }
        List<GroupOfVisitors> groups = new ArrayList<>();
        int curInd = 0;
        for (int i = 0; i < 10; i++) {
            int groupSize = r.nextInt(8) + 1;
            groups.add(new GroupOfVisitors(visitors.subList(curInd, groupSize), 100, r.nextInt(200) + 100));
        }
        for (GroupOfVisitors g : groups) {
            rest.serveVisitors(g);
        }
        rest.close();
        System.out.println("TOTAL: " + rest.income.get());
    }

    @Test
    void day3() throws InterruptedException, IOException {
        Random r = new Random(42);
        Menu m = new Menu();
        Restaurant rest = new Restaurant(2, 2, 2);
        List<Visitor> visitors = new ArrayList<Visitor>();
        for (int i = 0; i < 1000; i++) {
            int dishIndex = r.nextInt(m.dishes.size());
            visitors.add(new Visitor(m.getDishByIndex(dishIndex).getName(), 1));
        }
        List<GroupOfVisitors> groups = new ArrayList<>();
        int curInd = 0;
        for (int i = 0; i < 100; i++) {
            int groupSize = r.nextInt(8) + 1;
            groups.add(new GroupOfVisitors(visitors.subList(curInd, groupSize), 100, r.nextInt(200) + 100));
        }
        for (GroupOfVisitors g : groups) {
            rest.serveVisitors(g);
            Thread.sleep(r.nextInt(100) + 1);
        }
        rest.close();
        System.out.println("TOTAL: " + rest.income.get());
    }

    @Test
    void day4() throws InterruptedException, IOException {
        Random r = new Random(42);
        Menu m = new Menu();
        Restaurant rest = new Restaurant(5, 2, 2);
        List<Visitor> visitors = new ArrayList<Visitor>();
        for (int i = 0; i < 10_000; i++) {
            int dishIndex = r.nextInt(m.dishes.size());
            visitors.add(new Visitor(m.getDishByIndex(dishIndex).getName(), 1));
        }
        List<GroupOfVisitors> groups = new ArrayList<>();
        int curInd = 0;
        for (int i = 0; i < 1_000; i++) {
            int groupSize = r.nextInt(8) + 1;
            groups.add(new GroupOfVisitors(visitors.subList(curInd, groupSize), 100, r.nextInt(200) + 100));
        }
        int c = 0;
        for (GroupOfVisitors g : groups) {
            c++;
            rest.serveVisitors(g);
            if (c % 10 == 0) {
                Thread.sleep(r.nextInt(100) + 1);
            }
        }
        rest.close();
        System.out.println("TOTAL: " + rest.income.get());
    }


    @Test
    void day5() throws InterruptedException, IOException {
        Random r = new Random(42);
        Menu m = new Menu();
        Restaurant rest = new Restaurant(5, 4, 2);
        List<Visitor> visitors = new ArrayList<>();
        for (int i = 0; i < 50_000; i++) {
            int dishIndex = r.nextInt(m.dishes.size());
            visitors.add(new Visitor(m.getDishByIndex(dishIndex).getName(), 1));
        }
        List<GroupOfVisitors> groups = new ArrayList<>();
        int curInd = 0;
        for (int i = 0; i < 5_000; i++) {
            int groupSize = r.nextInt(8) + 1;
            groups.add(new GroupOfVisitors(visitors.subList(curInd, groupSize), 100, r.nextInt(200) + 100));
        }
        for (GroupOfVisitors g : groups) {
            rest.serveVisitors(g);
            Thread.sleep(r.nextInt(10) + 1);
        }
        rest.close();
        System.out.println("TOTAL: " + rest.income.get());
    }
}
