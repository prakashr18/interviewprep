package com.fico;

public class Main {
    public static void main(String[] args) {
        for(Day day: Day.values()) {
            System.out.println(day);
        }
        Person person = new Person("Prakash", "Kumawat");
        Person person2 = new Person();
        Person.Manager manager = new Person.Manager();
        manager.isGoodManager();

        Person.Employee employee = person.new Employee(55489, "FICO");
        System.out.println(employee.toString());

        /*Main mymain = new Main();

        Circle myCircle = new Circle(22,55);
        System.out.println(myCircle);
        mymain.moveCircle(myCircle, 23, 56);
        System.out.println(myCircle);*/
    }

    public void moveCircle(Circle circle, int deltaX, int deltaY) {
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        circle = new Circle(0, 0);
    }
}
class Circle {
    private int x, y, radius;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOrigin(int x, int y) {
        System.out.println("setting the origin");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}