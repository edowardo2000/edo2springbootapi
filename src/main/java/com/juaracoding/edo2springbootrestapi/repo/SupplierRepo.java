package com.juaracoding.edo2springbootrestapi.repo;

import com.juaracoding.edo2springbootrestapi.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Long> {

}
