package com.qualitycoder.groupG;

import com.qualitycoder.groupG.domain.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by RasinduRoohansa on 07-05-2017.
 */
public class DataImporter {

	private final Logger logger = LogManager.getLogger(getClass());

	public ArrayList<Employee> importDataFileCSV(String fileName) {
		ArrayList<Employee> employeeList = new ArrayList();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				Employee employee = new Employee();
				String[] data = line.split(",");
				employee.setEmpId(!data[0].equals("Emp ID") ? data[0] : null);
				employee.setName(!data[1].equals("Name") ? data[1] : null);
				employee.setDesignation(!data[2].equals("Job Titles") ? data[2] : null);
				employee.setDob(!data[3].equals("Date of Birth") ? data[3] : null);
				employee.setGender(!data[4].equals("Gender") ? data[4].charAt(0) : null);
				employee.setBasicSalary(!data[5].equals("Basic Salary (LKR)") ? Double.parseDouble(data[5]) : null);
				employee.setEpfContribution(!data[6].equals("EPF Contribution") ? Double.parseDouble(data[6]) : null);
				employee.setPhoneNumber(!data[7].equals("Phone Number") ? data[7] : null);
				employee.setAddress(!data[8].equals("Address") ? data[8] : null);
				employeeList.add(employee);
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return employeeList;
	}


}
