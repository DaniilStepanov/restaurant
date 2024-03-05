import org.itmo.GroupOfVisitors;
import org.itmo.Menu;
import org.itmo.Restaurant;
import org.itmo.Visitor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day1 {

    @Test
    void day1() {
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
    }
}
