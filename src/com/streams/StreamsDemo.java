package com.streams;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Averager implements IntConsumer {

    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }

    public void accept(int i) {
        total += i; count++;
    }
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}
public class StreamsDemo {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        for (Person p : roster) {
            System.out.println(p.getName());
        }
        System.out.println("-------------------X-----------X");
        roster.stream().forEach(person -> System.out.println(person.getName()));

        System.out.println("-------------------X-----------X");
        roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .forEach(person -> System.out.println(person.getName()));

        System.out.println("-------------------X-----------X");
        double averageMensAge = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("averageMensAge: "+averageMensAge);
        System.out.println("-------------------X-----------X");


        int sumOfAllMensAge = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sumOfAllMensAge: "+sumOfAllMensAge);
        System.out.println("-------------------X-----------X");

        int sumOfAllMensAge1 = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .reduce(Integer::sum)
                        .getAsInt();

        System.out.println("sumOfAllMensAge1: "+sumOfAllMensAge1);
        System.out.println("-------------------X-----------X");


        Averager averageCollect = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .map(Person::getAge)
                .collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println("Average age of male members: " +
                averageCollect.average());
        System.out.println("-------------------X-----------X");

        List<String> namesOfMaleMembersCollect = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .map(person -> person.getName())
                .collect(Collectors.toList());

        System.out.println("namesOfMaleMembersCollect: " + namesOfMaleMembersCollect);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, List<Person>> byGender =roster.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println("byGenderMap: " + byGender);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, List<String>> namesByGender = roster.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList())));

        System.out.println("namesByGenderMap: " + namesByGender);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, Integer> totalAgeByGender = roster.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.reducing(
                                        0,
                                        Person::getAge,
                                        Integer::sum)));

        System.out.println("totalAgeByGenderMap: " + totalAgeByGender);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, Double> averageAgeByGender = roster.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.averagingInt(Person::getAge)));

        System.out.println("averageAgeByGenderMap: " + averageAgeByGender);
        System.out.println("-------------------X-----------X");

        ConcurrentMap<Person.Sex, List<Person>> byGenderConcurrent =
                roster
                        .parallelStream()
                        .collect(
                                Collectors.groupingByConcurrent(Person::getGender));

        System.out.println("byGenderConcurrentMap: " + byGenderConcurrent);
        System.out.println("-------------------X-----------X");

        try {
            List<String> listOfStrings =
                    new ArrayList<>(Arrays.asList("one", "two"));

            String concatenatedString = listOfStrings
                    .stream()
                    .peek(s -> listOfStrings.add("three"))

                    .reduce((a, b) -> a + " " + b)
                    .get();

            System.out.println("Concatenated string: " + concatenatedString);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }


        Stream<Person> averageAgeByGenderStream = roster.stream();

        System.out.println("is Parallel: "+ averageAgeByGenderStream.isParallel());
        System.out.println("All match:" + averageAgeByGenderStream.allMatch(person -> person.getAge()>18));

        System.out.println("-------------------X-----------X");

        Stream<Person> byGenderConcurrentStream = roster.parallelStream();

        System.out.println("is Parallel: "+ byGenderConcurrentStream.isParallel());
        System.out.println("None match:" + byGenderConcurrentStream.noneMatch(person -> person.getAge()<8));
        System.out.println("-------------------X-----------X");


        List<String> flatMapExample = roster.stream()
                .flatMap(person -> person.getPlacesVisited().stream())
                .collect(Collectors.toList());
        System.out.println("flatMapExample: " + flatMapExample);

        Set<String> flatMapExample2 = roster.stream()
                .flatMap(person -> person.getPlacesVisited().stream())
                .collect(Collectors.toSet());
        System.out.println("flatMapExample2: " + flatMapExample2);
        System.out.println("-------------------X-----------X");

        Object[] objects = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .toArray();

        for(Object object: objects) {
            System.out.println(object);
        }
        System.out.println("-------------------X-----------X");

        Person[] people = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.FEMALE)
                .toArray(Person[]::new);

        for(Person person: people) {
            System.out.println(person);
        }
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, Double> averageAgeByCategory = roster.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge)));

        System.out.println("averageAgeByCategory: "+averageAgeByCategory);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, Integer> totalAgeByCategory = roster.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.summingInt(Person::getAge)));

        System.out.println("totalAgeByCategory: "+totalAgeByCategory);
        System.out.println("-------------------X-----------X");

        String joiningSample = roster.stream()
                .map(Person::toString)
                .collect(Collectors.joining());

        System.out.println("joiningSample: "+joiningSample);
        System.out.println("-------------------X-----------X");

        String joiningSample2 = roster.stream()
                .map(Person::toString)
                .collect(Collectors.joining(", "));

        System.out.println("joiningSample2: "+joiningSample2);
        System.out.println("-------------------X-----------X");

        String joiningSample3 = roster.stream()
                .map(Person::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("joiningSample3: "+joiningSample3);
        System.out.println("-------------------X-----------X");

        Optional<Person> maxByExample = roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE).max(Comparator.comparing(Person::getBirthday).reversed());

        System.out.println("maxByExample: "+maxByExample.get());
        System.out.println("-------------------X-----------X");

        Map<String, List<String>> nameAndPlacesVisitedMap = roster.stream()
                .collect(Collectors.toMap(Person::getName, Person::getPlacesVisited));

        System.out.println("nameAndPlacesVisitedMap: "+nameAndPlacesVisitedMap);
        System.out.println("-------------------X-----------X");

        Map<Person, List<String>> personAndPlacesVisitedMap = roster.stream()
                .collect(Collectors.toMap(Function.identity(), Person::getPlacesVisited));

        System.out.println("personAndPlacesVisitedMap: "+personAndPlacesVisitedMap);
        System.out.println("-------------------X-----------X");

        Map<Person.Sex, IntSummaryStatistics> totalAgeByCategoryStatistics = roster.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingInt(Person::getAge)));

        System.out.println("totalAgeByCategoryStatistics: "+totalAgeByCategoryStatistics);
        System.out.println("-------------------X-----------X");

        List<Person> unmodifiableList = roster.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        System.out.println("unmodifiableList: "+unmodifiableList);

        /*unmodifiableList.removeIf(person -> person.getName().equals("Prakash"));
        unmodifiableList.add(new Person(
                "Prakash",
                IsoChronology.INSTANCE.date(1994, 11, 02),
                Person.Sex.MALE,
                "prakash@example.com",
                Arrays.asList("Bangalore", "chennai", "jaipur")));

        System.out.println("unmodifiableList: "+unmodifiableList);*/

    }
}
