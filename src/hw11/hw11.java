package hw11;
import java.util.Random;

public class hw11 {
	public static void main(String[] args) {
		int[] arrayofNumbers=new int[10];
		Random r=new Random();
		for(int i=0; i<arrayofNumbers.length; i++) {
			int rando=r.nextInt(100);
			arrayofNumbers[i]=rando;
		}
		
		hw11.displayIntArray(arrayofNumbers);
		
		WorkerBee ogArray=new WorkerBee(arrayofNumbers);
		WorkerBee OneArray=ogArray.createOneArray();
		WorkerBee TwoArray=ogArray.createTwoArray();
		OneArray.start();
		TwoArray.start();
		
		try {
			OneArray.join();
			TwoArray.join();
			WorkerBee finalArray=ogArray.mergeArray(OneArray, TwoArray);
			WorkerBee.mergeSort(finalArray.getArray(), 0, finalArray.getArray().length-1);
			System.out.println();
			for (int element: finalArray.getArray()) {
				System.out.print(element+" ");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		static void displayIntArray(int[] ar) {
			for(int element : ar) {
				System.out.print(element + " ");
			}
		}
}
