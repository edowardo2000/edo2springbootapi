package com.juaracoding.edo2springbootrestapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ModelA")
public class ModelA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "IDModelA", columnDefinition = "BIGINT")
    private long idModelA;

    @Column(name= "CreatedBy", columnDefinition = "BIGINT NOT NULL Default '1'")
    private long createdBy;

    @Column(name= "CreatedDate" , columnDefinition = "DATETIME NOT NULL Default getDate()")
    private Date createdDate;

    @Column(name= "isActive", columnDefinition = "SMALLINT")
    private short isActive;

    @Column(name= "ModelA", columnDefinition = "CHAR(20) NOT NULL Default 'Default Model A'")
    private String modelA;

    @Column(name= "ModifiedBy", columnDefinition = "BIGINT")
    private long modifiedBy;

    @Column(name= "ModifiedDate", columnDefinition = "DATETIME")
    private Date modifiedDate;

    @OneToMany(mappedBy = "modelA")
    private List<ModelB> listModelB;


    public List<ModelB> getListModelB() {
        return listModelB;
    }

    public void setListModelB(List<ModelB> listModelB) {
        this.listModelB = listModelB;
    }

    public long getIdModelA() {
        return idModelA;
    }

    public void setIdModelA(long idModelA) {
        this.idModelA = idModelA;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public String getModelA() {
        return modelA;
    }

    public void setModelA(String modelA) {
        this.modelA = modelA;
    }

    public long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
