package edu.cuny.csi.csc330.lab2;

import java.util.Arrays;


public class NumericAnalyzer {

	private int size, sum, mean, median, min, max, range;
	private int variance, standardDeviation, varianceSum;
	private int[] intArray;
	
	public NumericAnalyzer(String[] array) {
		
		int arraySize = array.length;									
		intArray = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			try {
				intArray[i] = Integer.parseInt(array[i]);
			} catch (NumberFormatException e) {
				System.err.println("Failed To Pass In NON-Integer Value... Value Must Be Numeric:  " + array[i]);
				System.exit(1);
			} // Catch		
		} // ForLoop
		
		Arrays.sort(intArray); 									
		
		size = intArray.length;
	}
	
	public void analyze() {
		
		// Sum Value
		sum = 0;
		for (int i = 0; i < size; i++) {
			sum = (sum + intArray[i]);
		}
		
		// Mean Value
		mean = sum /size;
		
		
		// Median Value
		int l = size / 2;
		if((size % 2) == 0) {
			median = intArray[l - 1] + intArray[l];
			median = median / 2;
		}
		else 
			median = intArray[l];
		
		// Min and Max Value
		min = intArray[0];
		max = intArray[size - 1];
		
		// Range Value
		range = max - min;
		
		// Variance Value
		varianceSum = 0;
		int[] distanceArr = new int[size];
		for(int i = 0; i < size; i++) {
			distanceArr[i] = intArray[i] - mean;
			distanceArr[i] = (int) Math.pow(distanceArr[i], 2);
		}
		
		for (int i = 0; i < size; i++) {
			varianceSum = (varianceSum + distanceArr[i]);
		}
		variance = varianceSum/size;
		
		// Standard Deviation
		standardDeviation = (int) Math.sqrt(variance);
		
	}
	
	public void display() {
		
		for(int i = 0; i < size; i++) {
			System.out.printf("%-,7d", intArray[i]);
		} // ForLoop
		
		System.out.println();
		System.out.printf(" \n%-30s %,d\n", "Count:", size);
		System.out.printf("%-30s %,d\n", "Min:", min);
		System.out.printf("%-30s %,d\n", "Max:", max);
		System.out.printf("%-30s %,d\n", "Range:", range);
		System.out.printf("%-30s %,d\n", "Sum:", sum);
		System.out.printf("%-30s %,d\n", "Mean:", mean);
		System.out.printf("%-30s %,d\n", "Median:", median);
		System.out.printf("%-30s %,d\n", "Variance:", variance);
		System.out.printf("%-30s %,d\n", "Standard Deviation:", standardDeviation);
	}
	
	
	
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.err.printf("ERROR : No values were entered... Expecting a Numeric Value");
			System.exit(1);
		}
		
		
		NumericAnalyzer analyzer = new NumericAnalyzer(args);
		
		analyzer.analyze();
		analyzer.display();
		
		System.exit(0);
	}

}
