//Интерфейс для геометрических фигур
interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();
}

// aбстрактный класс для общих полей (цвета)
abstract class AbstractShape implements Shape {
    protected String fillColor;
    protected String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

//  Круг 
class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// gрямоугольник 
class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// ======== Треугольник (произвольный по трём сторонам) ========
class Triangle extends AbstractShape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        // Формула Герона
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}


public class MainTask2 {
    public static void main(String[] args) {
        // Создаём фигуры
        Shape circle = new Circle(5.0, "Красный", "Черный");
        Shape rectangle = new Rectangle(4.0, 6.0, "Синий", "Зеленый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Желтый", "Оранжевый");

  
        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Периметр: " + shape.getPerimeter());
        System.out.println("Площадь: " + shape.getArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println("----------------------------");
    }
}
