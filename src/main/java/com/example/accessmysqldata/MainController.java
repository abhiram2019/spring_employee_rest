package com.example.accessmysqldata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/factory")
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path="/addemployee")
    public @ResponseBody String addNewEmployee (@RequestParam String name, String email, String address, Integer phone){
        Employee emp = new Employee();
        emp.setEmpName(name);
        emp.setEmpEmail(email);
        emp.setEmpAddress(address);
        emp.setEmpPhone(phone);
        employeeRepository.save(emp);
        return "Data committed";
    }

    @GetMapping(path="/showdetails")
    public @ResponseBody Iterable<Employee> getAllUsers(){
        return employeeRepository.findAll();
    }
}
