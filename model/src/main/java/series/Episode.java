package series;

import java.io.Serializable;
import java.time.LocalDate;

public record Episode(String title, LocalDate premiere) implements Serializable {
}
