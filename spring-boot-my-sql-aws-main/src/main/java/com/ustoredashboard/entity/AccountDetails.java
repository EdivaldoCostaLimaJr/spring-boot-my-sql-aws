package com.ustoredashboard.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "account_details")

public class AccountDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "product_code")
	private String ProductCode;
	@Column(name = "line_item_type")
	private String LineItemType;
	@Column(name = "bill_type")
	private String BillType;
	@Column(name = "billing_entity")
	private String BillingEntity;
	@Column(name = "product_name")
	private String ProductName;
	
	
	public AccountDetails() {
		super();
	}
	
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String ProductCode) { this.ProductCode = ProductCode;}
	

	public String getLineItemType() {
	return LineItemType;
	}
	public void setLineItemType(String LineItemType) { this.LineItemType = LineItemType;}

	
	public String getLineBillType() {
	return BillType;
	}
	public void setBillType(String LineBillType) { this.BillType = LineBillType;}
	

	public String getBillingEntity() {
	return BillingEntity;
	}
	public void setBillingEntity(String BillingEntity) { this.BillingEntity = BillingEntity;} 


	public String getProductName() {
	return ProductName;
	}
	public void setProductName(String ProductName) { this.ProductName = ProductName;} 
	

	}
	
	

