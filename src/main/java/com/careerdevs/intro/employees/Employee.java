package com.careerdevs.intro.employees;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Field;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private Integer age;

    public Employee() {}

    public Employee(String name, String role, Integer age) {
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public Employee(Long id, String name, String role, Integer age) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return String.format("Employee(id=%s, name=%s, role=%s, age=%s)", id, name, role, age);
    }
}
