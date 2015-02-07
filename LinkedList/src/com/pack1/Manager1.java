package com.pack1;

import java.util.Scanner;

public class Manager1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);		
		String decider = "";
		LinkedList list = new LinkedList();
		System.out.println("DO YOU WANT TO ADD SOME VALUES");
		decider = sc.next();
		while("y".equals(decider)||"Y".equals(decider))
		{
			System.out.println("PLZ ENTER SOME VALUES:");
			Object data = sc.next();
			try
			{
				list.addElement(data);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("DO YOU WANT TO ADD SOME MORE VALUES, please enter your choice 'y' or 'n'");
			decider =sc.next();
		}
		System.out.println("---------Values in LinkedList--------");
		list.iterate(list);
		
	}
}
