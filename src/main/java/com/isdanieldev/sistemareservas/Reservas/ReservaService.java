package com.isdanieldev.sistemareservas.Reservas;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private final List<Reserva> reservas = new ArrayList<>();

    public Reserva crearReserva(LocalDateTime startDate, LocalDateTime endDate){

        if(!endDate.isAfter(startDate)){
            throw new IllegalArgumentException("La fecha del fin debe ser posterior a la de inicio");
        }

        Reserva reserva = new Reserva(startDate,endDate);
        reservas.add(reserva);

        return reserva;
    }

    public List<Reserva> listarReservas(){
        return List.copyOf(reservas);
    }

}
