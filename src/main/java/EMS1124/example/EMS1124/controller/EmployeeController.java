package EMS1124.example.EMS1124.controller;

import EMS1124.example.EMS1124.entity.Employee;
import EMS1124.example.EMS1124.response.EmployeeResponse;
import EMS1124.example.EMS1124.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 新增員工
    @PostMapping("/")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody  Employee employee){

        String createResult = employeeService.addEmployee(employee);
        return ResponseEntity.ok(createResult);
    }

    // 刪除員工
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("employeeId") Long employeeId){
        String deleteResult = employeeService.deleteEmployee(employeeId);
        if ("刪除成功".equals(deleteResult)) {
            return ResponseEntity.ok(deleteResult);  // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(deleteResult);  // 404 Not Found
        }
    }

    // 修改員工資料
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeeById(@RequestBody Employee employee){
        String updateResult = employeeService.updateEmployeeById(employee);  // 委託給 Service 層

        if ("修改成功".equals(updateResult)) {
            return ResponseEntity.ok(updateResult); // 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateResult); // 404
        }
    }

    // 查詢員工資料
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        EmployeeResponse response = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(response);
    }

    }



