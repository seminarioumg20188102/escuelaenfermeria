/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgtestjoshua.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EstelaChayoMonse
 */
@Entity
@Table(name = "aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a")
    , @NamedQuery(name = "Aula.findByIdaula", query = "SELECT a FROM Aula a WHERE a.idaula = :idaula")
    , @NamedQuery(name = "Aula.findByCapacidadaula", query = "SELECT a FROM Aula a WHERE a.capacidadaula = :capacidadaula")
    , @NamedQuery(name = "Aula.findByDescripcionaula", query = "SELECT a FROM Aula a WHERE a.descripcionaula = :descripcionaula")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAULA")
    private Integer idaula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDADAULA")
    private int capacidadaula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCIONAULA")
    private String descripcionaula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaula")
    private Collection<Asignacion> asignacionCollection;

    public Aula() {
    }

    public Aula(Integer idaula) {
        this.idaula = idaula;
    }

    public Aula(Integer idaula, int capacidadaula, String descripcionaula) {
        this.idaula = idaula;
        this.capacidadaula = capacidadaula;
        this.descripcionaula = descripcionaula;
    }

    public Integer getIdaula() {
        return idaula;
    }

    public void setIdaula(Integer idaula) {
        this.idaula = idaula;
    }

    public int getCapacidadaula() {
        return capacidadaula;
    }

    public void setCapacidadaula(int capacidadaula) {
        this.capacidadaula = capacidadaula;
    }

    public String getDescripcionaula() {
        return descripcionaula;
    }

    public void setDescripcionaula(String descripcionaula) {
        this.descripcionaula = descripcionaula;
    }

    @XmlTransient
    public Collection<Asignacion> getAsignacionCollection() {
        return asignacionCollection;
    }

    public void setAsignacionCollection(Collection<Asignacion> asignacionCollection) {
        this.asignacionCollection = asignacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaula != null ? idaula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.idaula == null && other.idaula != null) || (this.idaula != null && !this.idaula.equals(other.idaula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgtestjoshua.entities.Aula[ idaula=" + idaula + " ]";
    }
    
}
