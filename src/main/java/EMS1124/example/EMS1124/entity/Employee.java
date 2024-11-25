package EMS1124.example.EMS1124.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "Employee")
public class Employee {
//基本資訊，如員工編號、姓名、年齡、部門和職位。

    @Id
    @NotNull(message = "員工編號不能為空")
    private Long employeeId ;
    @NotEmpty(message = "姓名不能為空")
    private String name;

    //@Min(value = 18, message = "年齡必須大於或等於 18") //如果有需要可以限制年齡，要有valid驗證
    @NotNull(message = "年齡不能為空")
    private Integer age;
    @NotEmpty(message = "部門不能為空")
    private String department;
    @NotEmpty(message = "職位不能為空")
    private String position;

    public Employee() {
    }

    public Employee(Long employeeId, String name, Integer age, String department, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    //不開放修改員工編號
//    public void setEmployeeId(Long employeeId) {
//        this.employeeId = employeeId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
