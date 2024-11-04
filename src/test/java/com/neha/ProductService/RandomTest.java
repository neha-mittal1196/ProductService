package com.neha.ProductService;

import exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {

    @Test
    void testIsOnePlusOneIsTwo() {
        int i = 1 + 1; //Arrange + Act
        boolean flag = true;
        //Assert - Check against the expected value.
       assert i==2;
       assertEquals(7,i, "1+1 should equal 2");
       assertTrue(flag);
       //assertThrows(ProductNotFoundException.class, func(10));
       //assertNull();
       //assertTimeout();
    }

}

//TC is nothing but a method that tests a particular functionality across the expected value.
//If more than 1 assert is there and if even any one of them fails then TC will fail.

//In some cases,we might need to check if the value is null or not or if the function is throwing an exception or not.

//Scenario- If we want to test the time taken by a particular function to get executed.

/* 3A framework
* Arrange
* Act
* Assert
*/