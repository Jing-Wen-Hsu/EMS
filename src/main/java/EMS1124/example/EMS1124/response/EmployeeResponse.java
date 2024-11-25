package EMS1124.example.EMS1124.response;

import EMS1124.example.EMS1124.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

//使null不顯示在json輸出中
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
    private Employee employee;
    private String message;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Employee employee, String message) {
        this.employee = employee;
        this.message = message;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
