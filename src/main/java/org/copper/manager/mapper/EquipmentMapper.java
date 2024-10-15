package org.copper.manager.mapper;

import org.copper.manager.dto.request.EquipmentRequest;
import org.copper.manager.dto.response.EquipmentResponse;
import org.copper.manager.entity.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    EquipmentResponse toResponse(Equipment entity);

    List<EquipmentResponse> toResponseList(List<Equipment> entities);

    @Mapping(target = "area.id", source = "areaId")
    @Mapping(target = "status.id", source = "statusId")
    Equipment toEntity(EquipmentRequest request);
}
