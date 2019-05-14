/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 * Class for quicksort algorithm
 * @author ggear
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create and load sample array
        int[] testArray;
        int numValues = 25, lowLimit = 10, highLimit = 99;
        String resultString;                    
        testArray = loadRands( numValues, lowLimit, highLimit );
        resultString = arrayToString( testArray, numValues );
        // test quicksort
        System.out.println( "\nArray before Quick Sort: " + resultString );
        runQuickSort( testArray, numValues );
        resultString = arrayToString( testArray, numValues );
        System.out.println( "Array after Quick Sort: " + resultString );

    }
    
   /**
     * Data sorted using quick sort algorithm
     * <p>
     * Note: Call runQuickSortHelper with lower and upper
     * indices of array to be sorted
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param size integer value holding the number of values in the array
     */
    public static void runQuickSort( int[] localArray, int size )
       {
            runQuickSortHelper(localArray, 0, size - 1);
       }
    
    /**
     * helper method run with parameters that support
     * recursive access
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param lowIndex low partIndex of the segment of the array 
 to be processed
     * 
     * @param highIndex high partIndex of the segment of the array 
 to be processed
     */
    private static void runQuickSortHelper( int[] localArray, int lowIndex, int highIndex )
       {
           // recalls itself until all values are in correct place
           if( highIndex > lowIndex )
           {
                int partIndex = runPartition(localArray, lowIndex, highIndex);
                runQuickSortHelper(localArray, lowIndex, partIndex - 1);
                runQuickSortHelper(localArray, partIndex + 1, highIndex);
           }
       }
   
    /**
     * Partitions array using the first value as the partition;
     * when this method is complete the partition value is
     * in the correct location in the array
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param lowIndex low partIndex of array segment to be partitioned
     * 
     * @param highIndex high partIndex of array segment to be partitioned
     * 
     * @return integer partIndex of partition pivot
     */
    public static int runPartition( int[] localArray, int lowIndex, int highIndex )
       {
           // save index of partition (chose first value) for swap with pivot
           int partValIndex = lowIndex;
           // save partition value  
           int partVal = localArray[lowIndex];
           int pivotIndex = lowIndex;
           // increment lowIndex before beggining loop 
           lowIndex++;
           // loops through swapping with pivot if less than value
           while( lowIndex <= highIndex )
           { 
               
                if( partVal > localArray[lowIndex] )
                {
                    pivotIndex++;
                    swapValues(localArray, pivotIndex, lowIndex);     
                }
                lowIndex++;
           }
           // swap with partVal once pivot is found
           swapValues(localArray, pivotIndex, partValIndex);
           return pivotIndex;
       }
    /**
     * Method to load a given integer array with random values
     * 
     * @param numRands integer identifies number of values to generate
     * 
     * @param lowLimit integer identifies low limit of generated randoms
     * 
     * @param highLimit integer identifies high limit of generated randoms
     * 
     * @return integer array with data loaded
     */
    public static int[] loadRands( int numRands, int lowLimit, int highLimit )
       {
        int index;
        int[] localArray = new int[ numRands ];
       
        for( index = 0; index < numRands; index++ )
           {
            localArray[ index ] = generateRandBetween( lowLimit, highLimit );
           }

        return localArray;
       }

    /**
     * Generate random value between the lowest and highest
     * specified limits inclusive
     * 
     * @param lowLimit specified integer low limit of random value range
     * 
     * @param highLimit specified integer high limit of random value range
     * 
     * @return random integer value generated between the inclusive limits
     */
    public static int generateRandBetween( int lowLimit, int highLimit )
       {
        int randVal, range;
       
        if( highLimit > lowLimit )
           {
            // create range of numbers
            range = highLimit - lowLimit + 1;
           
            // find random integer value from value between 0 and 1
            randVal = (int)( Math.random() * 1000000 );
           
            return randVal % range + lowLimit;
           }
       
        return 0;
       }

    /**
     * Converts array of integers into string for output or display
     * 
     * @param localArray integer array of values
     * 
     * @param size number of values in the array
     * 
     * @return String holding a list of all values, comma-delimited
     */
    public static String arrayToString( int[] localArray, int size )
       {
        int index;
        String outString ="";
        
        for( index = 0; index < size; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
            
            outString += localArray[ index ];
           }
        
        return outString;
       }
    
    /**
     * Swaps values within given array
     * 
     * @param localArray array of Objects used for swapping
     * 
     * @param indexOne integer partIndex for one of the two items to be swapped
     * 
     * @param indexOther integer partIndex for the other of the two items 
 to be swapped
     */
    public static void swapValues( int[] localArray, int indexOne, int indexOther )
       {
        int temp = localArray[ indexOne ];
        
        localArray[ indexOne ] = localArray[ indexOther ];
        
        localArray[ indexOther ] = temp;        
       }           
}

