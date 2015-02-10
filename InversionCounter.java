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
	
	public static void QuickSort()
	{
		
	}
}
