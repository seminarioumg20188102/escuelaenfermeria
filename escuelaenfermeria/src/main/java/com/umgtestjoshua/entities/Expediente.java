/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgtestjoshua.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EstelaChayoMonse
 */
@Entity
@Table(name = "expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
    , @NamedQuery(name = "Expediente.findByIdexpediente", query = "SELECT e FROM Expediente e WHERE e.idexpediente = :idexpediente")
    , @NamedQuery(name = "Expediente.findByEstado", query = "SELECT e FROM Expediente e WHERE e.estado = :estado")
    , @NamedQuery(name = "Expediente.findByFechacreacion", query = "SELECT e FROM Expediente e WHERE e.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "Expediente.findByMemo", query = "SELECT e FROM Expediente e WHERE e.memo = :memo")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXPEDIENTE")
    private Integer idexpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEMO")
    private String memo;
    @JoinColumn(name = "IDALUMNO", referencedColumnName = "IDALUMNO")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpediente")
    private Collection<Imagen> imagenCollection;

    public Expediente() {
    }

    public Expediente(Integer idexpediente) {
        this.idexpediente = idexpediente;
    }

    public Expediente(Integer idexpediente, String estado, Date fechacreacion, String memo) {
        this.idexpediente = idexpediente;
        this.estado = estado;
        this.fechacreacion = fechacreacion;
        this.memo = memo;
    }

    public Integer getIdexpediente() {
        return idexpediente;
    }

    public void setIdexpediente(Integer idexpediente) {
        this.idexpediente = idexpediente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection() {
        return imagenCollection;
    }

    public void setImagenCollection(Collection<Imagen> imagenCollection) {
        this.imagenCollection = imagenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexpediente != null ? idexpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.idexpediente == null && other.idexpediente != null) || (this.idexpediente != null && !this.idexpediente.equals(other.idexpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgtestjoshua.entities.Expediente[ idexpediente=" + idexpediente + " ]";
    }
    
}
