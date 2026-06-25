public class Cat extends Animal {
    private static int catCount = 0;   // счетчик котов
    private boolean isFull;            // сытость (голоден по умолчанию)

    // Конструктор
    public Cat(String name) {
        super(name, 200, 0);   // вызов конструктора родителя
        this.isFull = false;   // при создании кот голоден
        catCount++;
    }

    // Метод для еды из миски
    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " съел " + amount + " кусочков и теперь сыт.");
        } else {
            System.out.println(name + " не стал есть: в миске недостаточно еды (нужно " + amount + ", доступно " + bowl.getFood() + ").");
        }
    }

    // Геттер для сытости
    public boolean isFull() {
        return isFull;
    }

    // Статический метод для получения количества котов
    public static int getCatCount() {
        return catCount;
    }
}
