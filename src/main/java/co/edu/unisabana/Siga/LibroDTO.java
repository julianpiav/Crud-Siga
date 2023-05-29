package co.edu.unisabana.Siga;
import lombok.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibroDTO {

    @NotEmpty(message = "The full name is required.")
    @NotNull(message = "Mande el campo!")

    private int ISBN;
    @NotNull(message = "Mande el campo!")
    @Min(1)
    @Max(12)

    private String titulo;

    private String autor;

    private Enum categoria;

    private Boolean disponible;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroDTO that = (LibroDTO) o;
        return ISBN == that.ISBN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
