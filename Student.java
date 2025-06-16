public class Student {
    private String name;
    private double average;

    // Constructor
    public Student(String name, double average) {
        this.name = name;
        this.average = average;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for average
    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    // Method to get letter grade
    public String getLetterGrade() {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

