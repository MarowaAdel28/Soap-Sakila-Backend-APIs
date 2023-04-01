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
@Table(name = "sales_by_store")
@NamedQueries({
    @NamedQuery(name = "SalesByStore.findAll", query = "SELECT s FROM SalesByStore s")
    , @NamedQuery(name = "SalesByStore.findByStore", query = "SELECT s FROM SalesByStore s WHERE s.store = :store")
    , @NamedQuery(name = "SalesByStore.findByManager", query = "SELECT s FROM SalesByStore s WHERE s.manager = :manager")
    , @NamedQuery(name = "SalesByStore.findByTotalSales", query = "SELECT s FROM SalesByStore s WHERE s.totalSales = :totalSales")})
public class SalesByStore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // by me
    @Column(name = "store")
    private String store;
    @Column(name = "manager")
    private String manager;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_sales")
    private BigDecimal totalSales;
}
