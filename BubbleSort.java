import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    
        // Method to create an array of random integers between 0 and 100
        public static int[] createRandomArray(int arrayLength) {
            Random rand = new Random();
            int[] array = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                array[i] = rand.nextInt(101); // random integer between 0 and 100
            }
            return array;
        }
    
        // Method to write an array to a file
        public static void writeArrayToFile(int[] array, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int num : array) {
                    writer.write(num + "\n"); // write each integer in the array to a new line
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    
        // Method to read integers from a file into an array
        public static int[] readFileToArray(String filename) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                return reader.lines().mapToInt(Integer::parseInt).toArray();
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
            return new int[0]; // return empty array if an error occurs
        }
    
        // Method to sort an array using bubble sort
        public static void bubbleSort(int[] array) {
            int n = array.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        // Swap array[j] and array[j+1]
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) break; // If no elements were swapped, the array is already sorted
            }
        }
    
        // Main method to handle user input and coordinate functionality
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the length of the random array:");
            int arrayLength = scanner.nextInt();
    
            int[] randomArray = createRandomArray(arrayLength);
    
            System.out.println("Enter the filename to save the array:");
            String filename = scanner.next();
    
            writeArrayToFile(randomArray, filename);
    
            System.out.println("Array saved to file. Reading the array back from the file...");
    
            int[] fileArray = readFileToArray(filename);
    
            System.out.println("Array before sorting:");
            for (int num : fileArray) {
                System.out.print(num + " ");
            }
            System.out.println();
    
            bubbleSort(fileArray);
    
            System.out.println("Array after sorting:");
            for (int num : fileArray) {
                System.out.print(num + " ");
            }

            scanner.close();
        }
}