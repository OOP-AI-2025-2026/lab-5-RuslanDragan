package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    // --- КОНСТРУКТОРИ ---

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int totalMinutes) {
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public TimeSpan(TimeSpan other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
    }

    // --- МЕТОДИ ДОДАВАННЯ ---

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return; // Не додаємо від'ємний час
        }
        int totalNewMinutes = minutes % 60;
        int totalNewHours = hours + (minutes / 60);

        this.minutes += totalNewMinutes;
        this.hours += totalNewHours + (this.minutes / 60);
        this.minutes %= 60;
    }

    public void add(int minutes) {
        if (minutes < 0) {
            return; // Не додаємо від'ємний час
        }
        // Використовуємо вже існуючий метод add(hours, minutes)
        add(0, minutes);
    }

    public void add(TimeSpan timespan) {
        add(timespan.hours, timespan.minutes);
    }

    // --- МЕТОДИ ВІДНІМАННЯ ---

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return; // Не віднімаємо від'ємний час
        }
        int totalThisMinutes = this.getTotalMinutes();
        int totalOtherMinutes = hours * 60 + minutes;

        if (totalOtherMinutes > totalThisMinutes) {
            // Якщо віднімаємо більше часу, ніж є, можна встановити 0
            this.hours = 0;
            this.minutes = 0;
            return;
        }

        int resultMinutes = totalThisMinutes - totalOtherMinutes;
        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void subtract(int minutes) {
        if (minutes < 0) {
            return; // Не віднімаємо від'ємний час
        }

        subtract(0, minutes);
    }

    public void subtract(TimeSpan timespan) {
        subtract(timespan.hours, timespan.minutes);
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    @Override
    public String toString() {
        return hours + " hours, " + minutes + " minutes";
    }
}