import java.io.File;
import java.util.Scanner;
class Scanner1{
	public static void main(String[] args){
		Scanner sc = new Scanner(new File("example.txt"));
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}