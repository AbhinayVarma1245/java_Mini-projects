import java.io.*;
public class ReadingWriting{
	public static void main(String[] args){
		FileWriter Writer = new FileWriter("example.txt");
		Writer.Write("Hello, Guys");
		Writer.Close();
		FileReader reader=new FileReader("example.txt");
		int ch;
		while((ch=reader.Read())!= -1){
			System.out.println((char)ch);
		}
		reader.Close();
	}
}