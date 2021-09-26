package com.knifedude.menuessentials.api.menu.shapes;

public final class Rectangle {

    private Point min, max;

    public Rectangle(int firstX, int firstY, int secondX, int secondY) {
        this.min = Point.of(Math.min(firstX, secondX), Math.min(firstY, secondY));
        this.max = Point.of(Math.max(firstX, secondX), Math.max(firstY, secondY));
    }

    public Rectangle(Point first, Point second) {
        this(first.x(), first.y(), second.x(), second.y());
    }

    public Point min() {
        return min;
    }

    public Point max() {
        return max;
    }

    public int width() {
        return (max.x() - min.x()) + 1;
    }

    public int height() {
        return (max.y() - min.y()) + 1;
    }

    public static Rectangle of(Point first, Point second) {
        return new Rectangle(first, second);
    }




}
