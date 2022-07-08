package com.application.creditorural.DTO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DtoRootTest {

    @Test
    void testCanEqual() {
        assertFalse((new DtoRoot()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        DtoRoot dtoRoot = new DtoRoot();
        assertTrue(dtoRoot.canEqual(new DtoRoot()));
    }

    @Test
    void testConstructor() {
        DtoRoot actualDtoRoot = new DtoRoot();
        ArrayList<ListDto> listDtoList = new ArrayList<>();
        actualDtoRoot.setValue(listDtoList);
        String actualToStringResult = actualDtoRoot.toString();
        assertSame(listDtoList, actualDtoRoot.getValue());
        assertEquals("DtoRoot(value=[])", actualToStringResult);
    }

    @Test
    void testConstructor2() {
        ArrayList<ListDto> listDtoList = new ArrayList<>();
        DtoRoot actualDtoRoot = new DtoRoot(listDtoList);
        ArrayList<ListDto> listDtoList1 = new ArrayList<>();
        actualDtoRoot.setValue(listDtoList1);
        String actualToStringResult = actualDtoRoot.toString();
        List<ListDto> value = actualDtoRoot.getValue();
        assertSame(listDtoList1, value);
        assertEquals(listDtoList, value);
        assertEquals("DtoRoot(value=[])", actualToStringResult);
    }

    @Test
    void testEquals() {
        assertNotEquals(new DtoRoot(), null);
        assertNotEquals(new DtoRoot(), "Different type to DtoRoot");
    }

    @Test
    void testEquals2() {
        DtoRoot dtoRoot = new DtoRoot();
        assertEquals(dtoRoot, dtoRoot);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot.hashCode());
    }

    @Test
    void testEquals3() {
        DtoRoot dtoRoot = new DtoRoot();
        DtoRoot dtoRoot1 = new DtoRoot();
        assertEquals(dtoRoot, dtoRoot1);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot1.hashCode());
    }

    @Test
    void testEquals4() {
        DtoRoot dtoRoot = new DtoRoot(new ArrayList<>());
        assertNotEquals(dtoRoot, new DtoRoot());
    }

    @Test
    void testEquals5() {
        DtoRoot dtoRoot = new DtoRoot();
        assertNotEquals(dtoRoot, new DtoRoot(new ArrayList<>()));
    }

    @Test
    void testEquals6() {
        DtoRoot dtoRoot = new DtoRoot(new ArrayList<>());
        DtoRoot dtoRoot1 = new DtoRoot(new ArrayList<>());
        assertEquals(dtoRoot, dtoRoot1);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot1.hashCode());
    }

}