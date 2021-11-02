package com.careerdevs.intro.employees;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Map<Long, Employee> employees = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();
//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository) {
//        this.repository = repository;
//    }

    public EmployeeController() {
        Long id = idCounter.incrementAndGet();
        employees.put(id, new Employee(id, "Jim", "Semicolon finder", 25));
        id = idCounter.incrementAndGet();
        employees.put(id, new Employee(id, "Keith", "Comedian", 26));
    }


    //CRUD
    // Read - get one employee by id / get all employees

    @GetMapping
    public List<Employee> all() {
        return new ArrayList<Employee>(employees.values());
    }

    @GetMapping("/{id}")
    public Employee employee(@PathVariable Long id) {
        return employees.get(id);
    }

    // Create - create one employee
    @PostMapping
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        Long id = idCounter.incrementAndGet();
        newEmployee.setId(id);
        employees.put(id, newEmployee);
        return newEmployee;
    }


    // Update - update one employee by id - commonly authenticated
    // sometimes use PUT modern systems can use POST.
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updateData) throws IllegalAccessException {
        Employee emp = employees.get(id);

        if (emp == null) {
            return emp;
        }

        if(updateData.getName() != null) {
            emp.setName(updateData.getName());
        }
        if(updateData.getRole() != null) {
            emp.setRole(updateData.getRole());
        }
        if(updateData.getAge() != null) {
            emp.setAge(updateData.getAge());
        }

        return emp;
    }

    // Destroy - delete by employee by id.
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employees.remove(id);
    }

}
