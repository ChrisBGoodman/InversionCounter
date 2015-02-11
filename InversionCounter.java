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
/*
 * Really lost on what to do. 
 * getSum() will return summation array of all source files added across by row 
 * quickSort() will perform a quickSort on a passed array with no return 
 * inversionCounter() simply loops over each individal array location comparing and keeps running total of 'inversions'
 * 
 * 
 * 
 * 
 * 
 */
	public int[][] source1 = new int[10000][2];			//Vars to hold all source data 
	public int[][] source2 = new int[10000][2];
	public int[][] source3 = new int[10000][2];
	public int[][] source4 = new int[10000][2];
	public int[][] source5 = new int[10000][2];
	public int[][] sum = new int[10000][2];
	public int[][] sortedSum = new int[10000][2];
	public int[] count = new int[10000];
	public int inversionCount = 0;
	
	
	{ 
		int fileNum = 1;
		try {										//Below Switch reads in all source files into respected arrays
			do{
				Scanner scanner = new Scanner(new File("src/sources1/source" + fileNum + ".txt"));
				int i = 0; //reset I 
				int x = 1; //reset X

				switch (fileNum) {
				case 1: 
					while(scanner.hasNextInt())
					{
						source1[i][0] = scanner.nextInt();
						source1[i][1] = x; 
						i++;
						x++;
						
					}
					break;
				case 2:
					while(scanner.hasNextInt())
					{
						source2[i][0] = scanner.nextInt();
						source2[i][1] = x; 
						i++;
						x++;
					}
					break;
				case 3:
					while(scanner.hasNextInt())
					{
						source3[i][0] = scanner.nextInt();
						source3[i][1] = x; 
						i++;
						x++;
					}
					break;
				case 4:
					while(scanner.hasNextInt())
					{
						source4[i][0] = scanner.nextInt();
						source4[i][1] = x; 
						i++;
						x++;
					}
					break;
				case 5:
					while(scanner.hasNextInt())
					{
						source5[i][0] = scanner.nextInt();
						source5[i][1] = x; 
						i++;
						x++;
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
	sortedSum = sum;
	quickSort(sum, 0, source1.length - 1);
	inversionCounter(source1);
	reOrder();
	
	
	
	for (int i = 0; i < 10000; i++)
	{
		
		System.out.print("D: " + source1[i][0]);
		//System.out.print(" ========  ");
		System.out.println(" I: " + source1[i][1]);
		//System.out.println(source1[2][0]);
		//System.out.println(source1[2][1]);
		
		
		
	}
	
	System.out.println("Inversions" + inversionCount);
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
			sum[i][0] = source1[i][0] + source2[i][0] + source3[i][0] + source4[i][0] + source5[i][0];
			sum[i][1] = i;
		}
	}
//-------------------------------------------------------------------------------------
	
	public static void MergeSort()
	{
		
	}
	
	public void reOrder()
	{
		
		for (int x = 0; x < 10000; x++)
		{
			int i = 0;
			while (source1[i][1] != sum[x][1]) //while not equal, search source file for num
			{
				i++;
				{
					int tmp = source1[i][1];	//tmp = found index location
					source1[i][1] = x;			//source index location swapped with correct location 
					source1[x][1] = tmp;		//location moved
				}
			}
		
		}
	}
	
	int getIndex(int arr[][], int left, int right)

	{
	      int i = left;
	      int j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2][0]; 	//choose pivot based on middle element 
	      
	      while (i <= j)  						//While left less then right
	      {
	            while (arr[i][0] < pivot)	
	            {								//Increment array to find correct location for data
	                  i++;
	            }					
	            while (arr[j][0] > pivot)	
	            {
	                  j--;
	            }
	            if (i <= j) 
	            {								//Swap positions of data 
	                  tmp = arr[i][0];
	                  arr[i][0] = arr[j][0];
	                  arr[j][0] = tmp;
	                  
	                  tmp = arr[i][1];			//Swap positions of index 
	                  arr[i][1] = arr[j][1];
	                  arr[j][1] = tmp;
	                  
	                  i++;
	                  j--;
	            }
	      }
	      return i; //return index 
	}

	void quickSort(int arr[][], int left, int right) //QuickSort an Array with start and end index param 
	{
	      int index = getIndex(arr, left, right);
	      
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      
	      if (index < right)
	            quickSort(arr, index, right);

	}
	
	void inversionCounter(int a[][]) {
		  int i, j, temp;

		  for (i = 0; i < a.length-1; i++)
		  {
		    for (j = i + 1; j < a.length; j++)
		    {
		    	if (a[i][0] > a[j][0])
		    	{
		    		inversionCount++;
		    		
		    	}
		    }
		  }
		}
}
