package org.copper.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.copper.manager.common.ResourceCode;

@Getter
@Setter
@Entity
@Table(name = "resource_type")
public class ResourceType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "code")
    private ResourceCode code;

}
