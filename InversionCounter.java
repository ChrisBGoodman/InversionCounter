import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * Created by Christian Goodman on 2/9/15
 * Algorithms 
 * Project 1
 * 
 */
public class InversionCounter {

	public int[] source1 = new int[10000];			//Vars to hold all source data 
	public int[] source2 = new int[10000];
	public int[] source3 = new int[10000];
	public int[] source4 = new int[10000];
	public int[] source5 = new int[10000];
	public int[] sum = new int[10000];
	public int[] count = new int[10000];

	{ 
		int fileNum = 1;
		try {										//Below Switch reads in all source files into respected arrays
			do{
				Scanner scanner = new Scanner(new File("src/sources1/source" + fileNum + ".txt"));
				int i = 0; //reset I 

				switch (fileNum) {
				case 1: 
					while(scanner.hasNextInt())
					{
						source1[i] = scanner.nextInt();
						i++;
					}
					break;
				case 2:
					while(scanner.hasNextInt())
					{
						source2[i] = scanner.nextInt();
						i++;
					}
					break;
				case 3:
					while(scanner.hasNextInt())
					{
						source3[i] = scanner.nextInt();
						i++;
					}
					break;
				case 4:
					while(scanner.hasNextInt())
					{
						source4[i] = scanner.nextInt();
						i++;
					}
					break;
				case 5:
					while(scanner.hasNextInt())
					{
						source5[i] = scanner.nextInt();
						i++;
					}
					break;
				}
				fileNum++; //Increment to next source File
			} while (fileNum < 6);
		}

		 catch (FileNotFoundException e) {
			e.printStackTrace();}
		catch (IOException ee) {
			ee.printStackTrace();}
	
	getSum();			//Get sum of each source ranking and create a new array with the data of Summation 
	quickSort(sum, 0, sum.length - 1);
	
	
	for (int i = 0; i < 10000; i++)
	{
		System.out.println(sum[i]);
	}
	
	
}
	
	
	
	
	
	
	
//-------------------------------------------------------------------------------------
	public static void main(String[] args) {

		InversionCounter iC = new InversionCounter();

	}

//-------------------------------------------------------------------------------------
	//Finds sum of all source files
	public void getSum()
	{
		for (int i = 0; i < 10000; i++)
		{
			sum[i] = source1[i] + source2[i] + source3[i] + source4[i] + source5[i];
		}
	}
//-------------------------------------------------------------------------------------
	
	public static void MergeSort()
	{
		
	}
	
	int getIndex(int arr[], int left, int right)

	{
	      int i = left;
	      int j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2]; 
	      
	      while (i <= j)  						//While left less then right
	      {
	            while (arr[i] < pivot)		
	                  i++;					
	            while (arr[j] > pivot)			
	                  j--;
	            if (i <= j) {					//Swap positions 
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      }
	      return i; //return index 
	}

	void quickSort(int arr[], int left, int right)
	{
	      int index = getIndex(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);

	}
}
