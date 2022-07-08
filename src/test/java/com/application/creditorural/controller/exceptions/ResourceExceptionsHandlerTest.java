package com.application.creditorural.controller.exceptions;

import com.application.creditorural.services.exceptions.ResourceNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceExceptionsHandlerTest {

    @Test
    void testResourceNotFound() {
        ResourceExceptionsHandler resourceExceptionsHandler = new ResourceExceptionsHandler();
        ResourceNotFoundException e = new ResourceNotFoundException("Id");
        ResponseEntity<StandardError> actualResourceNotFoundResult = resourceExceptionsHandler.resourceNotFound(e,
                new MockHttpServletRequest());
        assertTrue(actualResourceNotFoundResult.hasBody());
        assertTrue(actualResourceNotFoundResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualResourceNotFoundResult.getStatusCode());
        StandardError body = actualResourceNotFoundResult.getBody();
        assertEquals("Resource not found. id Id", body.getMessage());
        assertEquals("Resource not found", body.getError());
        assertEquals("", body.getPath());
        assertEquals(404, body.getStatus().intValue());
    }
}