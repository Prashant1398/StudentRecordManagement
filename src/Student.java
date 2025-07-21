public class Student {
    private String id;
    private String name;
    private String course;
    private double grade;

    public Student(String id, String name, String course, double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return id + "," + name + "," + course + "," + grade;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}
