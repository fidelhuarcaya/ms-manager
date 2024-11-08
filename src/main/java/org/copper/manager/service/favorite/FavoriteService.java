package org.copper.manager.service.favorite;

import org.copper.manager.dto.request.FavoriteRequest;
import org.copper.manager.dto.response.FavoriteResponse;

import java.util.List;

public interface FavoriteService {
    List<FavoriteResponse> getByUserEmail(String email);

    FavoriteResponse save(FavoriteRequest favoriteRequest);

    void delete(Long documentId);
}
