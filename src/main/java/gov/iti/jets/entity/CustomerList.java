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
@Table(name = "customer_list")
@NamedQueries({
    @NamedQuery(name = "CustomerList.findAll", query = "SELECT c FROM CustomerList c")
    , @NamedQuery(name = "CustomerList.findById", query = "SELECT c FROM CustomerList c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerList.findByName", query = "SELECT c FROM CustomerList c WHERE c.name = :name")
    , @NamedQuery(name = "CustomerList.findByAddress", query = "SELECT c FROM CustomerList c WHERE c.address = :address")
    , @NamedQuery(name = "CustomerList.findByZipCode", query = "SELECT c FROM CustomerList c WHERE c.zipCode = :zipCode")
    , @NamedQuery(name = "CustomerList.findByPhone", query = "SELECT c FROM CustomerList c WHERE c.phone = :phone")
    , @NamedQuery(name = "CustomerList.findByCity", query = "SELECT c FROM CustomerList c WHERE c.city = :city")
    , @NamedQuery(name = "CustomerList.findByCountry", query = "SELECT c FROM CustomerList c WHERE c.country = :country")
    , @NamedQuery(name = "CustomerList.findByNotes", query = "SELECT c FROM CustomerList c WHERE c.notes = :notes")
    , @NamedQuery(name = "CustomerList.findBySid", query = "SELECT c FROM CustomerList c WHERE c.sid = :sid")})
public class CustomerList implements Serializable {

    private static final long serialVersionUID = 1L;

    //    commented by me
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "SID")
    private short sid;
}
