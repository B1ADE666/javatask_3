import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line(0, -2, 1);
    public static final Line L2 = new Line(3, 0, -4);
    public static final Rectangle R1 = new Rectangle(-6, 2, -4, -4);
    public static final Rectangle R2 = new Rectangle(0, 3, 10, -1);
    public static SimpleColor getColor(double x, double y) {
        if (L2.isPointAboveLine(x, y) &&
            !R2.isPointInRectangle(x, y) &&
            L1.isPointAboveLine(x, y))
            return SimpleColor.GREEN;
        if (L1.isPointAboveLine(x, y) &&
            L2.isPointAboveLine(x, y) &&
                R2.isPointInRectangle(x, y))
            return SimpleColor.WHITE;
        if (!L1.isPointAboveLine(x, y) &&
                L2.isPointAboveLine(x, y))
            return SimpleColor.BLUE;
        if (L1.isPointAboveLine(x, y) &&
            !L2.isPointAboveLine(x, y) &&
            !R2.isPointInRectangle(x, y))
            return SimpleColor.GRAY;
        if (!L1.isPointAboveLine(x, y) &&
            !L2.isPointAboveLine(x, y))
            return SimpleColor.YELLOW;
        if (!L2.isPointAboveLine(x, y) &&
                R2.isPointInRectangle(x, y))
            return SimpleColor.YELLOW;
        return SimpleColor.WHITE;
    }
    public static void main(String[] args) {
        printColorForPoint(5.0, 5.0);
        printColorForPoint(2.0, 10.0);
        printColorForPoint(7.0, 1.0);
        printColorForPoint(7.0, -5.5);
        printColorForPoint(9.0, 6.0);
        printColorForPoint(2.0, 4.0);
        printColorForPoint(5.0, -9.0);
        printColorForPoint(-7.0, -10.0);
        printColorForPoint(2.5, -0.5);
        printColorForPoint(1.0, 1.0);
        printColorForPoint(0.5, -1.3);
        printColorForPoint(-9.0, -8.0);
        printColorForPoint(1.0, 4.0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\ninput x (-10<x<10):");
        double x = scanner.nextDouble();
        System.out.println("\ninput y (-10<y<10):");
        double y = scanner.nextDouble();

        printColorForPoint(x, y);

    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%f, %f) -> %s\n", x, y, getColor(x, y));
    }
}