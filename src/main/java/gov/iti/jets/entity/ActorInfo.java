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
@Table(name = "actor_info")
@NamedQueries({
    @NamedQuery(name = "ActorInfo.findAll", query = "SELECT a FROM ActorInfo a")
    , @NamedQuery(name = "ActorInfo.findByActorId", query = "SELECT a FROM ActorInfo a WHERE a.actorId = :actorId")
    , @NamedQuery(name = "ActorInfo.findByFirstName", query = "SELECT a FROM ActorInfo a WHERE a.firstName = :firstName")
    , @NamedQuery(name = "ActorInfo.findByLastName", query = "SELECT a FROM ActorInfo a WHERE a.lastName = :lastName")})
public class ActorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // by me
    @Basic(optional = false)
    @Column(name = "actor_id")
    private short actorId;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Column(name = "film_info")
    private String filmInfo;
}
