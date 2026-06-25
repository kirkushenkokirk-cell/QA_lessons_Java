public class Bowl {
    private int foodAmount;   // количество еды в миске

    // Конструктор
    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    // Добавить еду в миску
    public void addFood(int amount) {
        this.foodAmount += amount;
        System.out.println("В миску добавлено " + amount + " кусочков. Теперь в миске " + foodAmount + " кусочков.");
    }

    // Уменьшить еду (используется котом при еде)
    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        }
    }

    // Получить текущее количество еды
    public int getFood() {
        return foodAmount;
    }
}
