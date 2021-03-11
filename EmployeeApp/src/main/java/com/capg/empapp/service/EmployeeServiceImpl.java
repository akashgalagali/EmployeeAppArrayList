 package com.capg.empapp.service;
import java.util.ArrayList;

import com.capg.empapp.dao.EmployeeDAOImpl;
import com.capg.empapp.dao.IEmployeeDAO;
import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.execptions.InvalidEmployeeIdExcption;
import com.capg.empapp.execptions.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
   // Animal a = new Dog();
	IEmployeeDAO dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		
			//System.out.println(" ------------>> inside service "+e);
		
			if(e.getSalary()> 50000)
			{
				throw new WrongSalaryException();
			}
			else return dao.addEmployee(e);		
		
	}

	public ArrayList<Employee> getAllEmployees() {

		return dao.getAllEmployees();
	}
	
	
	// ================================================================================

	public boolean editSalaryByEmployeeId(int id,int empNewSalary) throws InvalidEmployeeIdExcption {
		if(!dao.editSalaryByEmployeeId(id,empNewSalary))
		{
			throw new InvalidEmployeeIdExcption();
		}
		else return dao.editSalaryByEmployeeId(id,empNewSalary);
	}

	public boolean editExpByEmployeeId(int id,int empNewExp) throws InvalidEmployeeIdExcption {
		if(!dao.editExpByEmployeeId(id,empNewExp))
		{
			throw new InvalidEmployeeIdExcption();
		}
		else return dao.editExpByEmployeeId(id,empNewExp);
	}

	public ArrayList<Employee> getEmployeeBySalary(int salary) {
		// TODO Auto-generated method stub
		return dao.getEmployeeBySalary(salary);
	}

	public ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		// TODO Auto-generated method stub
		return dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}
