package pl.poznan.put.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.IncorrectParameterException;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	/*
	@OneToMany(mappedBy = "id")
	@Column(name = "dishIds")
	private List<Dish> dishIds = new ArrayList<>();
	*/
	/*
	//@OneToMany(mappedBy = "")
	@Column(name = "amountDish")
	private List<Integer> amountDish = new ArrayList<>();
	*/
	/*
	@Column(name = "price")
	private double price;
	*/
	@Column(name = "status")
	private String status;
	
	/*
	@Embedded
	private CustomerData customerData;
	*/
	public Order() {
	}
	
	public Order(OrderBuilder builder) {
	//	this.dishIds=builder.dishIds;
	//	this.amountDish=builder.amountDish;
	//	this.price=builder.price;
		this.status=builder.status;
	//	this.customerData=builder.customerData;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public List<Dish> getDishIds() {
		return dishIds;
	}

	public void setDishIds(List<Dish> dishIds) {
		this.dishIds = dishIds;
	}
	*/
/*
	public List<Integer> getAmountDish() {
		return amountDish;
	}

	public void setAmountDish(List<Integer> amountDish) {
		this.amountDish = amountDish;
	}
*/
	/*
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
*/
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
/*
	public CustomerData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
*/
	public OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	public static class OrderBuilder{
		private Long id;
	//	private List<Dish> dishIds;
	//	private List<Integer> amountDish;
	//	private double price;
		private String status;
	//	private CustomerData customerData;
		
		public OrderBuilder() {
		}
		
		public OrderBuilder withId(Long id) {
			this.id = id;
			return this;
		}
	/*	
		public OrderBuilder withDishIds(List<Dish> dishIds) {
			this.dishIds = dishIds;
			return this;
		}
		*/
		/*
		public OrderBuilder withAmountDish(List<Integer> amountDish) {
			this.amountDish = amountDish;
			return this;
		}
		*/
		/*
		public OrderBuilder withPrice(double price) {
			this.price = price;
			return this;
		}
		*/
		public OrderBuilder withStatus(String status) {
			this.status = status;
			return this;
		}
		
	/*	
		public OrderBuilder withCustomerData(CustomerData customerData) {
			this.customerData = customerData;
			return this;
		}
	*/	
		public Order build() {
			checkBeforeBuild();
			return new Order(this);
		}

		private void checkBeforeBuild() {

		//	if ( dishIds.isEmpty() || status == null || customerData == null) {
		//		throw new IncorrectParameterException("This client can't be created.");
		//	}

		}
	}
}
