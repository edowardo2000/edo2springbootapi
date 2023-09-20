package com.juaracoding.edo2springbootrestapi.controller;

import com.juaracoding.edo2springbootrestapi.model.Peserta;
import com.juaracoding.edo2springbootrestapi.repo.PesertaRepo;
import com.juaracoding.edo2springbootrestapi.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/op/peserta/")
public class PesertaController {

    @Autowired
    PesertaRepo pesertaRepo;

    @Autowired
    PesertaService pesertaService;

    @GetMapping("/")
//    public List<Peserta> getAllData() {
    public ResponseEntity<Object> getAllData() {
        Map<String,Object> m = new HashMap<String,Object>();
        List<Peserta> daftarPeserta = pesertaRepo.findAll();
        m.put("data",daftarPeserta);
        m.put("waktu",new Date());
        m.put("message","Data ada !!");

        return new ResponseEntity<Object>(m,HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public String postData(@Valid  @RequestBody Peserta peserta) {
//        pesertaRepo.save(peserta);
        pesertaService.save(peserta);
        return peserta.getNama() + " berhasil ditambahkan";
    }

    @GetMapping("/search-peserta-by-id")
    public Map<String,Object> searchPesertaById(@RequestParam(value = "id") Integer id) {
        Optional<Peserta> hasil = pesertaRepo.findById(id);
        Map<String,Object> m = new HashMap<>();
        if(hasil.isEmpty())
        {
            m.put("message","Data tidak ada");
            return m;
        }
        m.put("data",hasil.get());
        m.put("message","Data ditemukan");
        return m;
    }

    @GetMapping("/search-peserta-by-nama")
    public Map<String,Object> searchPesertaByName(
            @RequestParam(value = "nama") String nama,
            @RequestParam(value = "batch") String batch
    ) {
        List<Peserta> hasil = pesertaRepo.findBynamaContainsOrBatch(nama,batch);
        Map<String,Object> m = new HashMap<>();
        if(hasil.isEmpty())
        {
            m.put("message","Data tidak ada");
            return m;
        }
        m.put("data",hasil);
        m.put("message","Data ditemukan");
        System.out.println("OK");
        return m;
    }

    @GetMapping("/search-peserta-by-nama-sw")
    public Map<String,Object> searchPesertaByNameSW(
            @RequestParam(value = "nama") String nama
    ) {
        List<Peserta> hasil = pesertaRepo.findByNamaContains(nama);
        Map<String,Object> m = new HashMap<>();
        if(hasil.isEmpty())
        {
            m.put("message","Data tidak ada");
            return m;
        }
        m.put("data",hasil);
        m.put("message","Data ditemukan");
        return m;
    }
}