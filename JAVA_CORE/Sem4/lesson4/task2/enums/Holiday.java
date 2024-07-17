package lesson4.task2.enums;

public enum Holiday {
    NEW_YEAR("New Year's Day"),
    INTERNATIONAL_WOMEN_DAY("International Women's Day"),
    DEFENDERS_OF_THE_FATHERLAND_DAY("Defenders of the Fatherland Day"),
    NONE("No Holiday");

    private String description;

    Holiday(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Holiday getHolidayForDate(int day, int month) {
        if (day == 1 && month == 1) {
            return NEW_YEAR;
        } else if (day == 23 && month == 2) {
            return DEFENDERS_OF_THE_FATHERLAND_DAY;
        } else if (day == 8 && month == 3) {
            return INTERNATIONAL_WOMEN_DAY;
        } else {
            return NONE;
        }
    }
}