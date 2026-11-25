package com.isdanieldev.sistemareservas.Reservas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    private record CrearReservaRequest(
            String recursoId,
            LocalDateTime startDate,
            LocalDateTime endDate
    ){}

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> crearReserva(@RequestBody CrearReservaRequest solicitud){

        try {
            Reserva reserva = reservaService.crearReserva(
                    solicitud.recursoId(),
                    solicitud.startDate(),
                    solicitud.endDate()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }catch (ReservaSolapadaException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/reservas")
    public List<Reserva> listarReserva(){
        return reservaService.listarReservas();
    }

}
