package comics;

import java.io.Serializable;
import java.util.List;

public record Comic(String title, List<Chapter> chapters) implements Serializable {
}
