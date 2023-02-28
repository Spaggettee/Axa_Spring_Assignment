package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.EmployeeEntity;
import jp.co.axa.apidemo.exceptions.EmployeeExistsException;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable(name="employeeId")Long employeeId) throws EmployeeNotFoundException {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public void saveEmployee(EmployeeEntity employeeEntity) throws EmployeeExistsException {
        employeeService.saveEmployee(employeeEntity);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@RequestBody EmployeeEntity employeeEntity,
                               @PathVariable(name="employeeId")Long employeeId) throws EmployeeNotFoundException{
        employeeService.updateEmployee(employeeEntity);
    }

}
