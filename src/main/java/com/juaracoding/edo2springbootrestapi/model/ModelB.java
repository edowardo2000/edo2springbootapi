package com.juaracoding.edo2springbootrestapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ModelB")
public class ModelB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelB")
    private long idModelB;

    @Column(name = "CreatedBy", columnDefinition = "BIGINT NOT NULL Default '1'")
    private long createdBy;

    @Column(name = "CreatedDate", columnDefinition = "DATETIME NOT NULL Default getDate()")
    private Date createdDate;

    @Column(name = "IsActive", columnDefinition = "SMALLINT")
    private short isActive;

    @Column(name = "ModelB", columnDefinition = "CHAR(30) NOT NULL Default 'Default Model B'")
    private String modelB;

    @Column(name = "ModifiedBy", columnDefinition = "BIGINT")
    private long modifiedBy;

    @Column(name = "ModifiedDate", columnDefinition = "DATETIME")
    private Date modifiedDate;

//    @Column(name = "IDModelA", columnDefinition = "BIGINT")
//    private long idModelA;

    @ManyToMany
    @JoinTable(name = "MapModelBModelC",
            joinColumns = {@JoinColumn(name = "IDModelB",referencedColumnName = "IDModelB",foreignKey =@ForeignKey(name = "fkMapToModelB"))},
            inverseJoinColumns = {@JoinColumn(name = "IDModelC",referencedColumnName = "IDModelC",foreignKey = @ForeignKey(name = "fkMapToModelC"))},
            uniqueConstraints = @UniqueConstraint(columnNames = {"IDModelB","IDModelC"})
    )
    private List<ModelC> listModelC;

    @ManyToOne
    @JoinColumn(name = "IDModelA", foreignKey = @ForeignKey(name = "fkModelBToModelA"))
    private ModelA modelA;

    public List<ModelC> getListModelC() {
        return listModelC;
    }

    public void setListModelC(List<ModelC> listModelC) {
        this.listModelC = listModelC;
    }

    public long getIdModelB() {
        return idModelB;
    }

    public void setIdModelB(long idModelB) {
        this.idModelB = idModelB;
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

    public String getModelB() {
        return modelB;
    }

    public void setModelB(String modelB) {
        this.modelB = modelB;
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