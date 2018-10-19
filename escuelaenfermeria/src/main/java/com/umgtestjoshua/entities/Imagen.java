/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgtestjoshua.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EstelaChayoMonse
 */
@Entity
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i")
    , @NamedQuery(name = "Imagen.findByIdimagen", query = "SELECT i FROM Imagen i WHERE i.idimagen = :idimagen")
    , @NamedQuery(name = "Imagen.findByUrlimagen", query = "SELECT i FROM Imagen i WHERE i.urlimagen = :urlimagen")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDIMAGEN")
    private Integer idimagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "URLIMAGEN")
    private String urlimagen;
    @JoinColumn(name = "IDEXPEDIENTE", referencedColumnName = "IDEXPEDIENTE")
    @ManyToOne(optional = false)
    private Expediente idexpediente;

    public Imagen() {
    }

    public Imagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public Imagen(Integer idimagen, String urlimagen) {
        this.idimagen = idimagen;
        this.urlimagen = urlimagen;
    }

    public Integer getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Integer idimagen) {
        this.idimagen = idimagen;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public Expediente getIdexpediente() {
        return idexpediente;
    }

    public void setIdexpediente(Expediente idexpediente) {
        this.idexpediente = idexpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimagen != null ? idimagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.idimagen == null && other.idimagen != null) || (this.idimagen != null && !this.idimagen.equals(other.idimagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgtestjoshua.entities.Imagen[ idimagen=" + idimagen + " ]";
    }
    
}
