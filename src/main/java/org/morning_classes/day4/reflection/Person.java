package org.morning_classes.day4.reflection;

public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

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

    @Override
    public int compareTo(Object o) {
        int result = name.compareTo(((Person) o).getName());
        if(result == 0){
            result= Integer.compare(age, ((Person) o).getAge());
        }
        return result;
    }
}
