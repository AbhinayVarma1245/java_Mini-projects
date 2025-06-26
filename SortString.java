import java.util.Arrays;
public class SortString {
    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "orange", "mango", "grape"};
        Arrays.sort(arr);
        for (String str : arr) {
            System.out.print(str + " ");
        }
    }
}
