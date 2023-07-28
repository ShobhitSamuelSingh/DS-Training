import java.io.*;
import java.util.ArrayList;
public class University {

	public static void main(String[] args)throws IOException
	{
		
		BufferedReader Br =  new BufferedReader(new InputStreamReader(System.in));
		
		College CollegeList[] = new College[5];
		
//		ArrayList<College> CollegeList = new ArrayList<College>();
		
		int i,c;
		
		CollegeList[0] = new College();
		CollegeList[1] = new College();
		CollegeList[2] = new College();
		CollegeList[3] = new College();
		CollegeList[4] = new College();

		for(i=0;i<5;++i)
		{
			c=i+1;
//			int[] arr; 
//			CollegeList.add(CollegeList[i]);
			CollegeList[i].setName("College "+ c);
			CollegeList[i].setAddress("Address "+ c);
			CollegeList[i].setTotalNoOfStudents(c*100);
			CollegeList[i].setNoOfDepartments(c+10);
			CollegeList[i].setNoOfAlumni(c*1000);
			CollegeList[i].setNoOfTeachers((c+10)*10);
		}
		
		
		
		
		while(true)
		{
			College ob = new College();
			System.out.println("1.Add College");
			System.out.println("2.Remove College");
			System.out.println("3.Replace College");
			System.out.println("4.Show College List");
			System.out.println("5.Exit");
			System.out.print("Enter Choice : ");

			c=Integer.parseInt(Br.readLine());
			
//			if(c==1) 
//			else 
			if(c==2) 
			{
				System.out.println("Enter College ID to be removed");
				int id=Integer.parseInt(Br.readLine());
				ob.remove(CollegeList,id);
			}
			else if(c==3)
			{
				System.out.println("Enter College ID to be replaced : ");
				i = Integer.parseInt(Br.readLine());
				CollegeList = ob.replace(CollegeList,i);
			}
			else if(c==4) ob.displayList(CollegeList);
			else if(c==5) break;
			else System.out.println("Wrong Choice");
			
		}

	}

}

class College{
	
	String Name;
	String Address;
	int totalNoOfStudents;
	int noOfDepartments;
	int noOfAlumni;
	int noOfTeachers;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getTotalNoOfStudents() {
		return totalNoOfStudents;
	}
	public void setTotalNoOfStudents(int totalNoOfStudents) {
		this.totalNoOfStudents = totalNoOfStudents;
	}
	public int getNoOfDepartments() {
		return noOfDepartments;
	}
	public void setNoOfDepartments(int noOfDepartments) {
		this.noOfDepartments = noOfDepartments;
	}
	public int getNoOfAlumni() {
		return noOfAlumni;
	}
	public void setNoOfAlumni(int noOfAlumni) {
		this.noOfAlumni = noOfAlumni;
	}
	public int getNoOfTeachers() {
		return noOfTeachers;
	}
	public void setNoOfTeachers(int noOfTeachers) {
		this.noOfTeachers = noOfTeachers;
	}
	
	
	void displayList(College[] CollegeList)
	{
		int i,c;
		for(i=0;i<5;++i)
		{
			c=i+1;
			System.out.println("COLLEGE "+ c+"\n");
			System.out.println("Name                   : " + CollegeList[i].getName());
			System.out.println("Address                : " + CollegeList[i].getAddress());
			System.out.println("Total No. of Students  : " + CollegeList[i].getTotalNoOfStudents());
			System.out.println("No. of Departments     : " + CollegeList[i].getNoOfDepartments());
			System.out.println("No. of Alumnis         : " + CollegeList[i].getNoOfAlumni());
			System.out.println("No. of of Teachers     : " + CollegeList[i].getNoOfTeachers());
			System.out.println("\n================================\n");

		}
		
	}
	
	void remove(College[] CollegeList,int i)
	{
		--i;
		CollegeList[i].setName(" ");
		CollegeList[i].setAddress(" ");
		CollegeList[i].setTotalNoOfStudents('\0');
		CollegeList[i].setNoOfDepartments('\0');
		CollegeList[i].setNoOfAlumni('\0');
		CollegeList[i].setNoOfTeachers('\0');
		System.out.println("\nCOLLEGE REMOVED\n");
	}
	
	
	College[] replace(College[] CollegeList,int i)throws IOException
	{
		--i;
		BufferedReader Br =  new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter New College Details\n");
		System.out.println("Name                   : " ); CollegeList[i].setName(Br.readLine());
		System.out.println("Address                : " ); CollegeList[i].setAddress(Br.readLine());
		System.out.println("Total No. of Students  : " ); CollegeList[i].setTotalNoOfStudents(Integer.parseInt(Br.readLine()));
		System.out.println("No. of Departments     : " ); CollegeList[i].setNoOfDepartments(Integer.parseInt(Br.readLine()));
		System.out.println("No. of Alumnis         : " ); CollegeList[i].setNoOfAlumni(Integer.parseInt(Br.readLine()));
		System.out.println("No. of of Teachers     : " ); CollegeList[i].setNoOfTeachers(Integer.parseInt(Br.readLine()));
		System.out.println("\nCOLLEGE REPLACED\n");		
		return CollegeList;
	}

	
}

