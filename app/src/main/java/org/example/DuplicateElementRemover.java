package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateElementRemover<T> {
    ArrayList<T> removeDuplicates(ArrayList<T> list) {
        HashSet<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
