package com.juaracoding.edo2springbootrestapi.model;

import javax.persistence.*;

@Entity
@Table(name = "MstAddress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAddress")
    private Long idAdress;
    @Column(name = "NamaJalan",length = 500,nullable = false)
    private String namaJalan;
    @Column(name = "Provinsi", length = 40, nullable = false)
    private String provinsi;

    public Long getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(Long idAdress) {
        this.idAdress = idAdress;
    }

    public String getNamaJalan() {
        return namaJalan;
    }

    public void setNamaJalan(String namaJalan) {
        this.namaJalan = namaJalan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
}