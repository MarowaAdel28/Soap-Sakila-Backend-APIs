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
@Table(name = "sales_by_film_category")
@NamedQueries({
    @NamedQuery(name = "SalesByFilmCategory.findAll", query = "SELECT s FROM SalesByFilmCategory s")
    , @NamedQuery(name = "SalesByFilmCategory.findByCategory", query = "SELECT s FROM SalesByFilmCategory s WHERE s.category = :category")
    , @NamedQuery(name = "SalesByFilmCategory.findByTotalSales", query = "SELECT s FROM SalesByFilmCategory s WHERE s.totalSales = :totalSales")})
public class SalesByFilmCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // by me
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_sales")
    private BigDecimal totalSales;
}
