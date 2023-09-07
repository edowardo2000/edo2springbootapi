package com.juaracoding.edo2springbootrestapi.service;

import com.juaracoding.edo2springbootrestapi.configuration.OtherConfiguration;
import com.juaracoding.edo2springbootrestapi.model.Peserta;
import com.juaracoding.edo2springbootrestapi.repo.PesertaRepo;
import com.juaracoding.edo2springbootrestapi.util.LoggingFile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PesertaService {

    private PesertaRepo pesertaRepo;
    private String [] strExceptionArr = new String[2];


    public PesertaService(PesertaRepo pesertaRepo) {
        strExceptionArr[0] = "PesertaService";
        this.pesertaRepo = pesertaRepo;
    }

    public void save(Peserta peserta){
        try{
//            int intX =1/0;// COBA ERRORIN
            pesertaRepo.save(peserta);
        }
        catch (Exception e)
        {
            strExceptionArr[1] = "save(Peserta peserta) --- LINE 30";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfiguration.getFlagLoging());
        }

        /*
            INSERT INTO PESERTA (id,nama,alamat,batch) VALUES (peserta.getID,peserta.getNama,peserta.getAlamat,peserta.getBatch);
         */
    }

    public void findAll(){
        pesertaRepo.findAll();
        /*
            INSERT INTO PESERTA (id,nama,alamat,batch) VALUES (peserta.getID,peserta.getNama,peserta.getAlamat,peserta.getBatch);
         */
    }

}
