package com.example.prog4.repository.main;

import com.example.prog4.model.exception.NotFoundException;
import com.example.prog4.repository.cnaps.CnapsEmployeeRepository;
import com.example.prog4.repository.cnaps.entity.CnapsEmployee;
import com.example.prog4.repository.main.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class MainEmployeeRepositoryImpl implements MainEmployeeRepository{
    private EmployeeRepository mainEmployeeRepository;
    private CnapsEmployeeRepository cnapsEmployeeRepository;
    @Override
    public Employee findById(String employeeId) {
        Optional<Employee> main = Optional.ofNullable(mainEmployeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee with id " + employeeId + " not found")));

        Optional<CnapsEmployee> cnapsEmployee = cnapsEmployeeRepository.findByEndToEndId(employeeId);

        cnapsEmployee.ifPresent(employee -> main.get().setCnaps(employee.getCnapsNumber()));
        return main.get();
    }

    @Override
    public Employee save(Employee toSave) {
        return mainEmployeeRepository.save(toSave);
    }
}
