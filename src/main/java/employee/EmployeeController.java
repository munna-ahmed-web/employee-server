package employee;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeRepository repository;
    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }


    @GetMapping("/")
    String home(){
        return "Hey !!! This is home route created by Spring Boot";
    }

    @GetMapping("employee")
    List<EmployeeData> getData(){
        return repository.findAll();
    }

    @GetMapping("/employee/{id}")
    Optional<EmployeeData> getOneEmploye(@PathVariable Long id) {
        return repository.findById(id);
    }


    @PostMapping("/employee")
    EmployeeData savetoDataBase( @RequestBody EmployeeData newEmployee ){
        return repository.save(newEmployee);
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }


}
