package fr.uga.miage.m1.exception.technical;

import lombok.Getter;

@Getter
public class FestivalEntityNotFoundException extends Exception {
    private final Long festivalId;

    public FestivalEntityNotFoundException(String message, Long festivalId
    ) {
        super(message);
        this.festivalId = festivalId;
    }

}
