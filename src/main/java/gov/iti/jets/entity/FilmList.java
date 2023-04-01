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
@Table(name = "film_list")
@NamedQueries({
    @NamedQuery(name = "FilmList.findAll", query = "SELECT f FROM FilmList f")
    , @NamedQuery(name = "FilmList.findByFid", query = "SELECT f FROM FilmList f WHERE f.fid = :fid")
    , @NamedQuery(name = "FilmList.findByTitle", query = "SELECT f FROM FilmList f WHERE f.title = :title")
    , @NamedQuery(name = "FilmList.findByCategory", query = "SELECT f FROM FilmList f WHERE f.category = :category")
    , @NamedQuery(name = "FilmList.findByPrice", query = "SELECT f FROM FilmList f WHERE f.price = :price")
    , @NamedQuery(name = "FilmList.findByLength", query = "SELECT f FROM FilmList f WHERE f.length = :length")
    , @NamedQuery(name = "FilmList.findByRating", query = "SELECT f FROM FilmList f WHERE f.rating = :rating")})
public class FilmList implements Serializable {

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
