package org.copper.manager.dto.response;

import lombok.Value;
import org.copper.manager.entity.User;

import java.io.Serializable;

/**
 * DTO for {@link org.copper.manager.entity.Favorite}
 */
@Value
public class FavoriteResponse implements Serializable {
    Long id;
    User user;
    DocumentResponse document;
}