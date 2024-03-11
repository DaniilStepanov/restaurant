package org.itmo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public Map<String, Dish> dishes = new HashMap<>();
    private List<Dish> listDishes;

    public Menu() {
        // Создание объектов блюд
        Dish pastaCarbonara = new Dish("Паста Карбонара", 250, 20); // 12.5
        Dish steakWithVegetables = new Dish("Стейк с тушенными овощами", 400, 30); // 13.33
        Dish caesarSalad = new Dish("Салат Цезарь", 200, 15); // 13.33
        Dish chickenSoupWithRice = new Dish("Суп куриный с рисом", 180, 25); // 7.2
        Dish margheritaPizza = new Dish("Пицца Маргарита", 300, 25); // 12
        Dish tiramisuDessert = new Dish("Десерт Тирамису", 180, 15); // 12
        // Дополнительные блюда
        Dish sushiSet = new Dish("Набор суши", 500, 35); // 14.28
        Dish seafoodPasta = new Dish("Паста с морепродуктами", 350, 25); // 14
        Dish grilledSalmon = new Dish("Гриль-лосось", 450, 30);
        Dish vegetableSoup = new Dish("Овощной суп", 150, 20);
        Dish beefBurger = new Dish("Говяжий бургер", 280, 20);
        Dish fruitSalad = new Dish("Фруктовый салат", 220, 10);
        Dish chickenWrap = new Dish("Куриный ролл", 270, 15);
        Dish chocolateCake = new Dish("Шоколадный торт", 320, 30);
        Dish greenTeaIceCream = new Dish("Мороженое зеленого чая", 180, 10);
        Dish mixedGrill = new Dish("Смешанное мясо на гриле", 480, 40);

        // Создание списка блюд с помощью Arrays.asList
        listDishes = Arrays.asList(
                pastaCarbonara, steakWithVegetables, caesarSalad, chickenSoupWithRice,
                margheritaPizza, tiramisuDessert, sushiSet, seafoodPasta, grilledSalmon,
                vegetableSoup, beefBurger, fruitSalad, chickenWrap, chocolateCake,
                greenTeaIceCream, mixedGrill
        );
        listDishes.forEach(dish -> dishes.put(dish.getName(), dish));
    }

    public Dish getDishByIndex(int dishIndex) {
        return listDishes.get(dishIndex);
    }
}
