package com.streams;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    List<String> placesVisited;

    Person(String nameArg, LocalDate birthdayArg,
           Sex genderArg, String emailArg, List<String> placesVisitedArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
        placesVisited = placesVisitedArg;
    }

    public int getAge() {
        return birthday
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public void printPerson() {
        System.out.println(name + ", " + this.getAge());
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public List<String> getPlacesVisited() {
        return placesVisited;
    }

    public void setPlacesVisited(List<String> placesVisited) {
        this.placesVisited = placesVisited;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", placesVisited=" + placesVisited +
                '}';
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Prakash",
                        IsoChronology.INSTANCE.date(1994, 11, 02),
                        Person.Sex.MALE,
                        "prakash@example.com",
                        Arrays.asList("Bangalore", "chennai", "jaipur")));
        roster.add(
                new Person(
                        "Sandhya",
                        IsoChronology.INSTANCE.date(1992, 6, 20),
                        Sex.FEMALE,
                        "sandhya@example.com",
                        Arrays.asList("Delhi", "Mumbai", "Shimla")));
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com",
                        Arrays.asList("New York", "California", "Mexico")));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com",
                        Arrays.asList("London","IreLand")));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com",
                        Arrays.asList("Bangalore", "Delhi", "Denmark")));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2012, 9, 12),
                        Person.Sex.MALE, "bob@example.com",
                        Arrays.asList("Australia", "sydney", "melbourne")));
        roster.add(
                new Person(
                        "Mahi",
                        IsoChronology.INSTANCE.date(1997, 4, 13),
                        Person.Sex.MALE, "bob@example.com",
                        Arrays.asList("Bangalore", "New York", "Delhi")));
        roster.add(
                new Person(
                        "Poornima",
                        IsoChronology.INSTANCE.date(1998, 10, 12),
                        Sex.FEMALE, "poorni@example.com",
                        Arrays.asList("Mangalore", "Udupi", "Bidar")));

        return roster;
    }

}
