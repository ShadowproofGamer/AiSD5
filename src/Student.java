import java.util.Objects;

public class Student {
    int age;
    String name;
    String surname;
    String university;

    public Student(int age, String name, String surname, String university){

        this.age = age;
        this.name = name;
        this.surname = surname;
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", university='" + university + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname, university);
    }
}
