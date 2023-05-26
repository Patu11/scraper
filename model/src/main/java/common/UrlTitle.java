package common;

import java.io.Serializable;

public record UrlTitle(String url, String title) implements Serializable {
}
