package com.pack1;

public class LinkedList 
{
	class Element
	{
		Object data;
		Element next;
		Element(Object data)
		{
			this.data = data;
		}
	}
	Element front, back;
	boolean flag = false;
	public boolean addElement(Object data)throws Exception
	{
		Element e = new Element(data);
		if(e!=null)
		{
			
			if(front==null)
			{
				front = e;
			}
			else 
			{
				back.next = e;
			}
			flag = true;
			back = e;
		}
		else
		{
			throw  new LinkedListException();
		}
		return flag;
	}
	public int iterate(LinkedList list)
	{
		int i=0;
		do
		{
			if(list.front!=null)
			{
				System.out.println(front.data);
				front = front.next;
				i++;
			}
			else
			{
				if(i==0)
				{
					System.out.println("List is empty");
				}
				break;
			}
		}
		while(true);
		return i;
	}
	class LinkedListException extends Exception
	{
		public LinkedListException()
		{
			new Exception();
		}
	}
}