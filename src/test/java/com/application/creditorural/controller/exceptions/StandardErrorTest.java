package com.application.creditorural.controller.exceptions;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardErrorTest {

    @Test
    void testConstructor() {
        StandardError actualStandardError = new StandardError();
        actualStandardError.setError("An error occurred");
        actualStandardError.setMessage("Not all who wander are lost");
        actualStandardError.setPath("Path");
        actualStandardError.setStatus(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualStandardError.setTimeStamp(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        assertEquals("An error occurred", actualStandardError.getError());
        assertEquals("Not all who wander are lost", actualStandardError.getMessage());
        assertEquals("Path", actualStandardError.getPath());
        assertEquals(1, actualStandardError.getStatus().intValue());
    }

    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        StandardError actualStandardError = new StandardError(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant(), 1,
                "An error occurred", "Not all who wander are lost", "Path");
        actualStandardError.setError("An error occurred");
        actualStandardError.setMessage("Not all who wander are lost");
        actualStandardError.setPath("Path");
        actualStandardError.setStatus(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualStandardError.setTimeStamp(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        assertEquals("An error occurred", actualStandardError.getError());
        assertEquals("Not all who wander are lost", actualStandardError.getMessage());
        assertEquals("Path", actualStandardError.getPath());
        assertEquals(1, actualStandardError.getStatus().intValue());
    }

}