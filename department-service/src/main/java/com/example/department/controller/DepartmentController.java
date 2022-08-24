package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department)
    {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findByDepartmentId(@PathVariable("id") Long departmentID)
    {
        log.info("Inside findByDepartmentId method of DepartmentController");
        Department department1= departmentService.findByDepartmentId(departmentID);
        if(department1!= null)
        {
            return new ResponseEntity<Department>(department1,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Department>(department1,HttpStatus.NOT_FOUND);
        }
    }
}
