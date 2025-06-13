package org.lucian.module5.exercise1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Store player names in ArrayList
        List<String> playersArrayList = new ArrayList<>();
        playersArrayList.add("Alice");
        playersArrayList.add("Bob");
        playersArrayList.add("Charlie");
        System.out.println("ArrayList: " + playersArrayList);

        // Insert in the middle
        playersArrayList.add(1, "Diana");
        System.out.println("ArrayList after insertion: " + playersArrayList);

        // Remove an element
        playersArrayList.remove("Bob");
        System.out.println("ArrayList after removal: " + playersArrayList);

        // Switch to LinkedList
        List<String> playersLinkedList = new LinkedList<>(playersArrayList);
        System.out.println("LinkedList: " + playersLinkedList);

        // Insert and remove in LinkedList
        playersLinkedList.add(2, "Eve");
        System.out.println("LinkedList after insertion: " + playersLinkedList);
        playersLinkedList.remove("Alice");
        System.out.println("LinkedList after removal: " + playersLinkedList);

        // --- Performance comparison ---
        final int N = 100_000;
        Random rand = new Random();

        // Fill both lists with N elements
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Measure random access time
        long start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            int idx = rand.nextInt(N);
            int val = arrayList.get(idx);
        }
        long arrayListAccess = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            int idx = rand.nextInt(N);
            int val = linkedList.get(idx);
        }
        long linkedListAccess = System.nanoTime() - start;

        // Measure insertion in the middle
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(N/2, -1);
        }
        long arrayListInsert = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(N/2, -1);
        }
        long linkedListInsert = System.nanoTime() - start;

        // Measure removal in the middle
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.remove(N/2);
        }
        long arrayListRemove = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.remove(N/2);
        }
        long linkedListRemove = System.nanoTime() - start;

        // Print results
        System.out.println("\n--- Performance Results (nanoseconds) ---");
        System.out.println("Random access (ArrayList):   " + arrayListAccess);
        System.out.println("Random access (LinkedList):  " + linkedListAccess);
        System.out.println("Insertion in middle (ArrayList):  " + arrayListInsert);
        System.out.println("Insertion in middle (LinkedList): " + linkedListInsert);
        System.out.println("Removal in middle (ArrayList):    " + arrayListRemove);
        System.out.println("Removal in middle (LinkedList):   " + linkedListRemove);
    }
}

/*
 * Explanation of performance differences:
 *
 * ArrayList:
 *  - Based on dynamic array.
 *  - Random access very fast (O(1)).
 *  - Insertions and removals in the middle are slow (O(n)), because they require shifting subsequent elements.
 *
 * LinkedList:
 *  - Based on doubly linked list.
 *  - Random access slow (O(n)), because the list must be traversed.
 *  - Insertions and removals in the middle are fast (O(1)), if the node reference is already available.
 *  - For frequent insert/remove operations at head/tail or in the middle, LinkedList is more efficient.
 *
 * In summary: if you do a lot of random reads, use ArrayList. If you do a lot of insertions/removals in the middle, use LinkedList.
 */


 // OUTPUT:
/*
ArrayList: [Alice, Bob, Charlie]
ArrayList after insertion: [Alice, Diana, Bob, Charlie]
ArrayList after removal: [Alice, Diana, Charlie]
LinkedList: [Alice, Diana, Charlie]
LinkedList after insertion: [Alice, Diana, Eve, Charlie]
LinkedList after removal: [Diana, Eve, Charlie]

--- Performance Results (nanoseconds) ---
Random access (ArrayList):   3.620.084
Random access (LinkedList):  432.040.000
Insertion in middle (ArrayList):  6.851.792
Insertion in middle (LinkedList): 85.849.083
Removal in middle (ArrayList):    4.482.583
Removal in middle (LinkedList):   9.147.916
*/