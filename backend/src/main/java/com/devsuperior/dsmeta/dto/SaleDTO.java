/**
 * 
 */
package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

/**
 * @author Dagson Souza
 *
 */
public class SaleDTO {
	
	private Long id;	
	private String sellerName;	
	private Integer visited;	
	private Integer deals;	
	private Double amount;	
	private LocalDate date;
	
	
	
	/**
	 * 
	 */
	public SaleDTO() {
	}


	/**
	 * @param id
	 * @param sellerName
	 * @param visited
	 * @param deals
	 * @param amount
	 * @param date
	 */
	public SaleDTO(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
		this.id = id;
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}
	
	public SaleDTO(Sale sale) {
		this.id = sale.getId();
		this.sellerName = sale.getSellerName();
		this.visited = sale.getVisited();
		this.deals = sale.getDeals();
		this.amount = sale.getAmount();
		this.date = sale.getDate();
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}


	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	/**
	 * @return the visited
	 */
	public Integer getVisited() {
		return visited;
	}


	/**
	 * @param visited the visited to set
	 */
	public void setVisited(Integer visited) {
		this.visited = visited;
	}


	/**
	 * @return the deals
	 */
	public Integer getDeals() {
		return deals;
	}


	/**
	 * @param deals the deals to set
	 */
	public void setDeals(Integer deals) {
		this.deals = deals;
	}


	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
