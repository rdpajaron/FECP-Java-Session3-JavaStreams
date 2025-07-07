package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class JavaStreams {

    public static void main(String[] args) {
        // Activity 1
        System.out.println("Activity 1:");
        List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        filterOddNumbers(listOfNumbers);

        // Activity 2
        System.out.println("Activity 2");
        List<String> listOfNames = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        stringsStartingWithA(listOfNames);

        // Activity 3
        System.out.println("Activity 3");
        List<Integer> listOfInt = Arrays.asList(1,2,3,4,5);
        squareNumbers(listOfInt);

        //Activity 4
        System.out.println("\nActivity 4");
        combinedPredicate(listOfNumbers);

        // Activity 5
        System.out.println("\nActivity 5:");
        List<PersonSortActivity> personList = new ArrayList<>();
        personList.add(new PersonSortActivity("John", 18));
        personList.add(new PersonSortActivity("Jane", 15));
        personList.add(new PersonSortActivity("Ben", 25));
        personList.add(new PersonSortActivity("Bob", 45));
        personList.add(new PersonSortActivity("Mark", 21));
        System.out.println("Sorted by age (ascending):");
        personList.stream().sorted(Comparator.comparingInt(PersonSortActivity::getAge)).forEach(System.out::println);

        System.out.println("Sorted by name:");
        personList.stream().sorted(Comparator.comparing(PersonSortActivity::getName)).forEach(System.out::println);

        System.out.println("Sorted by age(descending):");
        Comparator<PersonSortActivity> sortAgeDescOrder = (n1, n2) -> n2.getAge() - n1.getAge();
        personList.stream().sorted(sortAgeDescOrder).forEach(System.out::println);
    }

    public static void filterOddNumbers(List<Integer> listOfNumbers){
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        System.out.println("Odd numbers: " + listOfNumbers.stream().filter(isOdd).toList());
    }

    public static void stringsStartingWithA(List<String> listOfNames){
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println("Names starting with A: " + listOfNames.stream().filter(startsWithA).toList());
    }

    public static void squareNumbers(List<Integer> listOfInt){
        System.out.print("Squared Numbers: " + listOfInt.stream(). map(n -> n * n).toList().toString());
    }

    public static void combinedPredicate(List<Integer> listOfNumbers){
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        System.out.print("Even and >5: " + listOfNumbers.stream().filter(isEven.and(greaterThanFive)).toList().toString());
    }

}

class PersonSortActivity{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    PersonSortActivity(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return getName() + " - " + getAge();
    }

}