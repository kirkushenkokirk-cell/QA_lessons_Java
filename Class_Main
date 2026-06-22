import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        Cat murzik = new Cat("Мурзик");

        bobik.run(150);     // Бобик пробежал 150 метров.
        bobik.run(600);     // не может пробежать 600 метров (максимум 500).
        bobik.swim(5);      //  проплыл 5 метров.
        bobik.swim(15);     // не может проплыть 15 метров (максимум 10).

        murzik.run(150);    // Мурзик пробежал 150 метров.
        murzik.run(250);    //  не может пробежать 250 метров (максимум 200).
        murzik.swim(5);     // не умеет плавать.

        System.out.println("-------------------------------------");


        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Барсик"));
        cats.add(new Cat("Васька"));
        cats.add(new Cat("Пушок"));

        Bowl bowl = new Bowl(10);   // в миске 10 кусочков

        System.out.println("=== Коты пытаются поесть ===");
        for (Cat cat : cats) {
            cat.eat(bowl, 4);   // каждый кот пытается съесть по 4 кусочка
        }

        System.out.println("\n=== Информация о сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт? " + (cat.isFull() ? "Да" : "Нет"));
        }

        // Добавляем еду в миску
        System.out.println("\n=== Добавляем еду в миску ===");
        bowl.addFood(5);   // теперь в миске 3 + 5 = 8 кусочков

        // Пробуем снова покормить голодных котов
        System.out.println("\n=== Коты снова пытаются поесть ===");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 4);
            } else {
                System.out.println(cat.getName() + " уже сыт.");
            }
        }

        // ---------- 3. Подсчет созданных животных ----------
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());
    }
}
