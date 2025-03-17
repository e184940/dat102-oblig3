package uke11_4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class tidSoek {
    private static final int N_ELEMENTS = 100_000;
    private static final int N_SEARCHES = 10_000; // Ved å øke til 100 000 får man at HashSet har lavere gjennomsnitt
    private static final int UPPER_BOUND = 1_000_000;
    private static final int MEASUREMENT_RUNS = 10;

    public static void main(String[] args) {
        int[] array = new int[N_ELEMENTS];
        HashSet<Integer> hashSet = new HashSet<>(N_ELEMENTS, 1.0f);

        // Setter inn 100 000 ulike elementer
        int number = 376;
        for (int i = 0; i < N_ELEMENTS; i++) {
            array[i] = number;
            hashSet.add(number);
            number = (number + 45713) % UPPER_BOUND;
        }

        // Sorterer tabellen for binærsøk
        Arrays.sort(array);

        // Søkeverdier
        int[] searchValues = new int[N_SEARCHES];
        Random random = new Random();
        for (int i = 0; i < N_SEARCHES; i++) {
            searchValues[i] = random.nextInt(UPPER_BOUND);
        }

        double[] timesHashSet = new double[MEASUREMENT_RUNS];
        double[] timesBinary = new double[MEASUREMENT_RUNS];

        // Konvertering til ms
        for (int i = 0; i < MEASUREMENT_RUNS; i++) {
            timesHashSet[i] = measureHashSetSearch(hashSet, searchValues) / 1_000_000.0;
            timesBinary[i] = measureBinarySearch(array, searchValues) / 1_000_000.0;
        }

        double meanHS = average(timesHashSet);
        double meanBin = average(timesBinary);

        System.out.printf("HashSet - Gj.snitt: %.3f ms%n", meanHS);
        System.out.printf("Binærsøk - Gj.snitt: %.3f ms%n", meanBin);
    }

    private static long measureHashSetSearch(HashSet<Integer> hashSet, int[] searchValues) {
        long start = System.nanoTime();
        for (int val : searchValues) {
            hashSet.contains(val);
        }
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureBinarySearch(int[] array, int[] searchValues) {
        long start = System.nanoTime();
        for (int val : searchValues) {
            Arrays.binarySearch(array, val);
        }
        long end = System.nanoTime();
        return end - start;
    }

    private static double average(double[] values) {
        double sum = 0.0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.length;
    }
}