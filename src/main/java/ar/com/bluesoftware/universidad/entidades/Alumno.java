package ar.com.bluesoftware.universidad.entidades;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
@ToString(exclude = "inscripciones")  // Excluir la lista de inscripciones para evitar posibles desbordamientos de memoria
@Entity
@Table(name = "alumno")
public class Alumno  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @Column(unique = true, nullable = false)  // Asegurar que el DNI sea único y no nulo
    private Integer dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private LocalDate fechaNac;

    private String telefono;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones;

    @Column(nullable = false)
    private boolean estado;
}
