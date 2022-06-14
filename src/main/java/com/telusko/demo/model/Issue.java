package com.telusko.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "issue", schema = "heroku_cef244ec48cfcf7", indexes = {
        @Index(name = "equipmentId", columnList = "equipmentId")
})
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipmentId", nullable = false)
    @ToString.Exclude
    private Equipment equipment;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "location")
    private String location;

}