package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.response.FestivalDTOresponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T18:08:47+0100",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class FestivalMapperImpl implements FestivalMapper {

    @Override
    public FestivalDTOresponse toDto(Festival Festival) {
        if ( Festival == null ) {
            return null;
        }

        FestivalDTOresponse.FestivalDTOresponseBuilder festivalDTOresponse = FestivalDTOresponse.builder();

        festivalDTOresponse.festivalId( Festival.getFestivalId() );
        festivalDTOresponse.nomFestival( Festival.getNomFestival() );
        festivalDTOresponse.tarif( Festival.getTarif() );
        festivalDTOresponse.siteWeb( Festival.getSiteWeb() );
        festivalDTOresponse.dateDebut( Festival.getDateDebut() );
        festivalDTOresponse.dateFin( Festival.getDateFin() );
        festivalDTOresponse.lieuPrincipal( Festival.getLieuPrincipal() );
        festivalDTOresponse.nombrePass( Festival.getNombrePass() );

        return festivalDTOresponse.build();
    }

    @Override
    public Festival toEntity(FestivalDTORequest request) {
        if ( request == null ) {
            return null;
        }

        Festival festival = new Festival();

        festival.setFestivalId( request.getFestivalId() );
        festival.setNomFestival( request.getNomFestival() );
        festival.setTarif( request.getTarif() );
        festival.setSiteWeb( request.getSiteWeb() );
        festival.setDateDebut( request.getDateDebut() );
        festival.setDateFin( request.getDateFin() );
        festival.setLieuPrincipal( request.getLieuPrincipal() );
        festival.setNombrePass( request.getNombrePass() );

        return festival;
    }
}
