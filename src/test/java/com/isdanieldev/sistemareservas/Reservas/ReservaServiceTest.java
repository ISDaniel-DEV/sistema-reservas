package com.isdanieldev.sistemareservas.Reservas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservaServiceTest {

    private ReservaService reservaService = new ReservaService();

    @Test
    @DisplayName("Permite reservar dos salas distintas a la misma hora")
    void permiteReservaOtraSalaEnElMismoHorario(){

        reservaService.crearReserva(
                "Sala 3",
                LocalDateTime.of(2026, 12, 1, 18, 0),
                LocalDateTime.of(2026, 12, 1, 19, 0)
        );

        reservaService.crearReserva(
                "Sala 4",
                LocalDateTime.of(2026, 12, 1, 18, 0),
                LocalDateTime.of(2026, 12, 1, 19, 0)
        );

        assertEquals(2, reservaService.listarReservas().size());

        System.out.println("Permite reservar dos salas distintas a la misma hora :))");
    }


    @Test
    void rechazaReservasSolapadasEnLaMismaSala(){

        reservaService.crearReserva(
                "Sala 5",
                LocalDateTime.of(2026, 12, 1, 17, 0),
                LocalDateTime.of(2026, 12, 1, 18, 30)
        );

        assertThrows(ReservaSolapadaException.class,() ->
                reservaService.crearReserva(
                "Sala 5",
                LocalDateTime.of(2026, 12, 1, 18, 0),
                LocalDateTime.of(2026, 12, 1, 19, 0)
                )
        );

        assertEquals(1, reservaService.listarReservas().size());

        System.out.println("");
        System.out.println("|| Rechasa reservas solapadas de misma sala ||");

    }

    @Test
    void permiteReservaConsecutivasEnLaMismaSala(){

        reservaService.crearReserva(
                "Sala 6",
                LocalDateTime.of(2026, 12, 1, 18, 0),
                LocalDateTime.of(2026, 12, 1, 19, 0)
        );

        reservaService.crearReserva(
                "Sala 6",
                LocalDateTime.of(2026, 12, 1, 19, 0),
                LocalDateTime.of(2026, 12, 1, 20, 0)
        );

        assertEquals(2, reservaService.listarReservas().size());

        System.out.println("Permite reservas consecutivas en la misma sala :))");
    }

}
