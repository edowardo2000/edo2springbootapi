package com.juaracoding.edo2springbootrestapi.model;

public class Tunggal {

    private CalonPeserta calonPeserta;

    private Long id;
    private Integer intZ;

    public CalonPeserta getCalonPeserta() {
        return calonPeserta;
    }

    public void setCalonPeserta(CalonPeserta calonPeserta) {
        this.calonPeserta = calonPeserta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIntZ() {
        return intZ;
    }

    public void setIntZ(Integer intZ) {
        this.intZ = intZ;
    }
}
