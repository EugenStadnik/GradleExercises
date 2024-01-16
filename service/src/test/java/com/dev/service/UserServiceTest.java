package com.dev.service;

import com.dev.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        assertEquals(3, service.getAll().size());
    }
    @Test
    void contains() {
        assertTrue(service.getAll().contains(new User(13, "Ivan")));
    }
}