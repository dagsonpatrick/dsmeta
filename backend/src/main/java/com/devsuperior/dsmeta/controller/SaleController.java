package com.devsuperior.dsmeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

/**
 * @author Dagson Souza
 *
 */
@RestController
@RequestMapping("sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService serviceSms;
	
	 
	@GetMapping
	public Page<SaleDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public SaleDTO findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	public Page<SaleDTO> findSales(@RequestParam(value="minDate" , defaultValue="") String minDate,
							 @RequestParam(value="maxDate" , defaultValue="") String maxDate,
							 Pageable pageable){
		
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		serviceSms.sendSms(id);
	}
	
	

}
