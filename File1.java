import java.io.*;
public class File1{
	public static void main(String[] args){
		File myFile=new File("example.txt");
		if(myFile.exists()){
			System.out.println("File Exists"+myFile.getName());
		}
		else
		{
			System.out.println("File not Exists");
		}
	}
}