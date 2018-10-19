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
@Table(name = "catedratico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catedratico.findAll", query = "SELECT c FROM Catedratico c")
    , @NamedQuery(name = "Catedratico.findByIdcatedratico", query = "SELECT c FROM Catedratico c WHERE c.idcatedratico = :idcatedratico")
    , @NamedQuery(name = "Catedratico.findByNombrecatedratico", query = "SELECT c FROM Catedratico c WHERE c.nombrecatedratico = :nombrecatedratico")
    , @NamedQuery(name = "Catedratico.findByApellidocatedratico", query = "SELECT c FROM Catedratico c WHERE c.apellidocatedratico = :apellidocatedratico")
    , @NamedQuery(name = "Catedratico.findByFechanacimiento", query = "SELECT c FROM Catedratico c WHERE c.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Catedratico.findBySexo", query = "SELECT c FROM Catedratico c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Catedratico.findByDpi", query = "SELECT c FROM Catedratico c WHERE c.dpi = :dpi")
    , @NamedQuery(name = "Catedratico.findByDireccioncatedratico", query = "SELECT c FROM Catedratico c WHERE c.direccioncatedratico = :direccioncatedratico")
    , @NamedQuery(name = "Catedratico.findByTelefono", query = "SELECT c FROM Catedratico c WHERE c.telefono = :telefono")})
public class Catedratico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATEDRATICO")
    private Integer idcatedratico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "NOMBRECATEDRATICO")
    private String nombrecatedratico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "APELLIDOCATEDRATICO")
    private String apellidocatedratico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DPI")
    private String dpi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCIONCATEDRATICO")
    private String direccioncatedratico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO")
    private int telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcatedratico")
    private Collection<Asignacion> asignacionCollection;

    public Catedratico() {
    }

    public Catedratico(Integer idcatedratico) {
        this.idcatedratico = idcatedratico;
    }

    public Catedratico(Integer idcatedratico, String nombrecatedratico, String apellidocatedratico, Date fechanacimiento, String sexo, String dpi, String direccioncatedratico, int telefono) {
        this.idcatedratico = idcatedratico;
        this.nombrecatedratico = nombrecatedratico;
        this.apellidocatedratico = apellidocatedratico;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
        this.dpi = dpi;
        this.direccioncatedratico = direccioncatedratico;
        this.telefono = telefono;
    }

    public Integer getIdcatedratico() {
        return idcatedratico;
    }

    public void setIdcatedratico(Integer idcatedratico) {
        this.idcatedratico = idcatedratico;
    }

    public String getNombrecatedratico() {
        return nombrecatedratico;
    }

    public void setNombrecatedratico(String nombrecatedratico) {
        this.nombrecatedratico = nombrecatedratico;
    }

    public String getApellidocatedratico() {
        return apellidocatedratico;
    }

    public void setApellidocatedratico(String apellidocatedratico) {
        this.apellidocatedratico = apellidocatedratico;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getDireccioncatedratico() {
        return direccioncatedratico;
    }

    public void setDireccioncatedratico(String direccioncatedratico) {
        this.direccioncatedratico = direccioncatedratico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
        hash += (idcatedratico != null ? idcatedratico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catedratico)) {
            return false;
        }
        Catedratico other = (Catedratico) object;
        if ((this.idcatedratico == null && other.idcatedratico != null) || (this.idcatedratico != null && !this.idcatedratico.equals(other.idcatedratico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgtestjoshua.entities.Catedratico[ idcatedratico=" + idcatedratico + " ]";
    }
    
}
