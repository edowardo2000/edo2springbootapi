package com.juaracoding.edo2springbootrestapi.controller;

import com.juaracoding.edo2springbootrestapi.configuration.OtherConfiguration;
import com.juaracoding.edo2springbootrestapi.model.CalonPeserta;
import com.juaracoding.edo2springbootrestapi.model.Tunggal;
import com.juaracoding.edo2springbootrestapi.util.FileUtility;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

//    localhost:8080/hello/permisi
    @GetMapping("/permisi")
    public String firstPage() {
        System.out.println("Value Flag Loging : "+OtherConfiguration.getFlagLoging());
        return OtherConfiguration.getFlagLoging();
    }

    @GetMapping("/permisi2")
    public String secondPage() {
        return "Ini Page ke dua";
    }
    @PostMapping("/seleksi")
    public Map<String,Object> seleksiCalonPeserta(@Valid @RequestBody CalonPeserta calon) {
        System.out.println("Parkir Disini !!");
        calon.setNilai(100);
        calon.setUmur(79);

        Map<String,Object> mapz = new HashMap<>();
        mapz.put("message","OK BOSS !!");
        mapz.put("data",calon);
        mapz.put("status","single");
        mapz.put("waktu",new Date());
        if (calon.getNilai() > 80
                && calon.getUmur() >= 18
                && calon.getUmur() <= 60) {
//            return calon.getNama() + " lolos seleksi";
            //business logic
        } else {
//            return calon.getNama() + " tidak lolos seleksi";
            //business logic
        }
        return mapz;
    }

    @PostMapping("/seleksi2")
    public String seleksiCalonPesertaDua(
            @RequestParam(value = "nama")  String strNama,
            @RequestParam(value = "umur") Integer intUmur,
            @RequestParam(value = "nilai") Integer intNilai
            ) {

        CalonPeserta cp = new CalonPeserta();
        cp.setUmur(intUmur);
        cp.setNilai(intNilai);
        cp.setNama(strNama);

        if (intNilai > 80
                && intUmur >= 18
                && intUmur <= 60) {
            return strNama + " lolos seleksi";
        } else {
            return strNama + "tidak lolos seleksi";
        }
    }

    @PostMapping("/seleksi3")
    public Tunggal seleksiCalonPesertaDua(
            @RequestBody Tunggal tunggal
            ) {

        System.out.println(tunggal.getId());
        System.out.println(tunggal.getIntZ());
        System.out.println(tunggal.getCalonPeserta().getNilai());
        System.out.println(tunggal.getCalonPeserta().getNama());
        System.out.println(tunggal.getCalonPeserta().getUmur());

        return tunggal;
    }

    @PostMapping("/seleksi3/{nama}/{umur}/{nilai}")
    public String seleksiCalonPeserta3(
           @PathVariable(value = "nama") String strNama,
           @PathVariable(value = "nilai") Double douNilai,
           @PathVariable(value = "umur") Integer intUmur
    ) {
        if (douNilai > 80 && intUmur >= 18 && intUmur <= 60) {
            return strNama + " lolos seleksi";
        } else {
            return strNama + " tidak lolos seleksi";
        }
    }
    @PostMapping("/seleksi4/{umur}/{nilai}/{nama}")
    public String seleksiCalonPeserta3KeDua(
            @PathVariable(value = "nama") String strNama,
            @PathVariable(value = "umur") Integer intUmur,
            @PathVariable(value = "nilai") Double douNilai
    ) {
        if (douNilai > 80 && intUmur >= 18 && intUmur <= 60) {
            return strNama + " lolos seleksi";
        } else {
            return strNama + " tidak lolos seleksi";
        }
    }

    @PostMapping("/kirim-file")
    public String submitFile(@RequestParam(value = "kiriman") MultipartFile file)  {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "./user-files/";
        try {
            FileUtility.saveFile(uploadDir, fileName, file);
        } catch (IOException e) {
            throw new RuntimeException("Error "+e.getMessage());
        }
        return "Berhasil mengunggah file " + fileName;
    }
}