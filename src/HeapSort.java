import java.util.ArrayList;

public class HeapSort <T extends Comparable<T>>{
	private ArrayList<T> items;
	private ArrayList<Student> students;
	
	public ArrayList<Student> sort(ArrayList<T> i, ArrayList<Student> st)
	{
		items = i;
		students = st;
		int sortIndex = 1;
		while(sortIndex < items.size())
		{
			addHelper(sortIndex);
			sortIndex++;
		}
		int sorted = items.size();
		while(sorted > 0)
		{
			sorted--;
			T temp = items.get(0);
			items.remove(0);
			items.add(sorted, temp);
			Student s = students.get(0);
			students.remove(0);
			students.add(sorted, s);
			if(sorted > 0)
			{
				temp = items.get(sorted - 1);
				items.remove(sorted - 1);
				items.add(0, temp);
				s = students.get(sorted - 1);
				students.remove(sorted - 1);
				students.add(0, s);
				removeHelper(0, sorted);
			}
		}
		return students;
	}
	
	public void addHelper(int index)
	{
		if(index < 1)
			return;
		else if(items.get(index).compareTo(items.get(index / 2)) > 0)		//current is greater than parent
		{	//swap, addHelper(index/2)
			swap(index, index / 2);
			addHelper(index / 2);
		}
	}
	
	public void removeHelper(int index, int sorted)
	{
		int leftChild = (getLeftChild(index + 1)) - 1;
		int rightChild = (getRightChild(index + 1)) - 1;
		if(leftChild >= sorted) {return;}
		else if(rightChild >= sorted)
		{
			if(items.get(leftChild).compareTo(items.get(index)) > 0)
			{
				swap(index, leftChild);
				removeHelper(leftChild, sorted);
			}
		}
		else
		{
			if(items.get(index).compareTo(items.get(leftChild)) > 0 && items.get(index).compareTo(items.get(rightChild)) > 0) {}
			else if((items.get(index).compareTo(items.get(leftChild)) < 0 || items.get(index).compareTo(items.get(rightChild)) < 0) && items.get(leftChild).compareTo(items.get(rightChild)) > 0)
			{
				swap(index, leftChild);
				removeHelper(leftChild, sorted);
			}
			else if((items.get(index).compareTo(items.get(leftChild)) < 0 || items.get(index).compareTo(items.get(rightChild)) < 0) && items.get(leftChild).compareTo(items.get(rightChild)) < 0)
			{
				swap(index, rightChild);
				removeHelper(rightChild, sorted);
			}
		}
	}
	
	public void swap(int index1, int index2)
	{
		T temp = items.get(index1);
		items.set(index1, items.get(index2));
		items.set(index2, temp);
		Student temp2 = students.get(index1);
		students.set(index1, students.get(index2));
		students.set(index2, temp2);
	}
	
	public int getLeftChild(int index)
	{
		return index * 2;
	}
	
	public int getRightChild(int index)
	{
		return index * 2 + 1;
	}

}
