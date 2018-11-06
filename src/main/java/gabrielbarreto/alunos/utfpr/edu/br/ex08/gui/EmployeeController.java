package gabrielbarreto.alunos.utfpr.edu.br.ex08.gui;

import gabrielbarreto.alunos.utfpr.edu.br.ex08.dao.EmployeeDao;
import gabrielbarreto.alunos.utfpr.edu.br.ex08.entity.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeDao employeeDao;

    EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> all() {
        return employeeDao.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeDao.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeDao.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setAge(newEmployee.getAge());
                    employee.setSalary(newEmployee.getSalary());
                    return employeeDao.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeDao.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeDao.deleteById(id);
    }

}
