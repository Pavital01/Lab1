package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static Integer countAllPersons = 1;
    public String name = "N" + countAllPersons;

    public String gender;

    public List<Integer> gen = new ArrayList<>();
    public Integer personalQuality;

    static Integer a = 0;
    static Integer b = 2;

    Person(){
        gender = getRandom01() == 1 ? "M" : "F";
        countAllPersons++;

        fillGen();

        System.out.println(gen);
    }
    Person(String name){
        this.name = name;
        countAllPersons++;


        gender = getRandom01() == 1 ? "M" : "F";

        fillGen();

    }

    Person(String name,String gender) {
        this.name = name;
        this.gender = gender;
        countAllPersons++;


        fillGen();
    }
    Person(String name,String gender,List<Integer> gen) {
        this.name = name;
        this.gender = gender;
        this.gen = gen;
        countAllPersons++;


    }

    private void fillGen(){
        for (int i = 0; i < 6; i++) {
            gen.add(getRandom01());
        }
    }

    private Integer getRandom01() {
        Integer result = (int) (( Math.random() * (b-a) ) + a);
        return result;
    }

    public List<Person> crossing(Person anotherPerson){
        if (verifyForPartner(anotherPerson)){
            List<Person> buffer = new ArrayList<>();
            Integer positionDivision = 3;
            List<Integer> newGen1 = new ArrayList<>();
            for (int i = 0; i < positionDivision; i++) {
                newGen1.add(gen.get(i));
            }
            for (int i = positionDivision; i < 6; i++) {
                newGen1.add(anotherPerson.gen.get(i));
            }
            List<Integer> newGen2 = new ArrayList<>();
            for (int i = 0; i < positionDivision; i++) {
                newGen2.add(anotherPerson.gen.get(i));
            }
            for (int i = positionDivision; i < 6; i++) {
                newGen2.add(gen.get(i));
            }

            Person newPerson1 = new Person("N" + (Person.countAllPersons + 1),getRandom01() == 1 ? "M" : "F",newGen1);
            Person newPerson2 = new Person("N" + (Person.countAllPersons + 1),getRandom01() == 1 ? "M" : "F",newGen2);

            buffer.add(newPerson1);
            buffer.add(newPerson2);

            return buffer;
        }
        else throw new RuntimeException("!!!!");
//        return null;
    }

    public boolean verifyForPartner(Person anotherPerson){
        if (!name.equals(anotherPerson.name) && !gender.equals(anotherPerson.gender)){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Person " + name + " " + gender + "\n\t" + gen + "\n";
    }
}
