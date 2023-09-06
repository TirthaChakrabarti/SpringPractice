package service;

import java.util.ArrayList;

import dao.EmployeeDao;
import model.Employee;

public class EmployeeService {
	
	EmployeeDao eDao;
	
	public EmployeeService() {
		eDao = new EmployeeDao();
	}
	
	public ArrayList <Employee> getEmployeesSVC(){
		return eDao.getEmployees();
	}
	
	public Employee getEmployeeById(String eId) {
		return eDao.getEmployeeById(eId);
	}
	
	public boolean insertEmployeeSVC(Employee employee) {
		return eDao.insertEmployee(employee);
	}
	
	public boolean updateEmployeeSVC(Employee employee) {
		return eDao.updateEmployee(employee);
	}
	
	public boolean deleteEmployeeByIdSVC(String employeeId) {
		return eDao.deleteEmployeeById(employeeId);
	}
}
