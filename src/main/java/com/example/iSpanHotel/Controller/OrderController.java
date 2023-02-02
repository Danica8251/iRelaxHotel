package com.example.iSpanHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.iSpanHotel.Dto.OrderDto;
import com.example.iSpanHotel.Service.EmailService;
import com.example.iSpanHotel.Service.ItemService;
import com.example.iSpanHotel.Service.OrderService;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	private List<Order> findAll() {
		List<Order> order = orderService.findAll();
		return order;
	}
	
	@PostMapping("/")
	private ResponseEntity<String> create(@RequestBody OrderDto orderDto) {
		Order order = orderService.create(orderDto);
		Item item = itemService.create(orderDto, order);
		emailService.sendOrderDetail(orderDto, item);
		return ResponseEntity.ok("訂單創建成功");
	}
	
	@GetMapping("/o{id}")
	private ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		orderService.update(id, orderDto);
		itemService.update(id, orderDto);
		return ResponseEntity.ok("訂單修改成功");
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.ok("訂單刪除成功");
	}
	
	@GetMapping("/m{id}")
	private ResponseEntity<Order> findByMemberId(@PathVariable Long id) {
		Order order = orderService.findByMemberId(id);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
}
