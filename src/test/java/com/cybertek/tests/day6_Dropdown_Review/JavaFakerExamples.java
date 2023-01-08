package com.cybertek.tests.day6_Dropdown_Review;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void faker_test(){

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String secondName = faker.name().lastName();
        System.out.println("secondName = " + secondName);

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

    }

}
