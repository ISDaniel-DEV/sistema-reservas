package com.isdanieldev.sistemareservas.Reservas;

import java.time.LocalDateTime;

public class Reserva {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public LocalDateTime getStartDate(){
        return startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }

    public Reserva(LocalDateTime startDate,LocalDateTime endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
}