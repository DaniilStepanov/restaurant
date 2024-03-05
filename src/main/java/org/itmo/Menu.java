package org.itmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    public List<Dish> dishes = new ArrayList<>();

    public Menu() {
        // Создание объектов блюд
        Dish pastaCarbonara = new Dish("Паста Карбонара", 250, 20);
        Dish steakWithVegetables = new Dish("Стейк с тушенными овощами", 400, 30);
        Dish caesarSalad = new Dish("Салат Цезарь", 200, 15);
        Dish chickenSoupWithRice = new Dish("Суп куриный с рисом", 180, 25);
        Dish margheritaPizza = new Dish("Пицца Маргарита", 300, 25);
        Dish tiramisuDessert = new Dish("Десерт Тирамису", 180, 15);
        // Дополнительные блюда
        Dish sushiSet = new Dish("Набор суши", 500, 35);
        Dish seafoodPasta = new Dish("Паста с морепродуктами", 350, 25);
        Dish grilledSalmon = new Dish("Гриль-лосось", 450, 30);
        Dish vegetableSoup = new Dish("Овощной суп", 150, 20);
        Dish beefBurger = new Dish("Говяжий бургер", 280, 20);
        Dish fruitSalad = new Dish("Фруктовый салат", 220, 10);
        Dish chickenWrap = new Dish("Куриный ролл", 270, 15);
        Dish chocolateCake = new Dish("Шоколадный торт", 320, 30);
        Dish greenTeaIceCream = new Dish("Мороженое зеленого чая", 180, 10);
        Dish mixedGrill = new Dish("Смешанное мясо на гриле", 480, 40);

        // Создание списка блюд с помощью Arrays.asList
        dishes.addAll(Arrays.asList(
                pastaCarbonara, steakWithVegetables, caesarSalad, chickenSoupWithRice,
                margheritaPizza, tiramisuDessert, sushiSet, seafoodPasta, grilledSalmon,
                vegetableSoup, beefBurger, fruitSalad, chickenWrap, chocolateCake,
                greenTeaIceCream, mixedGrill
        ));
    }

}
