package client;

import java.sql.Connection;	
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Employee;
import service.EmployeeService;

public class EmployeeDBManager {
	
	Connection mycon;
	Statement stmt;
	ResultSet rs;
	String reply = "yes";
	
	Scanner scan = new Scanner(System.in);
	int choice;
	EmployeeService eService;
	
	public EmployeeDBManager() {
		eService = new EmployeeService();
	}
	
	public void displayMenu() {
		
		while((reply.equals("yes")) || (reply.equals("Yes"))){
			System.out.println("----Main Menu----");
			
			System.out.println("1. View employee");
			System.out.println("2. View employee by ID");
			System.out.println("3. Insert employee");
			System.out.println("4. Update employee");
			System.out.println("5. Delete employee");
			System.out.println("6. Exit application");
			
			System.out.println("Enter your choice: ");
		
			choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:{
					System.out.println("Viewing employees...");
					ArrayList <Employee> employees = eService.getEmployeesSVC();
					Iterator <Employee> eIter = employees.iterator();
					System.out.println("The employees are...");
					while(eIter.hasNext()) {
						Employee e = eIter.next();
						System.out.println(e);
					}
					break;
				}
				
				case 2:{
					System.out.println("Viewing employee by ID...");
					String employeeId;
					System.out.println("Enter the employee Id  of the employee whose record you wish to see");
					employeeId = scan.next();
					Employee employee = eService.getEmployeeById(employeeId);
					System.out.println(employee);
					break;
				}
				
				case 3:{
					System.out.println("Inserting employee...");
					Employee employee = new Employee();
					//Accept employee details from user
					String eId, eName, eAddr, ePhone;
					int eSal;
					float eTax;
					
					System.out.println("Enter the Employee Id");
					eId = scan.next();
					
					System.out.println("Enter the Employee name");
					eName = scan.next();
					
					System.out.println("Enter the Employee address");
					eAddr = scan.next();
					
					System.out.println("Enter the Employee phone");
					ePhone = scan.next();
					
					System.out.println("Enter the Employee salary");
					eSal = scan.nextInt();
					
					System.out.println("Enter the tax liability for the Employee");
					eTax = scan.nextFloat();
					
					employee = new Employee(eId, eName, eAddr, ePhone, eSal, eTax);
					if(eService.insertEmployeeSVC(employee)) {
						System.out.println("Employee record inserted successfully");
					}
					else {
						System.out.println("Employee insertion failed...");
					}
					break;
				}
				
				case 4:{
					System.out.println("Updating employee...");
					String empId, empAddress;
					System.out.println("Enter the EmployeeId of the Employee whose Address you wish to change");
					empId = scan.next();
					Employee employee = eService.getEmployeeById(empId);
					System.out.println("The Employee record for the given Id is ");
					System.out.println(employee);
					System.out.println("Enter the new address for this employee that is to be updated");
					empAddress = scan.next();
					employee.setEmployeeAddress(empAddress);
					if(eService.updateEmployeeSVC(employee)) {
						System.out.println("Updation successful for that employee ");
					}
					else {
						System.out.println("Sorry updation failed...");
					}
					break;
				}
				
				case 5:{
					System.out.println("Deleting employee by ID...");
					String empId;
					System.out.println("Enter Id of the Employee whose redord you wish to delete");
					empId = scan.next();
					if(eService.deleteEmployeeByIdSVC(empId)) {
						System.out.println("The Employee record successfully deleted for the employee with employeeId "+empId);
					}
					else {
						System.out.println("Sorry! Deletion failed");
					}
					break;
				}
				
				case 6:{
					System.out.println("Exiting application...");
					System.exit(0);
					break;
				}
				
				default:{
					System.out.println("Sorry allowed options are 1-6");
					break;
				}
			}
			
			System.out.println("Do you wish to continue? Yes/No");
			reply = scan.next();
		}
	}
}
