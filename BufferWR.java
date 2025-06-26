import java.io.*;
class BufferWR{
	public static void main(String[] args){
		BufferedWriter bw=new BufferedWriter(new FileWriter("example.txt"));
		bw.write("First line");
		bw.newLine();
		bw.write("Second line");
		bw.close();
		BufferedReader br=new BufferedReader(new FileReader("example.txt"));
		String line;
		while((line=br.readLine())!= null){
			System.out.println(line);
		}
		br.close();
	}
}
