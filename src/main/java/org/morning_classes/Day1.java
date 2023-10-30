package org.morning_classes;

import java.util.*;

public class Day1 {


    public static void main(String[] args) {
        // Map exercise
        HashMap<Integer, String> students = new HashMap<>();
        students.put(3, "Natallia");
        students.put(1, "Nikita");
        students.put(2, "Tom");
        System.out.println(students.get(2));
        students.forEach((key, value) -> System.out.println("id: " + key + " ,name: " + value));

        Iterator<Map.Entry<Integer,String>> it = students.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> me = (Map.Entry<Integer,String>) it.next();
            System.out.println("id - " + me.getKey() + " name - " + me.getValue());
        }

        students.remove(2);
        System.out.println(students.get(2));

        LinkedHashMap<String,String> countries = new LinkedHashMap<>();
        countries.put("Germany", "Berlin");
        countries.put("Belarus", "Minsk");
        countries.put("Spain", "Madrid");
        countries.forEach((key, value) -> System.out.println(key + " : " + value));

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        String text = "My test text for java code to test how java work ma code java";
        List<String> words = Arrays.asList(text.split(" "));
        for(String word: words){
            wordCountMap.putIfAbsent(word, Collections.frequency(words, word));
        }
        wordCountMap.forEach((key, value) -> System.out.println(key + " : " + value));

        //Set exercise
        //Ex 1
        HashSet<Integer> integerSet = new HashSet<>();
        integerSet.add(4);
        integerSet.add(1);
        integerSet.add(23);
        integerSet.add(3);
        integerSet.add(1);
        System.out.println(integerSet);
        //Ex 2
        String[] arrStrings = {"apple", "banana", "apple", "cherry"};
        HashSet<String> uniqueStrings = new HashSet<>(List.of(arrStrings));
        System.out.println(uniqueStrings);
        //Ex 3
        TreeSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(4);
        sortedSet.add(1);
        sortedSet.add(23);
        sortedSet.add(3);
        sortedSet.add(1);
        System.out.println(sortedSet);
        //Ex 4
        TreeSet<Person> personSet = new TreeSet<>();
        personSet.add(new Person("Natallia", 36));
        personSet.add(new Person("Natallia", 30));
        personSet.add(new Person("Natallia", 20));
        personSet.add(new Person("Nikita", 18));
        personSet.add(new Person("Nikita", 8));
        personSet.forEach(person -> System.out.println(person.getName() + " : " + person.getAge()));
        //Ex 5
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1,3,7,5,9,6));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(1,2,3,4));
        HashSet<Integer> unionSet = new HashSet<Integer>(setA);
        unionSet.addAll(setB);
        HashSet<Integer> intersectionSet = new HashSet<Integer>(setA);
        intersectionSet.retainAll(setB);
        HashSet<Integer> differenceSet = new HashSet<Integer>(setA);
        differenceSet.removeAll(setB);

        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
        System.out.println("Difference " + differenceSet);

    }
}
