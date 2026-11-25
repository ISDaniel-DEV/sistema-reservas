package com.isdanieldev.sistemareservas.Reservas;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reserva {
    private final UUID id;
    private final String recursoId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public UUID getId(){
        return id;
    }

    public String getRecursoId(){
        return recursoId;
    }


    public LocalDateTime getStartDate(){
        return startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }

    public Reserva(UUID id, String recursoId, LocalDateTime startDate, LocalDateTime endDate){
        this.id = id;
        this.recursoId = recursoId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}