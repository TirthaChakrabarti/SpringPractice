package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Employee;
import myconnections.MyConnection;

public class EmployeeDao {
	
	Connection myCon;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MyConnection mCon;
	
	public EmployeeDao() {
		mCon = new MyConnection();
	}
	
	public ArrayList <Employee> getEmployees(){
		
		myCon = mCon.getMyConection();
		ArrayList <Employee> employees = new ArrayList<Employee>();
		
		try {
			String query = "Select * from Employees";
			stmt = myCon.createStatement();
			rs = stmt.executeQuery(query);
			
			String eId, eName, eAddr, ePhone;
			float eTax;
			int eSal;
			
			while(rs.next()) {
				
				Employee emp = new Employee();
			
				eId = rs.getString(1);
				emp.setEmployeeId(eId);
				
				eName = rs.getString(2);
				emp.setEmployeeName(eName);
				
				eAddr = rs.getString(3);
				emp.setEmployeeAddress(eAddr);
				
				emp.setEmployeePhone(rs.getString(4));
				//we can directly get value within set method like this
				
				eSal = rs.getInt(5);
				emp.setEmployeeSalary(eSal);
					
				emp.setProfTax(rs.getFloat(6));
				//we can directly get value within set method like this
				
//				emp = new Employee(eId, eName, eAddr, ePhone, eSal, eTax);
//				We can also use this method to assign these values to create Employee object
				
				employees.add(emp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;	
	}
	
	public Employee getEmployeeById(String employeeId) {
		myCon = mCon.getMyConection();
		Employee emp = null;
		try {
			pstmt = myCon.prepareStatement("SELECT * FROM employees WHERE employeeId = ?");
			pstmt.setString(1, employeeId);
//			pstmt.setString(2, myvalue); [In case of multiple parameters like below query
//			select * from employees where employeeSalary>? and employeeAddress=?
			rs = pstmt.executeQuery();
			//If result has multiple values, we need while loop but here we don't need
			rs.next();
			String eId = rs.getString(1);
			String eName = rs.getString(2);
			String eAddr = rs.getString(3);
			String ePhone = rs.getString(4);
			int eSal = rs.getInt(5);
			float eTax = rs.getFloat(6);
			emp = new Employee(eId, eName, eAddr, ePhone, eSal, eTax);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public boolean insertEmployee(Employee employee) {
		boolean flag = false;
		myCon = mCon.getMyConection();
		String query = "insert into employees values(?,?,?,?,?,?)";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setString(3, employee.getEmployeeAddress());
			pstmt.setString(4, employee.getEmployeePhone());
			pstmt.setInt(5, employee.getEmployeeSalary());
			pstmt.setDouble(6, employee.getProfTax());
			
			pstmt.execute();
//			or pstmt.executeUpdate();
			
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateEmployee(Employee employee) {
		boolean flag = false;
		myCon = mCon.getMyConection();
		String query = "update Employees set employeeAddress=? where employeeId=?";
		try {
			pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employee.getEmployeeAddress());
			pstmt.setString(2, employee.getEmployeeId());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean deleteEmployeeById(String employeeId) {
		boolean flag = false;
		myCon = mCon.getMyConection();
		String query = "Delete from Employees where employeeId=?";
		try {
			PreparedStatement pstmt = myCon.prepareStatement(query);
			pstmt.setString(1, employeeId);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
