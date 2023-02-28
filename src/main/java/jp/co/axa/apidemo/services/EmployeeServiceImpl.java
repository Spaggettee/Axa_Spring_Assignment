package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.EmployeeEntity;
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

    public List<EmployeeEntity> retrieveEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities;
    }

    public EmployeeEntity getEmployee(Long employeeId) throws EmployeeNotFoundException {
        return this.findEmployee(employeeId);
    }

    public void saveEmployee(EmployeeEntity employeeEntity) throws EmployeeExistsException {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(employeeEntity.getId());
        if (existingEmployee.isPresent()) {
            throw new EmployeeExistsException();
        }

        employeeRepository.save(employeeEntity);
        System.out.println("Employee Saved Successfully");
    }

    public void deleteEmployee(Long employeeId) {
        this.findEmployee(employeeId);

        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(EmployeeEntity employeeEntity) {
        EmployeeEntity existingEmployee = this.findEmployee(employeeEntity.getId());

        existingEmployee.setDepartment(employeeEntity.getDepartment());
        existingEmployee.setName(employeeEntity.getName());
        existingEmployee.setSalary(employeeEntity.getSalary());

        employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity findEmployee(Long employeeId) throws EmployeeNotFoundException {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException();
        }
        return employee.get();
    }
}