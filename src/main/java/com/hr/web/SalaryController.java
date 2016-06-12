package com.hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.hr.entity.Employee;
import com.hr.entity.Salary;
import com.hr.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//import java.util.Collection;


@Controller
@RequestMapping("/employees/{empNo}")
public class SalaryController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final EmployeeService employeeService;

    @Autowired
    public SalaryController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("employee")
    public Employee findEmployee(@PathVariable("empNo") int empNo) {
        return this.employeeService.findEmployeeByEmpNo(empNo);
    }

    //@InitBinder("owner")
    //public void initOwnerBinder(WebDataBinder dataBinder) {
      //  dataBinder.setDisallowedFields("id");
   //}

    //@InitBinder("pet")
    //public void initPetBinder(WebDataBinder dataBinder) {
    //    dataBinder.setValidator(new PetValidator());
    //}

    @RequestMapping(value = "/salaries/new", method = RequestMethod.GET)
    public String initCreationForm(Employee employee, ModelMap model) {
        Salary salary = new Salary();
        employee.addSalary(salary);
        model.put("salary", salary);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/salaries/new", method = RequestMethod.POST)
    public String processCreationForm(Employee employee, @Valid Salary salary, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("salary", salary);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            employee.addSalary(salary);
            this.employeeService.saveSalary(salary);
            return "redirect:/employees/{empNo}";
        }
    }

}
