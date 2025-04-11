import java.util.Scanner;

public class GradeConverter {

    private double x1, y1, x2, y2;

    public void setCoordinates(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() { return x1; }
    public double getY1() { return y1; }
    public double getX2() { return x2; }
    public double getY2() { return y2; }

    public double findYCoordinate(double newX) {
        double slope = (y2 - y1) / (x2 - x1);
        return -slope * (x2 - newX) + y2;
    }

    public double findXCoordinate(double yValue) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return (yValue - yIntercept) / slope;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Grade Converter.");
        System.out.println("This program converts the 5-point scale system into its percentage equivalent, and vice versa.");
        System.out.println();
        GradeConverter converter = null;
        char gradingSystemChoice;

        do {
            System.out.println("Select a grading system:");
            System.out.println("Type a for University of the Philippines (1 = 97, 1.25 = 94.25, 1.5 = 91.5)");
            System.out.println("Type b for University of Santo Tomas (1 = 96, 1.25 = 94, 1.5 = 92)");
            System.out.println("Type c for Ateneo University (4 = 92, 3.5 = 88, 3 = 84)");
            System.out.println("Type d for De La Salle University (4 = 95, 3.5 = 89, 3 = 83)");
            System.out.println("Type e for Mapúa University (1 = 98, 1.25 = 95, 1.5 = 92)");
            System.out.println("Type f to enter your own grading system.");
            System.out.println();

            gradingSystemChoice = scanner.next().toLowerCase().charAt(0);
            switch (gradingSystemChoice) {
                case 'a':
                    converter = new GradeConverter();
                    converter.setCoordinates(1.25, 94.25, 1.5, 91.5);
                    System.out.println();
                    break;
                case 'b':
                    converter = new GradeConverter();
                    converter.setCoordinates(1.25, 94, 1.5, 92);
                    System.out.println();
                    break;
                case 'c':
                    converter = new GradeConverter();
                    converter.setCoordinates(3.5, 88, 3, 84);
                    System.out.println();
                    break;
                case 'd':
                    converter = new GradeConverter();
                    converter.setCoordinates(3.5, 89, 3, 83);
                    System.out.println();
                    break;
                case 'e':
                    converter = new GradeConverter();
                    converter.setCoordinates(1.25, 95, 1.5, 92);
                    System.out.println();
                    break;
                case 'f':
                    System.out.println();
                    System.out.println("Example:");
                    System.out.println("x1 = 1.25, y1 = 94.25");
                    System.out.println("x2 = 1.5, y2 = 91.5");
                    System.out.println();
                    System.out.println("Enter grading system:");
                    System.out.println();
                    System.out.print("x1 = ");
                    double customX1 = scanner.nextDouble();
                    System.out.print("y1 = ");
                    double customY1 = scanner.nextDouble();
                    System.out.print("x2 = ");
                    double customX2 = scanner.nextDouble();
                    System.out.print("y2 = ");
                    double customY2 = scanner.nextDouble();
                    converter = new GradeConverter();
                    converter.setCoordinates(customX1, customY1, customX2, customY2);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            while (true) {
                System.out.print("Type 1 to find Percentage Grade, or 2 to find Grade Point: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println();
                    System.out.print("Enter grade: ");
                    double newX = scanner.nextDouble();
                    double resultY = converter.findYCoordinate(newX);
                    System.out.println("5 Point Scale = " + newX + ", Percentage = " + resultY);
                    System.out.println();
                } else if (choice == 2) {
                    System.out.println();
                    System.out.print("Enter grade: ");
                    double yValue = scanner.nextDouble();
                    double resultX = converter.findXCoordinate(yValue);
                    System.out.println("Percentage = " + yValue + ", 5 Point Scale = " + resultX);
                    System.out.println();
                } else {
                    System.out.println("Invalid choice. Please type 1 or 2.");
                    continue;
                }

                int repeatChoice;
                do {
                    System.out.print("Type 1 to try again, or 2 to change the grading system: ");
                    repeatChoice = scanner.nextInt();
                    System.out.println();
                    if (repeatChoice != 1 && repeatChoice != 2) {
                        System.out.println("Invalid choice. Please try again.");
                    }
                } while (repeatChoice != 1 && repeatChoice != 2);
                if (repeatChoice == 2) {
                    break;
                }
            }
        } while (gradingSystemChoice != '2');
        scanner.close();
    }

    public static void main(String[] args) {
        new GradeConverter().input();
    }
}
