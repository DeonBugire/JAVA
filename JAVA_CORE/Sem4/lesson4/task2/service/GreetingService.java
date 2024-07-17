package lesson4.task2.service;

import lesson4.task2.enums.Gender;
import lesson4.task2.enums.Holiday;
import lesson4.task2.model.Customer;
import lesson4.task2.model.Employee;
import java.time.LocalDate;

public class GreetingService {

    public void congratulate(Customer[] customers, Employee[] employees) {
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        Holiday currentHoliday = Holiday.getHolidayForDate(day, month);

        if (currentHoliday == Holiday.NONE) {
            System.out.println("Today is not a holiday.");
            return;
        }

        String message = currentHoliday.getDescription();

        for (Customer customer : customers) {
            if ((currentHoliday == Holiday.INTERNATIONAL_WOMEN_DAY && customer.getGender() == Gender.FEMALE) ||
                (currentHoliday == Holiday.DEFENDERS_OF_THE_FATHERLAND_DAY && customer.getGender() == Gender.MALE) ||
                currentHoliday == Holiday.NEW_YEAR) {
                System.out.println("Dear " + customer.getName() + ", " + message);
            }
        }

        for (Employee employee : employees) {
            if ((currentHoliday == Holiday.INTERNATIONAL_WOMEN_DAY && employee.getGender() == Gender.FEMALE) ||
                (currentHoliday == Holiday.DEFENDERS_OF_THE_FATHERLAND_DAY && employee.getGender() == Gender.MALE) ||
                currentHoliday == Holiday.NEW_YEAR) {
                System.out.println("Dear " + employee.getName() + ", " + message);
            }
        }
    }
}