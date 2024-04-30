package ar.com.bluesoftware.universidad.entidades;


import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 *
 * @author Juan
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "materia")
public class Materia  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateria;

    private String nombre;

    private Integer anio;

    @Column(nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "materia")
    private List<Inscripcion> inscripciones;
}