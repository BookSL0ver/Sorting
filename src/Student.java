import java.util.ArrayList;

public class Student {
	private String name;
	private ArrayList<Integer> scores;
	
	public Student(String name)
	{
		this.name = name;
		scores = new ArrayList<Integer>();
	}
	
	public void addScore(Integer score)
	{
		scores.add(score);
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Integer> getScores()
	{
		return scores;
	}
	
	@Override
	public String toString()
	{
		String ret = name + ": ";
		for(int i = 0; i < scores.size(); i++)
		{
			ret += scores.get(i);
			if(i < scores.size() - 1)
				ret += ", ";
		}
		return ret;
	}
	
}
