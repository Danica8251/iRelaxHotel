package com.example.iSpanHotel.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Dao.EmployeeDao;
import com.example.iSpanHotel.Dto.EmployeeDto;
import com.example.iSpanHotel.Service.EmployeeService;
import com.example.iSpanHotel.model.Employee;
import io.jsonwebtoken.Claims;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String create(EmployeeDto employeeDto) {
		int checkAccount = employeeDao.countByAccount(employeeDto.getAccount());
		
		if (checkAccount == 0) {
			try {
				Employee employee = new Employee();
				employee.setAccount(employeeDto.getAccount());
				employee.setPasswd(BCrypt.hashpw(employeeDto.getPasswd(), BCrypt.gensalt()));
				employee.setName(employeeDto.getName());
				employeeDao.save(employee);
				return "註冊成功";
			} catch (Exception e) {
				e.printStackTrace();
//				throw new RuntimeException(e.getMessage());
				return "發生未知的錯誤";
			}
		}else {
			return "此帳號已有人使用";
		}
	}

	@Override
	public String delete(Long id) {
		try {
			employeeDao.deleteById(id);
			return "帳號刪除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
//			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String update(Long id, EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setAccount(employeeDto.getAccount());
			employee.setPasswd(BCrypt.hashpw(employeeDto.getPasswd(), BCrypt.gensalt()));
			employee.setName(employeeDto.getName());
			employeeDao.save(employee);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "發生未知的錯誤";
		}
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findAll();
		return employees;
	}
	
	@Override
	public List<Employee> findByPaging(int page, int rows) {
		List<Employee> employees = new ArrayList<>();
		Page<Employee> pageResult = employeeDao.findAll(PageRequest.of(page, rows,Sort.by("id")));
		employees = pageResult.getContent();
		return employees;
	}
	
	@Override
	public Employee findByName(String name) {
		Optional<Employee> employee = employeeDao.findByName(name);
		return employee.get();
	}

	@Override
	public Boolean checkLogin(String token) {
		try {
			Claims claims = JWTutils.parseJWT(token);
			System.out.println("解析成功" + claims.getSubject());
			return true;
		} catch (Exception exception) {
			System.out.println("解析失敗:");
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public String login(String account, String password) {
		if(employeeDao.findByAccount(account) != null) {
			Employee employee = employeeDao.findByAccount(account);
			String pswd = employee.getPasswd();
			if (BCrypt.checkpw(password,pswd)) {
				// 生成JWT
				String token = JWTutils.creatJWT(employee.getId().toString(),employee.toString(), null);
				System.out.println("生成token=:" + token);
				return token;
			}else {
				System.out.println("找不到密碼");
				return "帳號或密碼錯誤";
			}
		}else {
			System.out.println("找不到帳號");
			return "帳號或密碼錯誤";
		}
	}

}
