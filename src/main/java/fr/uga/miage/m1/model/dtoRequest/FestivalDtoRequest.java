package fr.uga.miage.m1.model.dtoRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FestivalDtoRequest {
    private Long idFestival;
    private int nombrePlacesAjouter;
}
