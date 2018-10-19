/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgtestjoshua.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EstelaChayoMonse
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findByIdasignacion", query = "SELECT a FROM Asignacion a WHERE a.idasignacion = :idasignacion")
    , @NamedQuery(name = "Asignacion.findByFechaasignacion", query = "SELECT a FROM Asignacion a WHERE a.fechaasignacion = :fechaasignacion")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDASIGNACION")
    private Integer idasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAASIGNACION")
    @Temporal(TemporalType.DATE)
    private Date fechaasignacion;
    @JoinColumn(name = "IDALUMNO", referencedColumnName = "IDALUMNO")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "IDAULA", referencedColumnName = "IDAULA")
    @ManyToOne(optional = false)
    private Aula idaula;
    @JoinColumn(name = "IDCATEDRATICO", referencedColumnName = "IDCATEDRATICO")
    @ManyToOne(optional = false)
    private Catedratico idcatedratico;
    @JoinColumn(name = "IDCURSO", referencedColumnName = "IDCURSO")
    @ManyToOne(optional = false)
    private Curso idcurso;

    public Asignacion() {
    }

    public Asignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Asignacion(Integer idasignacion, Date fechaasignacion) {
        this.idasignacion = idasignacion;
        this.fechaasignacion = fechaasignacion;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Date getFechaasignacion() {
        return fechaasignacion;
    }

    public void setFechaasignacion(Date fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Aula getIdaula() {
        return idaula;
    }

    public void setIdaula(Aula idaula) {
        this.idaula = idaula;
    }

    public Catedratico getIdcatedratico() {
        return idcatedratico;
    }

    public void setIdcatedratico(Catedratico idcatedratico) {
        this.idcatedratico = idcatedratico;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacion != null ? idasignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idasignacion == null && other.idasignacion != null) || (this.idasignacion != null && !this.idasignacion.equals(other.idasignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgtestjoshua.entities.Asignacion[ idasignacion=" + idasignacion + " ]";
    }
    
}
