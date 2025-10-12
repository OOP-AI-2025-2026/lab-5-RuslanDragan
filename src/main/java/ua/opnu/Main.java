package ua.opnu;

import ua.opnu.Lecturer;
import ua.opnu.Person;
import ua.opnu.Student;

    public class Main { // Назву класу краще писати з великої літери

        public static void main(String[] args) {

            // Створюємо об'єкти з більш реалістичними даними
            Person admin = new Person("Петренко", "Віктор", 42);

            Person student1 = new Student("Іваненко", "Ольга", 19,
                    "АІ-243", "KB82345671");

            Person student2 = new Student("Бондаренко", "Максим", 20,
                    "АІ-242", "KB81987654");

            Person lecturer1 = new Lecturer("Ковальчук", "Андрій", 48,
                    "Програмної інженерії", 28500.50);

            Person lecturer2 = new Lecturer("Шевченко", "Марина", 39,
                    "Прикладної математики", 24750.00);

            // Створюємо масив типу Person для демонстрації поліморфізму
            Person[] universityPeople = { admin, student1, student2, lecturer1, lecturer2 };

            System.out.println("--- Список осіб в університеті ---");

            // Виводимо інформацію про кожну особу
            for (Person person : universityPeople) {
                System.out.println(person.toString());
            }
        }
    }