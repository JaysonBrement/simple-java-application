package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.entities.EmployeeEntity;
import com.springboot.service.EmployeeService;



@Controller
public class WelcomeController {

    private final EmployeeService employeeService;

    @Autowired
    public WelcomeController(EmployeeService employeeService) {

        this.employeeService = employeeService;

    }

    @GetMapping("/addForm")
    public String addForm(Model model) {

		model.addAttribute("employee", new EmployeeEntity()); 

        return "addEmployeeForm";

    }

    @PostMapping("/addForm")
    public String addEmployee(@ModelAttribute("employee") EmployeeEntity employee) {

        employeeService.saveEmployee(employee); 

        return "redirect:/employees"; 

    }
    
    @GetMapping("/employees")
    public String getEmployees(Model model) {

        List<EmployeeEntity> employees = employeeService.getEmployee();
        model.addAttribute("employees", employees); 

        return "EmployeeList";  

    }

    @GetMapping("/modify")
    public String modifyEmployeeById(@RequestParam Long id, Model model) {
        
        Optional<EmployeeEntity> employee = employeeService.getEmployeeById(id);
        if(employee.isPresent()){
            model.addAttribute("employee", employee.get());
        }else{
            model.addAttribute("employee", null);
        }
        
        return "modifyEmployeeForm";

    }

    @PostMapping("/modify")
    public String modifyEmployee(@RequestParam long id,EmployeeEntity employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";

    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam Long id) {

        employeeService.deleteEmployee(id);
        
        return "redirect:/employees";  

    }
    
}