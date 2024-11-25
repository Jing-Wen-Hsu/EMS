package EMS1124.example.EMS1124.service;

import EMS1124.example.EMS1124.entity.Employee;
import EMS1124.example.EMS1124.repository.EmployeeRepository;
import EMS1124.example.EMS1124.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

//  要求功能

// 1. 新增員工資訊
// • 開發一個方法來新增員工的基本資訊，如員工編號、姓名、年齡、部門和職位。
// • 當新增成功時，應顯示「新增成功」的訊息；若輸入重複的員工編號，則顯示「員工已存在」。
    public String addEmployee(Employee employee) {
        if ( employeeRepository.existsById(employee.getEmployeeId()) ){
            return "員工已存在" ;
        }else {
            employeeRepository.save(employee);
            return "新增成功";
        }
    }
// 2. 修改員工資訊
// • 開發一個方法來修改指定員工的資訊。
// • 需透過員工編號查找並更新其他信息（如年齡或部門）。
// • 當修改成功時，顯示「修改成功」的訊息；若找不到該員工，顯示「員工不存在」。

    public String updateEmployeeById (Employee employee) {
        Optional<Employee> opt = employeeRepository.findById(employee.getEmployeeId());
        //opt是指目前存在資料庫中的員工，employee是要拿來更新的資料。

        //如果員工存在才進行更新
        if (opt.isPresent()){
            Employee updatedEmployee = opt.get();

            if(employee.getName() != null){   //如果 requestBody 中的姓名欄位有值（非 null），代表這個欄位有新資料要更新
                updatedEmployee.setName(employee.getName());
            }
            if (employee.getAge() != null) {
                updatedEmployee.setAge(employee.getAge());
            }
            if (employee.getDepartment() != null){
                updatedEmployee.setDepartment(employee.getDepartment());
            }
            if (employee.getPosition() != null){
                updatedEmployee.setPosition(employee.getPosition());
            }
            employeeRepository.save(updatedEmployee); //儲存更新後的員工資料
            return "修改成功";
        }else {
            return "員工不存在";
        }
    }

//  3. 刪除員工資訊
// • 開發一個方法來刪除指定員工的資訊。
// • 刪除時需透過員工編號進行定位。
// • 成功刪除後，顯示「刪除成功」；若找不到該員工，顯示「員工不存在」。

    public String deleteEmployee(Long employeeId) {
        Optional<Employee> opt = employeeRepository.findById(employeeId);
        if (opt.isPresent()){
            employeeRepository.delete(opt.get());
            return "刪除成功";
        }else {
            return "員工不存在";
        }
    }

// 4. 查詢員工資訊
// • 開發一個方法可依據員工編號查詢其詳細資訊。
// • 若查詢成功，顯示員工詳細資訊；若找不到該員工，顯示「員工不存在」。
    //注意：兩種結果回傳的資料型別不同!

    public EmployeeResponse getEmployee (Long employeeId) {
        Optional<Employee> opt = employeeRepository.findById(employeeId);

        if (opt.isPresent()) {
            return new EmployeeResponse(opt.get(), null); //回傳員工資料
        } else {
            return new EmployeeResponse(null, "員工不存在"); //回傳錯誤訊息
        }
    }


}
