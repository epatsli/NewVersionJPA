package pl.poznan.put.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import exception.IncorrectParameterException;

@Embeddable
public class CustomerData {

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

	public CustomerData() {
	}

	public CustomerData(CustomerDataBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phone = builder.phone;
		this.street = builder.street;
		this.houseNumber = builder.houseNumber;
		this.city = builder.city;
		this.zipCode = builder.zipCode;
	}

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

	public CustomerDataBuilder builder() {
		return new CustomerDataBuilder();
	}

	public static class CustomerDataBuilder {
		private String firstName;
		private String lastName;
		private String phone;
		private String street;
		private String houseNumber;
		private String city;
		private String zipCode;

		public CustomerDataBuilder() {
		}

		public CustomerDataBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CustomerDataBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CustomerDataBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public CustomerDataBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public CustomerDataBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public CustomerDataBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public CustomerDataBuilder withZipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		private void checkBeforeBuild() {
			if (firstName == null || lastName == null || houseNumber == null || city == null
					|| zipCode == null) {
				throw new IncorrectParameterException("This customer data can't be created.");
			}
		}

		public CustomerData build() {
			checkBeforeBuild();
			return new CustomerData(this);
		}

	}

}
