package com.juaracoding.edo2springbootrestapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "ModelC")
public class ModelC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "IDModelC")
    private long idModelC;

    @Column(name= "CreatedBy", columnDefinition = "BIGINT NOT NULL Default '1'")
    private long createdBy;

    @Column(name = "CreatedDate", columnDefinition = "DATETIME NOT NULL Default getDate()")
    private Date createdDate;

    @Column(name = "IsActive", columnDefinition = "SMALLINT")
    private short isActive;

    @Column(name= "ModelC", columnDefinition = "CHAR(25) NOT NULL Default 'Default Model C'")
    private String modelC;

    @Column(name = "ModifiedBy", columnDefinition = "BIGINT")
    private long modifiedBy;

    @Column(name = "ModifiedDate", columnDefinition = "DATETIME")
    private Date modifiedDate;

    public ModelB getModelB() {
        return modelB;
    }

    public void setModelB(ModelB modelB) {
        this.modelB = modelB;
    }

    @ManyToMany(mappedBy = "listModelC")
    private List<ModelB> listModelB;

    public List<ModelB> getListModelB() {
        return listModelB;
    }

    public void setListModelB(List<ModelB> listModelB) {
        this.listModelB = listModelB;
    }

    @ManyToOne
    @JoinColumn(name = "IDModelB", foreignKey = @ForeignKey(name = "fkModelCToModelB",foreignKeyDefinition = ""))
    private ModelB modelB;

    public long getIdModelC() {
        return idModelC;
    }

    public void setIdModelC(long idModelC) {
        this.idModelC = idModelC;
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

    public String getModelC() {
        return modelC;
    }

    public void setModelC(String modelC) {
        this.modelC = modelC;
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

