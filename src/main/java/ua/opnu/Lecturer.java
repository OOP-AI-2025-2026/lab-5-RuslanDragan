package ua.opnu;

public class Lecturer extends Person {
    private String department;
    private double salary;

    public Lecturer(String surname, String name, int age, String department, double salary) {
        // Виклик конструктора батьківського класу Person
        super(surname, name, age);
        this.department = department;
        this.salary = salary;
    }

    // Гетери
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сетери
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Викладач кафедри " + department + ", " + getSurname() + " " + getName() +
                ", вік: " + getAge() + ". Зарплата: " + String.format("%.2f", salary);
    }
}