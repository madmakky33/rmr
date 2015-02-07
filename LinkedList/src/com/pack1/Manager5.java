package com.pack1;

/*
 * 
 * construtor calling
 * 
 * 
 */
class Manager
{
	{
		System.out.println("DONE from IIB");
	}
	static
	{
		System.out.println("Done from SIB");
	}
	public Manager()
	{
		System.out.println("it is from Super class");		
	}
}
public class Manager5 extends Manager
{
	int i;
	public Manager5()
	{
		this(10);
		System.out.println("from Nor arg constructor");
	}
	public Manager5(int i)
	{
		super();
		this.i = i;
		System.out.println("from arg constructor");
	}
	public static void main(String[] args)
	{
		Manager5  m1 = new Manager5();
		System.out.println(m1.i);
		System.out.println("-------");
		Manager5  m2 = new Manager5(20);
		System.out.println("-------");
		System.out.println(m1.i);
		System.out.println(m2.i);
		
	}
}
