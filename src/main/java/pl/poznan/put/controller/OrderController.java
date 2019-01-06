package pl.poznan.put.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.poznan.put.dao.OrderRepository;
import pl.poznan.put.model.CustomerData;
import pl.poznan.put.model.Dish;
import pl.poznan.put.model.Order;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository repository;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders() {

		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);

		return orders;
	}

	@PostMapping(value = "/orders")
	public Order postDish(@RequestBody Order order) {

		Order _order = repository.save(new Order().builder().withStatus(order.getStatus()).build());
		return _order;
	/*	
		CustomerData cd = repositoryCd.save(new CustomerData().builder().withFirstName(cd.getFirstName())
				.withLastName(cd.getLastName()).withPhone(cd.getPhone()).withCity(cd.getCity())
				.withStreet(cd.getStreet()).withZipCode(cd.getZipCode()).build());

		Order _order = repository
				.save(new Order().builder().withDishIds(order.getDishIds()).withAmountDish(order.getAmountDish())
						.withPrice(order.getPrice()).withStatus(order.getStatus()).withCustomerData(cd).build());
		return _order;
		*/
	}

	/*
	 * @PutMapping("/orders/{id}") public ResponseEntity<Order>
	 * updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
	 * 
	 * Optional<Order> orderData = repository.findById(id);
	 * 
	 * if (orderData.isPresent()) { Order _order = orderData.get();
	 * _order.setPrice(order.getPrice()); _order.setStatus(order.getStatus());
	 * //_order.setCustomerData(order.getCustomerData()); return new
	 * ResponseEntity<>(repository.save(_order), HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
}
