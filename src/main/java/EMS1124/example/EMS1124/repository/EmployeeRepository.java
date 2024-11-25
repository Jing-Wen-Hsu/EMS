package EMS1124.example.EMS1124.repository;

import EMS1124.example.EMS1124.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
}
