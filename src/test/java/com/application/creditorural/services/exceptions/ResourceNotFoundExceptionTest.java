package com.application.creditorural.services.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResourceNotFoundExceptionTest {

    @Test
    void testConstructor() {
        ResourceNotFoundException actualResourceNotFoundException = new ResourceNotFoundException("Id");
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
        assertEquals("Resource not found. id Id", actualResourceNotFoundException.getMessage());
        assertEquals("Resource not found. id Id", actualResourceNotFoundException.getLocalizedMessage());
    }

}