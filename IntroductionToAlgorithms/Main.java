package IntroductionToAlgorithms;

import IntroductionToAlgorithms.sorted.algorithms.MergeSort;
import IntroductionToAlgorithms.sorted.algorithms.QuickSort;
import IntroductionToAlgorithms.sorted.generator.ArrayGenerator;
import IntroductionToAlgorithms.sorted.input.ArrayInput;
import IntroductionToAlgorithms.sorted.sorting.ArraySorter;
import IntroductionToAlgorithms.sorted.sorting.ArraySorter.Result;
import IntroductionToAlgorithms.sorted.util.ArrayPrinter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Ввод размера массива
        int size = new ArrayInput().inputSize();

        // Генерация массива
        int[] original = new ArrayGenerator().generateRandomArray(size);

        // --- Вывод исходного массива ---
        ArrayPrinter.printArray("Original array", original);

        // --- Сортировка QuickSort ---
        ArraySorter quickSorter = new ArraySorter(new QuickSort());
        Result quickResult = quickSorter.sortAndMeasure(original);

        // --- Сортировка MergeSort ---
        ArraySorter mergeSorter = new ArraySorter(new MergeSort());
        Result mergeResult = mergeSorter.sortAndMeasure(original);

        // --- Сортировка стандартной Arrays.sort() ---
        ArraySorter javaSorter = new ArraySorter(Arrays::sort);
        Result javaResult = javaSorter.sortAndMeasure(original);

        // --- Вывод отсортированных массивов ---
        ArrayPrinter.printArray("Sorted with QuickSort", quickResult.getSortedArray());
        ArrayPrinter.printArray("Sorted with MergeSort", mergeResult.getSortedArray());
        ArrayPrinter.printArray("Sorted with Arrays.sort", javaResult.getSortedArray());

        // --- Вывод времени сортировок ---
        System.out.println("\n=== TIME RESULTS ===");
        ArrayPrinter.printTime("QuickSort", quickResult.getTimeNano());
        ArrayPrinter.printTime("MergeSort", mergeResult.getTimeNano());
        ArrayPrinter.printTime("Arrays.sort", javaResult.getTimeNano());
    }
}