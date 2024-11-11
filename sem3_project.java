import java.util.Scanner;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class sem3_project {
	public static void main(String[] args)
	{	int n=0;
		int i=0;
		System.out.println("1.SIGNUP\n2.LOGIN \n3.CHANGE PASSWORD\n4.EXIT");
		System.out.println("enter choice:");
		Scanner sc=new Scanner(System.in);
		Hashtable<String,String>h=new Hashtable<>();
		
		
		int c=sc.nextInt();
		if(c==1) {
		try{

			File f2=new File("demo.txt");
			
			long y=f2.length();
		if(y==0)
		{ 
			System.out.println("Enter usename:");
			String s=sc.next();
			
			System.out.println("Enter password:");
			String p=sc.next();
			
			if(p.length()>=6) {
			System.out.println("Confirm Password:");
			String p1=sc.next();
			
			
			
			
try {
				if(p.equals(p1)) {
				Hashtable<String, String>table1=new Hashtable<String,String>();
				
				table1.put(s,p);
				
				FileOutputStream fos = new FileOutputStream("demo.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				
				oos.writeObject(table1);
				System.out.println("Signup Successful!");
				oos.close();
				fos.close();

			}
				else
				{
				System.out.println("Passwords should be same");

				}
			}
		
			catch(Exception e)
			{
				System.out.println("Error!");
			}
			}
			else {
				System.out.println("Password should be atleast 6 characters");
			}
			
		}
		else
		{

			
try{
				FileInputStream f1=new FileInputStream("demo.txt");
			
			ObjectInputStream b1=new ObjectInputStream(f1);
			Object obj2=b1.readObject();
			
		
			h=(Hashtable<String, String>)obj2;
			System.out.println("Enter usename:");
			String s1=sc.next();
			
			System.out.println("Enter password:");
			String pp=sc.next();
			if((pp.length())>=6) {
			System.out.println("Confirm Password:");
			String p0=sc.next();
			if(pp.equals(p0)) {
			h.put(s1, p0);

			Hashtable<String, String>table1=new Hashtable<String,String>();
			
			
			FileOutputStream fos1 = new FileOutputStream("demo.txt");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			
			
			oos1.writeObject(h);
			System.out.println("Signup Successful!");
			oos1.close();
			fos1.close();
			}
			else {
				System.out.println("Passwords should be same");
			}

			}
			
			else {
				System.out.println("Password should be atleast 6 characters");
			}
			}
			catch(Exception e3)
			{
				System.out.println("Error!");
			}
		}
		}
		catch(Exception e4)
		{
			System.out.println("Error!");
		}
			
		}
	
		if(c==2)
		{
			System.out.println("Enter usename:");
			String lo=sc.next();
			System.out.println("Enter password:");
			String p3=sc.next();
			try
			{	String str=null;
				Hashtable<String, String>h2=new Hashtable<String,String>();
				FileInputStream reader=new FileInputStream("demo.txt");
				ObjectInputStream buffer=new ObjectInputStream(reader);
				Object obj=buffer.readObject();

					
				h2=(Hashtable<String, String>)obj;
				while(i<3){;
				if(h2.get(lo).equals(p3))
					{System.out.println("Login Successful");
					break;}
				else {
					System.out.println("Incorrect password!");
					System.out.println("Try again");
					System.out.println("Enter password:");
					String p4=sc.next();
					p3=p4;
					}
					i++;
				}
				buffer.close();
				reader.close();
				
				if(i==3)
				{
					h2.remove(lo);
					System.out.println("***Account deleted***");
					Hashtable<String, String>table2=new Hashtable<String,String>();
					
		
					FileOutputStream fos3 = new FileOutputStream("demo.txt");
					ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
					oos3.writeObject(h2);
					oos3.close();
					fos3.close();
				}	
			}
			catch(Exception e1)
			{
				System.out.println("Username doesn't exist" );
			}
		}
		if(c==3)
		{
			System.out.println("Enter usename:");
			String l2=sc.next();
			System.out.println("Enter old password:");
			String p4=sc.next();
			try
			{	String str=null;
				Hashtable<String, String>h3=new Hashtable<String,String>();
				FileInputStream reader=new FileInputStream("demo.txt");
				ObjectInputStream buffer=new ObjectInputStream(reader);
				Object obj2=buffer.readObject();
				
				h3=(Hashtable<String, String>)obj2;
				System.out.println("Enter new password:");
				String np=sc.next();
				if(np.length()>=6) {
				if(h3.get(l2).equals(p4)) {
				h3.remove(l2);
				h3.put(l2, np);
				System.out.println("Password changed succesfully!");
				}
				else {
					System.out.println("Incorrect old password");
				}
				Hashtable<String, String>table1=new Hashtable<String,String>();
				
	
				FileOutputStream fos2 = new FileOutputStream("demo.txt");
				ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
				oos2.writeObject(h3);
				oos2.close();
				fos2.close();

			}
				

else {
System.out.println("Password should be atleast 6 characters");
				}
			}
			catch(Exception e4)
			{
				e4.printStackTrace();
			}
		}
		if(c==4)
		{
			System.out.println("Successful Exit");
		}
		}
	}



