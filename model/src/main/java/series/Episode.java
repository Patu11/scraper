package series;

import java.io.Serializable;

public record Episode(String title, String premiere) implements Serializable {
}
