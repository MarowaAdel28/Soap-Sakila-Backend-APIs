/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.iti.jets.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "nicer_but_slower_film_list")
@NamedQueries({
    @NamedQuery(name = "NicerButSlowerFilmList.findAll", query = "SELECT n FROM NicerButSlowerFilmList n")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByFid", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.fid = :fid")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByTitle", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.title = :title")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByCategory", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.category = :category")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByPrice", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.price = :price")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByLength", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.length = :length")
    , @NamedQuery(name = "NicerButSlowerFilmList.findByRating", query = "SELECT n FROM NicerButSlowerFilmList n WHERE n.rating = :rating")})
public class NicerButSlowerFilmList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // by me
    @Basic(optional = false)
    @Column(name = "FID")
    private short fid;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "length")
    private Short length;
    @Column(name = "rating")
    private String rating;
    @Lob
    @Column(name = "actors")
    private String actors;
    
}
