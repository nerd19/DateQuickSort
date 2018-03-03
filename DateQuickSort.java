/**
 * Nicole Binette
 * February 27, 2018
 * Assignment 5
 */
import java.util.Random;
public class DateQuickSort extends Date {
    
    /**
    The quickSort method calls the doQuickSort method
    to sort an int array.
    @param array The array to sort.
    */
   
    public static void quickSort(Date array[])
    {
        doQuickSort(array, 0, array.length - 1);
    }

    /**
    The doQuickSort method uses the QuickSort algorithm
    to sort an int array.
    @param array The array to sort.
    @param start The starting subscript of the list to sort
    @param end The ending subscript of the list to sort
    */
  
    private static void doQuickSort(Date array[], int start, int end)
    {
        int pivotPoint;
     
        if (start < end)
        {
        // Get the pivot point.
        pivotPoint = partition(array, start, end);
        
        // Sort the first sub list.
        doQuickSort(array, start, pivotPoint - 1);
        
        // Sort the second sub list.
        doQuickSort(array, pivotPoint + 1, end);
        }
    }

    /**
    The partiton method selects a pivot value in an array
    and arranges the array into two sub lists. All the
    values less than the pivot will be stored in the left
    sub list and all the values greater than or equal to
    the pivot will be stored in the right sub list.
    @param array The array to partition.
    @param start The starting subscript of the area to partition.
    @param end The ending subscript of the area to partition.
    @return The subscript of the pivot value.
    */
  
    private static int partition(Date array[], int start, int end)
    {
        Date pivotValue;    // To hold the pivot value
        int endOfLeftList; // Index of last element in the left sub list.
        int mid;           // To hold the mid-point subscript

        // Find the subscript of the middle element.
        // This will be our pivot value.
        mid = (start + end) / 2;

        // Swap the middle element with the first element.
        // This moves the pivot value to the start of 
        // the list.
        swap(array, start, mid);

        // Save the pivot value for comparisons.
        pivotValue = array[start];
     
        // For now, the end of the left sub list is
        // the first element.
        endOfLeftList = start;
     
        // Scan the entire list and move any values that
        // are less than the pivot value to the left
        // sub list.
        for (int scan = start + 1; scan <= end; scan++)
        {
            if (array[scan].compareTo(pivotValue) == -1)
            {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }
     
        // Move the pivot value to end of the
        // left sub list.
        swap(array, start, endOfLeftList);
     
        // Return the subscript of the pivot value.
        return endOfLeftList;
    }

    /**
     The swap method swaps the contents of two elements
     in an int array.
     @param The array containing the two elements.
     @param a The subscript of the first element.
     @param b The subscript of the second element.
    */
  
    private static void swap(Date [] array, int a, int b)
    {
        Date temp;
     
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * @return String representation of Date where the month is a String
     */
    @Override

    public String toString() {

        return super.toString();
    }

    public static void main(String[] args) {
        // Create random numbers for dates between January 1, 2018 - December 31, 2018
        // Some days may be imaginary
        Random randomMonth = new Random();
        int randomYear = 2018;
        Random randomDay = new Random();
        Date dates[] = new Date [101];
        // Generate random dates and print them
        for (int index = 0; index < dates.length; index ++) {
            dates[index] = new Date(randomMonth.nextInt(12) + 1, randomDay.nextInt(31) + 1, randomYear);
            System.out.println(dates[index]);
        }
        // Sort the random dates
        quickSort(dates);
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
    }
}