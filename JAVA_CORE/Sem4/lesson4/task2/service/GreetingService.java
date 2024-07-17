package lesson4.task2.service;

import lesson4.task2.enums.Gender;
import lesson4.task2.enums.Holiday;
import lesson4.task2.model.Customer;
import lesson4.task2.model.Employee;

public class GreetingService {
    public void congratulate(Holiday holiday, Customer[] customers, Employee[] employees) {
        String message = "";
        switch (holiday) {
            case NEW_YEAR:
                message = "Happy New Year!";
                break;
            case INTERNATIONAL_WOMEN_DAY:
                message = "Happy International Women's Day!";
                break;
            case DEFENDERS_OF_THE_FATHERLAND_DAY:
                message = "Happy Defenders of the Fatherland Day!";
                break;
        }

        for (Customer customer : customers) {
            if ((holiday == Holiday.INTERNATIONAL_WOMEN_DAY && customer.getGender() == Gender.FEMALE) ||
                    (holiday == Holiday.DEFENDERS_OF_THE_FATHERLAND_DAY && customer.getGender() == Gender.MALE) ||
                    holiday == Holiday.NEW_YEAR) {
                System.out.println("Dear " + customer.getName() + ", " + message);
            }
        }

        for (Employee employee : employees) {
            if ((holiday == Holiday.INTERNATIONAL_WOMEN_DAY && employee.getGender() == Gender.FEMALE) ||
                    (holiday == Holiday.DEFENDERS_OF_THE_FATHERLAND_DAY && employee.getGender() == Gender.MALE) ||
                    holiday == Holiday.NEW_YEAR) {
                System.out.println("Dear " + employee.getName() + ", " + message);
            }
        }
    }
}
