/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.iti.jets.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author marwa
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "staff_list")
@NamedQueries({
    @NamedQuery(name = "StaffList.findAll", query = "SELECT s FROM StaffList s")
    , @NamedQuery(name = "StaffList.findById", query = "SELECT s FROM StaffList s WHERE s.id = :id")
    , @NamedQuery(name = "StaffList.findByName", query = "SELECT s FROM StaffList s WHERE s.name = :name")
    , @NamedQuery(name = "StaffList.findByAddress", query = "SELECT s FROM StaffList s WHERE s.address = :address")
    , @NamedQuery(name = "StaffList.findByZipCode", query = "SELECT s FROM StaffList s WHERE s.zipCode = :zipCode")
    , @NamedQuery(name = "StaffList.findByPhone", query = "SELECT s FROM StaffList s WHERE s.phone = :phone")
    , @NamedQuery(name = "StaffList.findByCity", query = "SELECT s FROM StaffList s WHERE s.city = :city")
    , @NamedQuery(name = "StaffList.findByCountry", query = "SELECT s FROM StaffList s WHERE s.country = :country")
    , @NamedQuery(name = "StaffList.findBySid", query = "SELECT s FROM StaffList s WHERE s.sid = :sid")})
public class StaffList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // by me
    @Basic(optional = false)
    @Column(name = "ID")
    private short id;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "zip code")
    private String zipCode;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "SID")
    private short sid;
}
