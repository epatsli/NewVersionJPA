package pl.poznan.put.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import exception.IncorrectParameterException;

@Entity
@Table(name = "dish")
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@Column(name = "type")
	private String type;

	@Column(name = "description")
	private String description;

	@Column(name = "isAvailable")
	private Boolean isAvailable;

	public Dish() {
	}

	public Dish(DishBuilder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
		this.description = builder.description;
		this.isAvailable = builder.isAvailable;
	}

	public DishBuilder builder() {
		return new DishBuilder();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public static class DishBuilder {
		private Long id;
		private String name;
		private double price;
		private String type;
		private String description;
		private boolean isAvailable;

		public DishBuilder() {
		}

		public DishBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public DishBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public DishBuilder withPrice(double price) {
			this.price = price;
			return this;
		}

		public DishBuilder withType(String type) {
			this.type = type;
			return this;
		}

		public DishBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public DishBuilder withAvailable(boolean available) {
			this.isAvailable = available;
			return this;
		}

		public Dish build() {
			checkBeforeBuild();
			return new Dish(this);
		}

		private void checkBeforeBuild() {

			if (name == null) {
				throw new IncorrectParameterException("This dish can't be created.");
			}

		}
	}

}
