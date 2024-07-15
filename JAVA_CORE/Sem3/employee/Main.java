package employee;

public class Main {
        public static void main(String[] args) {
                Employee[] employees = {
                                new Employee("Ivan", "Igorevich",
                                                "Ovchinnikov", "8(495)000-11-22",
                                                "developer", 50000, 1985, 12, 3),
                                new Manager("Victoria", "Viktorovna",
                                                "Antonova", "8(495)111-56-09",
                                                "manager", 80000, 1909, 12, 12),
                                new Employee("Andrey", "Viktorovich",
                                                "Bezrukov", "8(495)111-22-33",
                                                "fitter", 52000, 1973, 5, 3),
                                new Employee("Evgeniy", "Viktorovich",
                                                "Delfinov", "8(495)222-33-44",
                                                "project manager", 40000, 1963, 1, 22),
                                new Employee("Natalia", "Pavlovna",
                                                "Keks", "8(495)333-44-55",
                                                "senior developer", 90000, 1990, 7, 20),
                                new Employee("Tatiana", "Sergeevna",
                                                "Krasotkina", "8(495)444-55-66",
                                                "accountant", 50000, 1983, 6, 22)
                };
                for (Employee employee : employees) {
                        System.out.printf("Name: %s, Position: %s, Age: %d, Salary: %d%n",
                        employee.getName(), employee.getPosition(), employee.getAge(), employee.getSalary());
                }

                // Увеличиваем зарплату сотрудников старше 45 лет на 5000, исключая менеджера
                Manager.increaser(employees, 45, 5000);
                System.out.println("\nУвеличенная зарплата сотрудников:");
                for (Employee employee : employees) {
                        System.out.printf("Name: %s, Position: %s, Age: %d, Salary: %d%n",
                        employee.getName(), employee.getPosition(), employee.getAge(), employee.getSalary());
                }

                // Тестируем компаратор - создаем тестовые данные и прогоняем массив сотрудников
                // по ним
                System.out.println("\nТестируем компаратор:");

                int testDay = 15;
                int testMonth = 5;
                int testYear = 1985;

                for (Employee employee : employees) {
                        int result = employee.compare(testDay, testMonth, testYear);
                        String comparison = result < 0 ? "earlier than" : result > 0 ? "later than" : "the same as";
                        System.out.printf("%s's birthdate is %s %02d-%02d-%04d\n",
                                        employee.getName(), comparison, testDay, testMonth, testYear);
                }

        }
}