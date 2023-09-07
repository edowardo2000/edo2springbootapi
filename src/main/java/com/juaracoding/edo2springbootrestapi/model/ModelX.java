package com.juaracoding.edo2springbootrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class ModelX {

    @Id
    @Column(name = "IDModelX", columnDefinition = "VARCHAR(30)")
    public String idModelX;

    @Column(name = "Nama", columnDefinition = "CHAR(40) NOT NULL default 'SEDANG DIMINTA'")
    private String nama;

    @Column(name = "Alamat", columnDefinition = "NVARCHAR(255) NOT NULL default 'BELUM DIISI'")
    private String alamat;

    @Column(name = "TanggalLahir", columnDefinition = "DATE NULL")
    private LocalDate tanggalLahir;

    @Column(name = "JenisKelamin", columnDefinition = "CHAR(1) NULL default 'P'")
    private Character jenisKelamin;

    @Column(name = "MasihHidup")
    private Boolean masihHidup;
    @Column(name = "CreatedBy",columnDefinition = "BIGINT NOT NULL default 0")
    private Long createdBy;

    @Column(name = "CreatedDate",columnDefinition = "DATETIME NOT NULL default GETDATE()")
    private Date createdDate;

    @Column(name = "ModifiedBy")
    private Long modifiedBy;

    @Column(name = "ModifiedDate",columnDefinition = "DATETIME NULL")
    private Date modifiedDate;

    @Column(name = "IsActive")
    private Byte isActive;

    public String getIdModelX() {
        return idModelX;
    }

    public void setIdModelX(String idModelX) {
        this.idModelX = idModelX;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Boolean getMasihHidup() {
        return masihHidup;
    }

    public void setMasihHidup(Boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}
