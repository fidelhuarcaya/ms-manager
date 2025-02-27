package org.copper.manager.service.favorite;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.FavoriteRequest;
import org.copper.manager.dto.response.FavoriteResponse;
import org.copper.manager.jwt.JwtService;
import org.copper.manager.mapper.FavoriteMapper;
import org.copper.manager.repository.FavoriteRepository;
import org.copper.manager.service.common.context.ContextService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService{
    private final FavoriteRepository favoriteRepository;
    private final ContextService contextService;
    private final FavoriteMapper favoriteMapper;

    @Override
    public List<FavoriteResponse> getByUserEmail(String email) {
        return favoriteMapper.toDtoList(favoriteRepository.findByUserEmail(email));
    }

    @Override
    public FavoriteResponse save(FavoriteRequest favoriteRequest) {
        return favoriteMapper.toDto(favoriteRepository.save(favoriteMapper.toEntity(favoriteRequest)));
    }


    @Override
    public void delete(Long documentId) {
        String email = contextService.getCurrentUser().getEmail();
        favoriteRepository.deleteByUserIdAndFavoriteId(email, documentId);
    }
}
