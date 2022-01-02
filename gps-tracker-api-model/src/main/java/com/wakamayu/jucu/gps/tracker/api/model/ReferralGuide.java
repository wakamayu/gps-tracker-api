/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wakamayu.jucu.gps.tracker.api.model;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
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

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "referral_guide")
@NamedQueries({
    @NamedQuery(name = "ReferralGuide.findAll", query = "SELECT r FROM ReferralGuide r")})
public class ReferralGuide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number_guide")
    private String numberGuide;
    @Basic(optional = false)
    @Column(name = "addressee")
    private String addressee;
    @JoinColumn(name = "id_trip", referencedColumnName = "id")
    @ManyToOne
    private Trip idTrip;

    public ReferralGuide() {
    }

    public ReferralGuide(Integer id) {
        this.id = id;
    }

    public ReferralGuide(Integer id, String numberGuide, String addressee) {
        this.id = id;
        this.numberGuide = numberGuide;
        this.addressee = addressee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberGuide() {
        return numberGuide;
    }

    public void setNumberGuide(String numberGuide) {
        this.numberGuide = numberGuide;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

   // @JsonbTransient
    public Trip getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Trip idTrip) {
        this.idTrip = idTrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferralGuide)) {
            return false;
        }
        ReferralGuide other = (ReferralGuide) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wakamayu.jucu.gps.tracker.api.model.ReferralGuide[ id=" + id + " ]";
    }

}
