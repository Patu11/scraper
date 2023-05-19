package comics;

import java.io.Serializable;
import java.util.List;

public record Chapter(String title, List<Page> pages) implements Serializable {
}
