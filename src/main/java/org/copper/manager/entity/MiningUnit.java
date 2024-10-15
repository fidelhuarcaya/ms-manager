package org.copper.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mining_unit")
public class MiningUnit extends Auditable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url_logo")
    private String urlLogo;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}