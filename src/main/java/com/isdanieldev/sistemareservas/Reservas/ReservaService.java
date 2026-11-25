package com.isdanieldev.sistemareservas.Reservas;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {

    private final List<Reserva> reservas = new ArrayList<>();

    public Reserva crearReserva(String recursoId, LocalDateTime startDate, LocalDateTime endDate){

        if(!endDate.isAfter(startDate)){
            throw new IllegalArgumentException("La fecha del fin debe ser posterior a la de inicio");
        }
        for(Reserva existente : reservas){
            if(recursoId.equals(existente.getRecursoId())){
                if(startDate.isBefore(existente.getEndDate()) && endDate.isAfter(existente.getStartDate())){
                    throw new ReservaSolapadaException("El horario se solapa con otra reserva");
                }
            }
        }
        UUID id = UUID.randomUUID();
        Reserva reserva = new Reserva(id,recursoId,startDate,endDate);
        reservas.add(reserva);

        return reserva;
    }

    public List<Reserva> listarReservas(){
        return List.copyOf(reservas);
    }

}
