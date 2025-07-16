package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class DuplicateElementRemoverTest {
    @Test
    void testRemoveDuplicatesString() {
        DuplicateElementRemover<String> remover = new DuplicateElementRemover<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple"); // duplicate
        list.add("orange");

        ArrayList<String> uniqueList = remover.removeDuplicates(list);

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("apple");
        expectedList.add("banana");
        expectedList.add("orange");

        expectedList.sort(String::compareTo);
        uniqueList.sort(String::compareTo);
        
        assertEquals(expectedList.size(), uniqueList.size(), "Unique list should have 3 elements");
        assertEquals(expectedList, uniqueList, "Unique list should match expected list");
    }

    @Test
    void testRemoveDuplicatesInteger() {
        DuplicateElementRemover<Integer> intRemover = new DuplicateElementRemover<>();
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(2); // duplicate
        intList.add(3);

        ArrayList<Integer> uniqueIntList = intRemover.removeDuplicates(intList);
        ArrayList<Integer> expectedIntList = new ArrayList<>();
        expectedIntList.add(1);
        expectedIntList.add(2);
        expectedIntList.add(3);

        expectedIntList.sort(Integer::compareTo);
        uniqueIntList.sort(Integer::compareTo);

        assertEquals(3, uniqueIntList.size(), "Unique integer list should have 3 elements");
    }

    @Test
    void testRemoveDuplicatesEmptyList() {
        DuplicateElementRemover<String> remover = new DuplicateElementRemover<>();
        ArrayList<String> emptyList = new ArrayList<>();

        ArrayList<String> uniqueList = remover.removeDuplicates(emptyList);
        assertTrue(uniqueList.isEmpty(), "Unique list should be empty for an empty input list");
    }

    @Test
    void testRemoveDuplicatesSingleElementList() {
        DuplicateElementRemover<String> remover = new DuplicateElementRemover<>();
        ArrayList<String> singleElementList = new ArrayList<>();
        singleElementList.add("one");
        singleElementList.add("two");

        ArrayList<String> uniqueList = remover.removeDuplicates(singleElementList);
        assertEquals(singleElementList, uniqueList);
    }

    @Test
    void testRemoveDuplicatesAllDuplicates() {
        DuplicateElementRemover<String> remover = new DuplicateElementRemover<>();
        ArrayList<String> allDuplicatesList = new ArrayList<>();
        allDuplicatesList.add("duplicate");
        allDuplicatesList.add("duplicate");
        allDuplicatesList.add("duplicate");

        ArrayList<String> uniqueList = remover.removeDuplicates(allDuplicatesList);
        
        assertEquals(1, uniqueList.size(), "Unique list should have 1 element when all elements are duplicates");
        assertEquals("duplicate", uniqueList.get(0), "Unique element should be 'duplicate'");
    }
}
