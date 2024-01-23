package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.request.RegionDTORequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T18:08:47+0100",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RegionMapperImpl implements RegionMapper {

    @Override
    public Region toEntity(RegionDTORequest request) {
        if ( request == null ) {
            return null;
        }

        Region region = new Region();

        region.setNomRegion( request.getNomRegion() );

        return region;
    }

    @Override
    public RegionDTORequest toDto(Region entity) {
        if ( entity == null ) {
            return null;
        }

        RegionDTORequest.RegionDTORequestBuilder regionDTORequest = RegionDTORequest.builder();

        regionDTORequest.nomRegion( entity.getNomRegion() );

        return regionDTORequest.build();
    }
}
