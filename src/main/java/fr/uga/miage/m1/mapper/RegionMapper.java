package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.request.RegionDTORequest;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface RegionMapper {
    Region toEntity(RegionDTORequest request);
    RegionDTORequest toDto(Region entity);
}
