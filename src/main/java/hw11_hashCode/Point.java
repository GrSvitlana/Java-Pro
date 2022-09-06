package hw11_hashCode;
/* Instead of the equalsPoint method presented, override the equals and hashCode methods in the class.*/

class Point {
    public double x; // абсцисса точки
    public double y; // ордината точки

    // возвращает строку с описанием точки
    public String toString() {
        return "(" + x + ";" + y + ")";
    }

    // выводит на экран описание точки
    public void printPoint() {
        System.out.print(this.toString());
    }

    // метод перемещает точку на указанный вектор
    public void movePoint(double a, double b) {
        x += a;
        y += b;
    }

    // метод изменяет координаты точки на указанные
    public void setPoint(double a, double b) {
        x = a;
        y = b;
    }

    // конструктор по умолчанию, создающий точку в начале координат
    public Point() {
        x = 0.0;
        y = 0.0;
    }

    // конструктор, создающий точку с указанными координатами
    public Point(double a, double b) {
        x = a;
        y = b;
    }

    // метод вычисляющий расстояние между точками
    public double length(Point p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (31 * result + x * Math.pow(10, 8));
        result = (int) (31 * result + y * Math.pow(10, 8));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        if (x != point.x) {
            return false;
        }
        if (y != point.y) {
            return false;
        }
        return (this.x == point.x && this.y == point.x);
    }

    // метод проверяющий совпадают ли точки
//    public boolean equalsPoint(Point p) {
//        if (this.x == p.x && this.y == p.y) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
