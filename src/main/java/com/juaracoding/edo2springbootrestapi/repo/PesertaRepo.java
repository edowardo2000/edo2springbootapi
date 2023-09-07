package com.juaracoding.edo2springbootrestapi.repo;


import com.juaracoding.edo2springbootrestapi.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PesertaRepo extends JpaRepository<Peserta,Integer> {


    public List<Peserta> findBynamaContainsOrBatch(String n, String b);
    public List<Peserta> findByNamaContains(String n);
}
