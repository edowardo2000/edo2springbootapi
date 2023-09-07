package com.juaracoding.edo2springbootrestapi.model;

import com.juaracoding.edo2springbootrestapi.util.ConstantCalonPeserta;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
001
 */
public class CalonPeserta implements Serializable {

    private static Long serialize = 7001L;
    @NotNull(message = ConstantCalonPeserta.NAMA_NOT_NULL)
    @NotEmpty(message = ConstantCalonPeserta.NAMA_NOT_EMPTY)
    @Length(min = 5, max = 15,message = ConstantCalonPeserta.NAMA_MIN_MAX)
    @NotBlank(message = ConstantCalonPeserta.NAMA_NOT_BLANK)
    private String nama;
    @NotNull(message = ConstantCalonPeserta.UMUR_IS_MANDATORY)
    private Integer umur;
    @NotNull(message = ConstantCalonPeserta.NILAI_IS_MANDATORY)
    private Integer nilai;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }
}