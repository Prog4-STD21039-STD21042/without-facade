package com.example.prog4.repository.main;

import com.example.prog4.repository.main.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface MainEmployeeRepository {
    Employee findById(String id);

    Employee save(Employee toSave);
}
