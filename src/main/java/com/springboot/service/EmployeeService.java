    package com.springboot.service;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.springboot.model.entities.EmployeeEntity;
    import com.springboot.repo.EmployeeRepo;
    @Service
    public class EmployeeService {
        private final EmployeeRepo employeeRepo;

        @Autowired
        public EmployeeService(EmployeeRepo employeeRepo) {
            this.employeeRepo = employeeRepo;
        }
        public List<EmployeeEntity> getEmployee() {
            return employeeRepo.findAll();
        }
        public Optional<EmployeeEntity> getEmployeeById(Long id) {
            return employeeRepo.findById(id);
        }
        public void deleteEmployee(Long id){
            employeeRepo.deleteById(id);
        }
        public void saveEmployee(EmployeeEntity employee){
            employeeRepo.save(employee);
        }

    }