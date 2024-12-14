package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId",length=4)
	private int pid;
	@Column(name="productName",length=20)
	private String pname;
	@Column(name="productPrice",length=20)
	private String pprice;
	@Column(name="productRating",length=20)
	private String prating;
	@Transient
	private int categoryId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	public int getCategoryId() {
	    return (category != null) ? category.getCid() : 0;
	}

}
