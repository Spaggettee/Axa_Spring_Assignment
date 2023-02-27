package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exceptions.EmployeeExistsException;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    static String employeeNotFound = "Employee Not Found";

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployee(Long employeeId) throws EmployeeNotFoundException {
        return this.findEmployee(employeeId);
    }

    public void saveEmployee(Employee employee) throws EmployeeExistsException {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());
        if (existingEmployee.isPresent()) {
            throw new EmployeeExistsException();
        }

        employeeRepository.save(employee);
        System.out.println("Employee Saved Successfully");
    }

    public void deleteEmployee(Long employeeId) {
        this.findEmployee(employeeId);

        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        Employee existingEmployee = this.findEmployee(employee.getId());

        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());

        employeeRepository.save(employee);
    }

    public Employee findEmployee(Long employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException();
        }
        return employee.get();
    }
}