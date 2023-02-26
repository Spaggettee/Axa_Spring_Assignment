package jp.co.axa.apidemo.services;

import javassist.NotFoundException;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.aspectj.weaver.ast.Not;
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

    public Employee getEmployee(Long employeeId) {

        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
        System.out.println("Employee Saved Successfully");
    }

    public void deleteEmployee(Long employeeId) {

        employeeRepository.deleteById(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    public void updateEmployee(Employee employee) {

        employeeRepository.save(employee);
    }
}