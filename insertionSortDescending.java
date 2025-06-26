import java.util.Scanner;
public class InsertionSortDescending {
    static void insertionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
        insertionSortDescending(arr);
		System.out.println("\nAfter sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
