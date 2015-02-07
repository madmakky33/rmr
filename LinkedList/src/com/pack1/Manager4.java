package com.pack1;

public class Manager4
{
	public static void main(String[] args)
	{
		Thread t = new Thread()
		{
			public void run()
			{
				System.out.println("this is start");
			}
		};
		t.start();
	}
}