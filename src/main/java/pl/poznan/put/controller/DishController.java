package pl.poznan.put.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import pl.poznan.put.dao.DishRepository;
import pl.poznan.put.model.Dish;

@RestController
@RequestMapping("/api")
public class DishController {

	@Autowired
	private DishRepository repository;

	@GetMapping("/dishes")
	public List<Dish> getAllDishes() {
		System.out.println("Get all Dishes...");

		List<Dish> dishes = new ArrayList<>();
		repository.findAll().stream().filter(dish->dish.isAvailable()==true).forEach(dishes::add);

		return dishes;
	}
	
	@GetMapping("/dishes/admin")
	public List<Dish> getAllDishesForAdmin() {

		List<Dish> dishes = new ArrayList<>();
		repository.findAll().forEach(dishes::add);

		return dishes;
	}

	@PostMapping(value = "/dishes")
	public Dish postDish(@RequestBody Dish dish) {

		Dish _dish = repository.save(new Dish().builder().withName(dish.getName()).withPrice(dish.getPrice())
				.withType(dish.getType()).withDescription(dish.getDescription()).withAvailable(true).build());
		return _dish;
	}

	@DeleteMapping(value = "/dishes/{id}")
	public ResponseEntity<?> deleteDish(@PathVariable("id") Long id) {
		System.out.println("Delete Dish with ID = " + id + "...");

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Authenticator.Failure>(HttpStatus.GONE);
		}

		return new ResponseEntity<Authenticator.Success>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/dishes/delete")
	public ResponseEntity<?> deleteAllDishes() {
		System.out.println("Delete All Dishes...");
		try {
			repository.deleteAll();
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Authenticator.Failure>(HttpStatus.GONE);
		}
		return new ResponseEntity<Authenticator.Success>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "dishes/name/{name}")
	public List<Dish> findByName(@PathVariable String name) {

		List<Dish> dishes = repository.findByName(name);
		return dishes;
	}

	@GetMapping(value = "dishes/pizzas")
	public List<Dish> getPizzas() {

		return repository.findAll().stream().filter(dish -> (dish.getType().equals("pizza")||dish.getType().equals("Pizza") ) && dish.isAvailable()==true)
				.collect(Collectors.toList());
	}

	@GetMapping(value = "dishes/pastas")
	public List<Dish> getPastas() {

		return repository.findAll().stream().filter(dish -> (dish.getType().equals("spagetti")||dish.getType().equals("Spagetti") ) && dish.isAvailable()==true)
				.collect(Collectors.toList());
	}

	@GetMapping(value = "dishes/drinks")
	public List<Dish> getDrinks() {

		return repository.findAll().stream().filter(dish -> (dish.getType().equals("drink")||dish.getType().equals("Drink") ) && dish.isAvailable()==true)
				.collect(Collectors.toList());
	}

	@GetMapping(value = "dishes/type/{type}")
	public List<Dish> findByPrice(@PathVariable String type) {

		List<Dish> dishes = repository.findByType(type);
		return dishes;
	}

	@PutMapping("/dishes/{id}")
	public ResponseEntity<Dish> updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
		System.out.println("Update Dish with ID = " + id + "...");

		Optional<Dish> dishData = repository.findById(id);

		if (dishData.isPresent()) {
			Dish _dish = dishData.get();
			_dish.setName(dish.getName());
			_dish.setPrice(dish.getPrice());
			_dish.setType(dish.getType());
			_dish.setDescription(dish.getDescription());
			_dish.setAvailable(dish.isAvailable());
			System.out.println("ddd");
			return new ResponseEntity<>(repository.save(_dish), HttpStatus.OK);
		} else {
			System.out.println("cccc");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/dishes/{id}")
	public Dish getDish(@PathVariable("id") Long id) {

		Optional<Dish> dishData = repository.findById(id);
		Dish _dish = dishData.get();
		return _dish;
	}
}