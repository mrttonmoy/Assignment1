import java.io.PrintWriter; 
import java.util.Scanner;
import java.io.File;
import java.io.*;
// * @author (Tonmoy) 
// * @version (13/10/16)
public class Student {
	Scanner input = new Scanner(System.in);
	
    int Id;
    String Name;
    String Department ;
    String University ;
    double[] GPA = new double[8];
    double[][] CRnGR = new double[10][2];
    String sub1,sub2,sub3,sub4,sub5,sub6;
    double CGPA;
    
    public Student(int _Id,String _Name,String _Department,String _University)
    {
        Id =_Id;
        Name = _Name;
        Department =_Department;
        University =_University ;
    }
    
    
    public void studentCGPAnGPA()
    {
    	for(int i=0;i<1;i++)
    	{
    		for(int j=0;j<10;j++)
    		{
    			System.out.print("Enter Credit : ");
    			CRnGR[i][j]=input.nextDouble();
    			System.out.print("Enter Grade : ");
    			CRnGR[i+1][j]=input.nextDouble();
    		}
    	}    		
    }
    
 
    public void setGPA()
    {
    	for(int i=0;i<8;i++)
    	{
    		System.out.print("Enter the GPA of Semister " + (i+1) +" : ");
    		GPA[i]=input.nextDouble();
    	}
    }
    
    // Define a method to compute the GPA from the given Credits and Grades of all the subjects
    public double computeGPAById()
    {
     
    	double gpa =0;
    	double total = 0;
    	for(int i=0;i<1;i++)
    		for(int j=0;j<10;j++)
    		{
    			gpa+=CRnGR[i][j]*CRnGR[i+1][j];
    			total += CRnGR[i][j];
    		}
    	gpa = gpa / total;
    	return gpa;
    }
    
    //Method to compute CGPA
    public double computeCGPAByID()
    {
        // Write your code here
    	double cgpa = 0;
    	int count = 0;
    	for(int i=0;i<8;i++)
    	{
    		if(GPA[i] == 0)	continue;
    		count++;
    		cgpa+=GPA[i];
    	}
    	cgpa/=count;
    	CGPA = cgpa;
    	return cgpa;
    }
    
    
    //Define a method to print the students details.
    public void studentDetailsById()
    {
    
    	System.out.println("Name  : "+Name);
    	System.out.println("ID  : " + Id);
    	System.out.println("Department  : " + Department);
    	System.out.println("University  : " + University);
    	System.out.println("Current CGPA  : " + CGPA); 	
    }
    
    
    //method to update information of students
    public void updateStudentById()
    {
        //Write your code here
    	System.out.print("Enter Name : ");
    	Name = input.nextLine();
    	System.out.print("Enter Department : ");
    	Department = input.nextLine();
    	System.out.print("Enter University : ");
    	University = input.nextLine();    	
    }
    
    
    public void saveStudent() 
    {
        try{
            File outputFile = new File("info.txt");
            PrintWriter writer = new PrintWriter(outputFile);
            
            writer.println("Name  : "+Name);
        	writer.println("ID  : " + Id);
        	writer.println("Department  : " + Department);
        	writer.println("University  : " + University);
        	writer.println("Current CGPA  : " + CGPA); 	
            
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
   
   
    public static void main(String[] args)
    {   
    	Student[] students = new Student[50];
    	students[0] = new Student(1407022,"Tonmoy","CSE","KUET");
    	
    	students[0].studentDetailsById();
    	students[0].saveStudent();
    }
}