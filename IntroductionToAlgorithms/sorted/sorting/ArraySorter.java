package IntroductionToAlgorithms.sorted.sorting;

import IntroductionToAlgorithms.sorted.algorithms.SortAlgorithm;

public class ArraySorter {

    private final SortAlgorithm algorithm;

    public ArraySorter(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Result sortAndMeasure(int[] array) {
        int[] copy = array.clone();
        long start = System.nanoTime();
        algorithm.sort(copy);
        long time = System.nanoTime() - start;
        return new Result(copy, time);
    }

    public static class Result {
        private final int[] sortedArray;
        private final long timeNano;

        public Result(int[] sortedArray, long timeNano) {
            this.sortedArray = sortedArray;
            this.timeNano = timeNano;
        }

        public int[] getSortedArray() { return sortedArray; }
        public long getTimeNano() { return timeNano; }
    }
}