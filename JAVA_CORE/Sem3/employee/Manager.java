package employee;

public class Manager extends Employee {
    public Manager(String name, String midName, String lastName, String phone, String position, int salary,
            int birthYear, int birthMonth, int birthDay) {
        super(name, midName, lastName, phone, position, salary, birthYear, birthMonth, birthDay);
    }

    public static void increaser(Employee[] emp, int age, int increment) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                if (!(emp[i] instanceof Manager))
                    emp[i].increaseSalary(increment);
            }
        }
    }
}
