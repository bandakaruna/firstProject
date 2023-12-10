package com.ihub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp
{
      public static void main(String[] args)throws Exception
      {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student no");
		int no=sc.nextInt();
		System.out.println("enter the student name");
		String name=sc.next();
		System.out.println("enter the student address");
		String add=sc.next();

		name="'"+name+"'";
		add="'"+add+"'";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");

		Statement st=con.createStatement();

		String qry="insert into student values("+no+","+name+","+add+")";

		int result=st.executeUpdate(qry);

		if(result==0)

			System.out.println("no record inserted");
		else
			System.out.println(result+"record inserted");

		st.close();
		con.close();
				}
}
