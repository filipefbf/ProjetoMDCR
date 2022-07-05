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

    /**
     * Method under test: {@link DtoRoot#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new DtoRoot()).canEqual("Other"));
    }

    /**
     * Method under test: {@link DtoRoot#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        DtoRoot dtoRoot = new DtoRoot();
        assertTrue(dtoRoot.canEqual(new DtoRoot()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DtoRoot#DtoRoot()}
     *   <li>{@link DtoRoot#setValue(List)}
     *   <li>{@link DtoRoot#toString()}
     *   <li>{@link DtoRoot#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        DtoRoot actualDtoRoot = new DtoRoot();
        ArrayList<ListDto> listDtoList = new ArrayList<>();
        actualDtoRoot.setValue(listDtoList);
        String actualToStringResult = actualDtoRoot.toString();
        assertSame(listDtoList, actualDtoRoot.getValue());
        assertEquals("DtoRoot(value=[])", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DtoRoot#DtoRoot(List)}
     *   <li>{@link DtoRoot#setValue(List)}
     *   <li>{@link DtoRoot#toString()}
     *   <li>{@link DtoRoot#getValue()}
     * </ul>
     */
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

    /**
     * Method under test: {@link DtoRoot#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new DtoRoot(), null);
        assertNotEquals(new DtoRoot(), "Different type to DtoRoot");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DtoRoot#equals(Object)}
     *   <li>{@link DtoRoot#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        DtoRoot dtoRoot = new DtoRoot();
        assertEquals(dtoRoot, dtoRoot);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DtoRoot#equals(Object)}
     *   <li>{@link DtoRoot#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        DtoRoot dtoRoot = new DtoRoot();
        DtoRoot dtoRoot1 = new DtoRoot();
        assertEquals(dtoRoot, dtoRoot1);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot1.hashCode());
    }

    /**
     * Method under test: {@link DtoRoot#equals(Object)}
     */
    @Test
    void testEquals4() {
        DtoRoot dtoRoot = new DtoRoot(new ArrayList<>());
        assertNotEquals(dtoRoot, new DtoRoot());
    }

    /**
     * Method under test: {@link DtoRoot#equals(Object)}
     */
    @Test
    void testEquals5() {
        DtoRoot dtoRoot = new DtoRoot();
        assertNotEquals(dtoRoot, new DtoRoot(new ArrayList<>()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link DtoRoot#equals(Object)}
     *   <li>{@link DtoRoot#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        DtoRoot dtoRoot = new DtoRoot(new ArrayList<>());
        DtoRoot dtoRoot1 = new DtoRoot(new ArrayList<>());
        assertEquals(dtoRoot, dtoRoot1);
        int expectedHashCodeResult = dtoRoot.hashCode();
        assertEquals(expectedHashCodeResult, dtoRoot1.hashCode());
    }

}