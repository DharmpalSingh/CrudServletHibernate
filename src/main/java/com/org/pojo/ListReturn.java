package com.org.pojo;

import java.util.ArrayList;

public  class ListReturn {
	
	private static ArrayList<Employee> list = new ArrayList<Employee>();
	public static ArrayList<Employee> getList()
	{
	return list;	
		}

}
