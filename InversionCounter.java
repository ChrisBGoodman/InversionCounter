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
	public int[][] tempArray = new int[10000][2];
	public int[][] sum = new int[10000][2];
	public int[][] sortedSum = new int[10000][2];
	public int[] count = new int[10000];
	public int inversionCount  = 0;
	public int inversionCount1 = 0;
	public int inversionCount2 = 0;
	public int inversionCount3 = 0;
	public int inversionCount4 = 0;
	public int inversionCount5 = 0;


	
	
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
	
	
	do{	
	getSum();			//Get sum of each source ranking and create a new array with the data of Summation 
	quickSort(sum, 0, source1.length - 1);
	
	inversionCount = 0;							//Reset inversion counter
	reIndex(source1);							//ReIndex Source file
	source1 = tempArray;						//copy the array used while reindexing source file
	quickSort(source1, 0, source1.length - 1);	//quickSort reIndexed source file 
	inversionCount1 = inversionCount;			//set inversions for source 
												//repeat for all sources
	inversionCount = 0;							
	reIndex(source2);							
	source2 = tempArray;						
	quickSort(source2, 0, source2.length - 1);	 
	inversionCount2 = inversionCount;			
												
	inversionCount = 0;							
	reIndex(source3);							
	source3 = tempArray;						
	quickSort(source3, 0, source3.length - 1);	
	inversionCount3 = inversionCount;			
												
	inversionCount = 0;							
	reIndex(source4);							
	source4 = tempArray;						
	quickSort(source4, 0, source4.length - 1);	
	inversionCount4 = inversionCount;			
												
	inversionCount = 0;							
	reIndex(source5);							
	source5 = tempArray;						
	quickSort(source5, 0, source5.length - 1);	
	inversionCount5 = inversionCount;	
	System.out.println("Inversions: " + inversionCount1 + " " + inversionCount2+ " " + inversionCount3
			+ " " + inversionCount4 + " " + inversionCount5);
	}while(inversionCount1 > 25000);
												
	


	
	
	for (int i = 0; i < 10000; i++)
	{
		
		//System.out.println(sum[i][0] + " ");
		//System.out.print(" ========  ");
		//System.out.println(sum[i][1]);
		//System.out.println(source1[i][0] + " ");
		//System.out.println(source1[i][1]);
		//System.out.print(tempArray[i][0] + " ");
		//System.out.println(tempArray[i][1]);
		
		
		
	}
	
	System.out.println("Inversions: " + inversionCount1 + " " + inversionCount2+ " " + inversionCount3
			+ " " + inversionCount4 + " " + inversionCount5);
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
			sum[i][0] = source1[i][0] * (1/1 + inversionCount1)  + source2[i][0]* (1/1 + inversionCount2)  
					+ source3[i][0] * (1/1 + inversionCount3)  + source4[i][0] * (1/1 + inversionCount4)
							+ source5[i][0] * (1/1 + inversionCount5);
			sum[i][1] = i;
			
		}
	}
//-------------------------------------------------------------------------------------
	
	public static void MergeSort()
	{
		
	}
	
	public void reIndex(int s[][])
	{
		int source = 0;
		int index = 0;
		int temp = 0;
		int i = 0;
		boolean found = false;
		
		for (int x = 0; x < sum.length - 1; x++) //loop thru entire sum array
		{
			found = false;
			index = sum[x][1];
			i = 0;
			
			do
			{
				if (index == s[i][1])				//when index found in source file
				{
					tempArray[x][0] = s[i][0];	//move index to temp array 
					tempArray[x][1] = s[i][1];
					found = true; 
				}
				i++;
			}while( found == false && i < 10000-1);
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
	                  
	                  inversionCount++;
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
