package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

class Address {

    String country;
    String city;

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}

class Person {
    String name;
    String surname;
    String[] phones;
    int age;
    Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", age=" + age +
                '}';
    }
}

public class App {

    static final String JSON = """
            {
            "name" : "Vsevolod",
            "surname" : "Ievgenko",
            "phones" : ["347843921", "6739820836"],
            "age" : 46,
            "address" : {
                "country" : "UA",
                "city" : "Kyiv"
             }
            }       
         """;

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Person person = gson.fromJson(JSON, Person.class);
        System.out.println(person);

        person.age = 15;
        String json = gson.toJson(person);
        System.out.println(json);
    }
}
