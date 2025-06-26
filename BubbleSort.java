import java.util.Scanner;
public class BubbleSort {
	static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Number Of Elements are need to sort");
		int dig=input.nextInt();
        int[] arr=new int[dig];
		System.out.print("Enter the Elements");
		for(int i=0;i<dig;i++){
			arr[i]=input.nextInt();
		}
		System.out.println("Before Sorting");
		for(int num:arr)System.out.print(num+" ");
        bubbleSort(arr);
		System.out.println("\nAfter sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
