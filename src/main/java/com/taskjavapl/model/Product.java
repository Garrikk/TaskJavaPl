package com.taskjavapl.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "date_purchase", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate datePurchase;

	@NotNull
	@Digits(integer=8, fraction=2)
	@Column(name = "purchase_price", nullable = false)
	private BigDecimal purchasePrice;

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "date_sale", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateSale;

	@NotNull
	@Digits(integer=8, fraction=2)
	@Column(name = "selling_price", nullable = false)
	private BigDecimal sellingPrice;

	@NotNull
	@Column(name = "count_purchase", nullable = false)
	private Integer countPurchase;

	@NotNull
	@Column(name = "count_selling", nullable = false)
	private Integer countSelling;

	@NotEmpty
	@Column(name = "SSN", unique=true, nullable = false)
	private String ssn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(LocalDate datePurchase) {
		this.datePurchase = datePurchase;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public LocalDate getDateSale() {
		return dateSale;
	}

	public void setDateSale(LocalDate dateSale) {
		this.dateSale = dateSale;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getCountPurchase() {
		return countPurchase;
	}

	public void setCountPurchase(Integer countPurchase) {
		this.countPurchase = countPurchase;
	}

	public Integer getCountSelling() {
		return countSelling;
	}

	public void setCountSelling(Integer countSelling) {
		this.countSelling = countSelling;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", datePurchase="
				+ datePurchase + ", purchasePrice=" + purchasePrice + ", ssn=" + ssn + "]";
	}
}
