package com.kavyatrainings.demo.service;

import java.util.List;

import javax.swing.Spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kavyatrainings.demo.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long>{
   List <Vendor> findByCompanyName(String companyName);
   
   @Query(nativeQuery = true,
	       value = "SELECT * FROM public.vendor WHERE lower(gst_no) LIKE lower(concat('%', ?1, '%'))")
	List<Vendor> lookupVendorByGST(String GSTNo);
}
