package employee;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String midName;
    private String lastName;
    private String position;
    private String phone;
    private int salary;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Employee(String name, String midName, String lastName, String phone, String position, int salary,
            int birthYear, int birthMonth, int birthDay) {
        this.name = name;
        this.midName = midName;
        this.lastName = lastName;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return java.time.Year.now().getValue() - birthYear;
    }

    public void info() {
        System.out.println("Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + getAge() +
                '}');
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", age=" + getAge() +
                '}';
    }

    public void increaseSalary(int amount) {
        this.salary += amount;
    }

    public int compare(int day, int month, int year) {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate givenDate = LocalDate.of(year, month, day);
        return birthDate.compareTo(givenDate);
    }

}