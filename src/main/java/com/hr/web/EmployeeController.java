package com.hr.web;


//import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.entity.Employee;
import com.hr.service.EmployeeService;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
	

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@InitBinder
    //public void setAllowedFields(WebDataBinder dataBinder) {
    //    dataBinder.setDisallowedFields("id");
    //}

    @RequestMapping(value = "/employees/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Employee employee = new Employee();
        model.put("employee", employee);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/employees/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            this.employeeService.saveEmployee(employee);
            return "redirect:/employees/" + employee.getEmpNo();
        }
    }

    @RequestMapping(value = "/employees/find", method = RequestMethod.GET)
    public String initFindForm(Map<String, Object> model) {
        model.put("employee", new Employee());
        return "employees/findEmployees";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String processFindForm(Employee employee, BindingResult result, Map<Integer, Object> model) {

        // find employee by emp_no
         Employee results = this.employeeService.findEmployeeByEmpNo(employee.getEmpNo());
        if (results == null) {
            // no employees found
            result.rejectValue("empNo", "notFound", "not found");
            return "employees/findEmployees";
        } else {
            return "redirect:/employees/" + employee.getEmpNo();
        } 
    }

    @RequestMapping("/employees/{empNo}")
    public ModelAndView showEmployee(@PathVariable("empNo") int empNo) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.employeeService.findEmployeeByEmpNo(empNo));
        return mav;
    }

}
