package 동작파라메터연습;

import java.util.Arrays;
import java.util.Comparator;

public class SortByComparator {
    public static void main(String[] args) {
        Person people[] = new Person[4];
        people[0] = new Person("김광민",31);
        people[1] = new Person("박소현",30);
        people[2] = new Person("양성민",31);
        people[3] = new Person("권영우",31);

        Arrays.sort(people, new ObjectSort());
        for (Person p: people) {
            System.out.println(p.getName() + "," + p.getAge());
        }
    }

}

 class Person {
     String name;
     int age;

     public Person(String name, int age){
         this.name = name;
         this.age = age;
     }



     public int getAge() {
         return age;
     }

     public String getName() {
         return name;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public void setName(String name) {
         this.name = name;
     }
 }

 class ObjectSort implements Comparator<Person> {
     @Override
     public int compare(Person p1, Person p2) {
         if(p1.getAge() == p2.getAge()) return p1.getName().compareTo(p2.getName());
         return p1.getAge() - p2.getAge();
     }

 }