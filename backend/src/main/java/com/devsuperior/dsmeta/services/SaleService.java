package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;



/**
 * @author Dagson Souza
 *
 */
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	

	public Page<SaleDTO> findAll(Pageable pegeable){
		Page<Sale> result = repository.findAll(pegeable);
		Page<SaleDTO> page = result.map(x -> new SaleDTO(x));
		return page;
	}
	
	public SaleDTO findById(Long id){
		Sale result = repository.findById(id).get();
		SaleDTO dto = new SaleDTO(result);
		return dto;
	}
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	public Page<SaleDTO> findSales(String minDate, String maxDate, Pageable pageable){		
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		Page<Sale> result = repository.findSales(min, max, pageable);
		Page<SaleDTO> page = result.map(x -> new SaleDTO(x));
		return page;
	}

}
