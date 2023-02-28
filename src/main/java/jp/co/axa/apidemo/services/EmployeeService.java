package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.EmployeeEntity;
import jp.co.axa.apidemo.exceptions.EmployeeExistsException;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> retrieveEmployees();

    EmployeeEntity getEmployee(Long employeeId) throws EmployeeNotFoundException;

    void saveEmployee(EmployeeEntity employeeEntity) throws EmployeeExistsException;

    void deleteEmployee(Long employeeId) throws EmployeeNotFoundException;

    void updateEmployee(EmployeeEntity employeeEntity) throws EmployeeNotFoundException;
}