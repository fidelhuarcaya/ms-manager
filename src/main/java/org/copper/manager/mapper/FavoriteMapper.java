package org.copper.manager.mapper;

import org.copper.manager.dto.request.FavoriteRequest;
import org.copper.manager.dto.response.FavoriteResponse;
import org.copper.manager.entity.Favorite;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentMapper.class})
public interface FavoriteMapper {
    Favorite toEntity(FavoriteRequest request);

    FavoriteResponse toDto(Favorite favorite);

    List<FavoriteResponse> toDtoList(List<Favorite> favorites);
}