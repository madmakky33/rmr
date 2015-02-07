package com.pack1;

import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args)
	{
		int all[] = {1,10,11,25,9,5,3};
		for(int i=0;i<all.length;i++)
		{
			for(int j=i+1;j<all.length;j++)
			{
				if(all[i]>all[j])
				{
					int temp = 0;
					temp = all[i];
					all[i] = all[j];
					all[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(all));
	}
}
