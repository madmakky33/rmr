package com.pack1;

/*
 * Method overloading
 * 
 */


class A 
{
	void test()
	{
		System.out.println(1);
	}
	void test(int i)
	{
		System.out.println(2);
	}
	private void test(double d)
	{
		System.out.println(3);
	}
	public int test(boolean b)
	{
		System.out.println(4);
		return 200;
	}
}
public class Manager6
{
	public static void main(String[] args)
	{
		A a = new A();
		a.test();
		a.test(false);
		a.test(0);
		System.out.println(a.toString());
	}
}