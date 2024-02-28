package com.kodilla.spring.kodillaspring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForumUserTestSuite {

    @Autowired
    private ForumUser forumUser;
    @Test
    public void testGetUsername() {
        // Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        // When
        String result = forumUser.getUsername();

        // Then
        assertEquals("John Smith", result);
    }
}
