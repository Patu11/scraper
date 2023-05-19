package comics;

import java.io.Serializable;

public record ComicResponse(Comic comic) implements Serializable {
}
