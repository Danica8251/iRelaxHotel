package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;
import com.example.iSpanHotel.model.Employee;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	private List<Employee> findAll() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}
	
	@GetMapping("/{page}/{rows}")
	private Page<Employee> findAll(@PathVariable int page, @PathVariable int rows) {
		Page<Employee> employees = employeeService.findByPaging(page, rows);
		return employees;
	}
	
	@GetMapping("/total")
	private Long countTotal() {
		return employeeService.countTotal();
	}
	
	@GetMapping("/findByName")
	private Page<Employee> findByName(@PathVariable int page, int rows, String name) {
		Page<Employee> employees = employeeService.findNameLike(rows, page, name);
		return employees;
	}

	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody EmployeeDto employeeDto) {
		employeeService.create(employeeDto);
		return ResponseEntity.ok("員工帳號創建成功");
	}

	@GetMapping("/{name}")
	private ResponseEntity<Employee> findByName(@PathVariable String name) {
		Employee employee = employeeService.findByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
		employeeService.update(id, employeeDto);
		return ResponseEntity.ok("員工帳號修改成功");
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok("員工帳號刪除成功");
	}

	@PostMapping("/login")
	private String login(HttpSession session,@RequestBody EmployeeDto employeeDto) {
		System.out.println(employeeDto.getAccount());
		System.out.println(employeeDto.getPasswd());
		String result = employeeService.login(session, employeeDto.getAccount(), employeeDto.getPasswd());
		System.out.println(result);
		return result;
	}
	
	@PostMapping("/logout")
	private String logout(HttpSession session) {
		session.setMaxInactiveInterval(0);
		return "登出成功";
	}
	
	@PostMapping("/checklogin")
	private String checkLogin(HttpSession session) {
		String result = "false";
		if(session.getAttribute("login") == null) {
			session.setAttribute("login", false);
		}
		if ((boolean) session.getAttribute("login") == true) {
			result = (String) session.getAttribute("name");
		}
		return result;
	}

}
