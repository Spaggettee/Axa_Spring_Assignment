package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exceptions.EmployeeExistsException;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> retrieveEmployees();

    Employee getEmployee(Long employeeId) throws EmployeeNotFoundException;

    void saveEmployee(Employee employee) throws EmployeeExistsException;

    void deleteEmployee(Long employeeId) throws EmployeeNotFoundException;

    void updateEmployee(Employee employee) throws EmployeeNotFoundException;
}