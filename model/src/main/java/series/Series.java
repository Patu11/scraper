package series;

import java.io.Serializable;
import java.util.List;

public record Series(String title, List<Season> seasons) implements Serializable {
}
