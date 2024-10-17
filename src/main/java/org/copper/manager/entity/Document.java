package org.copper.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "craft_id")
    private Craft craft;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}