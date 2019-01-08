package pl.poznan.put.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.IncorrectParameterException;
import pl.poznan.put.model.CustomerData.CustomerDataBuilder;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ids")
	private Long id;
	
	@OneToMany(mappedBy = "id")
	@ElementCollection
	@Column(name = "dishIds")
	private List<Dish> dishIds = new ArrayList<>();
	
	//@OneToMany(mappedBy = "count")
	@Column(name = "amountDish")
	@ElementCollection//(targetClass=Integer.class)
	private List<Integer> amountDish = new ArrayList<>();
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "status")
	private String status;
	
	//@Embedded
	//private CustomerData customerData;
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "street", length = 32)
	private String street;

	@Column(name = "houseNumber", length = 16)
	private String houseNumber;

	@Column(name = "city", length = 32)
	private String city;

	@Column(name = "zipCode", length = 8)
	private String zipCode;
	
	public Order() {
	}
	
	public Order(OrderBuilder builder) {
		this.dishIds=builder.dishIds;
		this.amountDish=builder.amountDish;
		this.price=builder.price;
		this.status=builder.status;
		//this.customerData=builder.customerData;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phone = builder.phone;
		this.street = builder.street;
		this.houseNumber = builder.houseNumber;
		this.city = builder.city;
		this.zipCode = builder.zipCode;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Dish> getDishIds() {
		return dishIds;
	}

	public void setDishIds(List<Dish> dishIds) {
		this.dishIds = dishIds;
	}
	

	public List<Integer> getAmountDish() {
		return amountDish;
	}

	public void setAmountDish(List<Integer> amountDish) {
		this.amountDish = amountDish;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	public static class OrderBuilder{
		private Long id;
		private List<Dish> dishIds;
		private List<Integer> amountDish;
		private double price;
		private String status;
		//private CustomerData customerData;
		private String firstName;
		private String lastName;
		private String phone;
		private String street;
		private String houseNumber;
		private String city;
		private String zipCode;

		
		public OrderBuilder() {
		}
		
		public OrderBuilder withId(Long id) {
			this.id = id;
			return this;
		}
	
		public OrderBuilder withDishIds(List<Dish> dishIds) {
			this.dishIds = dishIds;
			return this;
		}
		
		
		public OrderBuilder withAmountDish(List<Integer> amountDish) {
			this.amountDish = amountDish;
			return this;
		}
		
		public OrderBuilder withPrice(double price) {
			this.price = price;
			return this;
		}
		
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
		public OrderBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public OrderBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public OrderBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public OrderBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public OrderBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public OrderBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public OrderBuilder withZipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		
		public Order build() {
			checkBeforeBuild();
			return new Order(this);
		}

		private void checkBeforeBuild() {

			if ( dishIds.isEmpty() || status == null || firstName == null || lastName == null || houseNumber == null || city == null
					|| zipCode == null) {
				throw new IncorrectParameterException("This order can't be created.");
			}

		}
	}
}
