package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ContactBookTest {

    private ContactBook contactBook;

    void setupStage1(){
        contactBook = new ContactBook();
    }

    void setupStage2(){
        contactBook = new ContactBook();
        contactBook.addContact("user", "user@gmail.com", "123");
    }
    @Test
    void testSearch1(){
        // arrange / init
        setupStage1();
        //Action
        String email = "user@gmail.com";
        Contact contactResult = contactBook.search(email);
        //Assertion
        assertNull(contactResult);
    }

    @Test
    void testSearch2(){
        //arrange
        setupStage2();
        //act
        Contact contactResult = contactBook.search("null@gmail.com");
        //Assert
        assertNull(contactResult);
    }
}