package ar.com.bluesoftware.universidad.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 *
 * @author Juan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inscripciones")
public class Inscripcion  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripto;

    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia materia;

    // Valor por defecto: true para indicar que la inscripción está activa
    private Boolean estado = true;
}