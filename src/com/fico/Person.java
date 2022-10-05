package com.fico;

public class Person {

    private static String country = "India";
    private String firstName;
    private String lastName;

    static class Manager {
        boolean isGood;

        boolean isGoodManager() {
            System.out.println("He is from " + country);
            return isGood;
        }
    }

    class Employee {

        private int id;
        private String company;

        public Employee(int id, String company) {
            this.id = id;
            this.company = company;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", company='" + company + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
    public Person() {
        System.out.println("inside the constructor");
    }

    public Person(String firstName, String lastName) {
        System.out.println("inside the one-arg constructor");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    {
        System.out.println("from initializer block");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}