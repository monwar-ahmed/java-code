import java.util.Scanner;
public class StudentTest {
  public static void main(String[] args) 
  {
    Scanner s1 = new Scanner(System.in);
    System.out.print("Enter student's name: ");
    String name = s1.nextLine();

    System.out.print("Enter student's average: ");
    double average = s1.nextDouble();

    Student student = new Student(name, average);

    System.out.println("\nStudent Details:");
    System.out.println("Name: " + student.getName());
    System.out.println("Average: " + student.getAverage());
    System.out.println("Letter Grade: " + student.getLetterGrade());

    s1.close();
  }
}
