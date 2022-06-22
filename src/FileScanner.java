import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileScanner {
	private ArrayList<String> lines;
	
	public void scan()
	{
		lines = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String fileName = in.nextLine();
		try
		{
			File file = new File(fileName);
			Scanner f = new Scanner(file);
			while(f.hasNextLine())
			{
				lines.add(f.nextLine());
			}
			f.close();
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Invalid file name.");
			scan();
		}
	}
	
	public ArrayList<Student> getInfo()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		for(int i = 0; i < lines.size(); i++)
		{
			String line = lines.get(i);
			String name = line.substring(0, line.indexOf(":"));
			line = line.substring(line.indexOf(":") + 1).trim();
			String[] scores = line.split(",");
			Student temp = new Student(name);
			for(int j = 0; j < scores.length; j++)
			{
				temp.addScore(Integer.parseInt(scores[j].trim()));
			}
			students.add(temp);
		}
		return students;
	}

}
