package org.agilo.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agilo_test")
@Builder
public class Agilo {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String data;

}
