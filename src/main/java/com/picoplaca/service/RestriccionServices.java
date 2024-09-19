package com.picoplaca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picoplaca.model.Restriccion;
import com.picoplaca.repository.RestriccionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class RestriccionServices {

    @Autowired
    private RestriccionRepository restriccionRepository;

    public String verificarRestriccion(String placa, String fecha, String hora) {
        // Extraer el último dígito de la placa
        char ultimoDigito = placa.charAt(placa.length() - 1);

        // Parsear la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        LocalTime localTime = LocalTime.parse(hora);

        // Obtener el día de la semana
        String diaSemana = localDate.getDayOfWeek().toString().toLowerCase();

        // Buscar la restricción en la base de datos
        Optional<Restriccion> optionalRestriccion = restriccionRepository.findById(Integer.parseInt(String.valueOf(ultimoDigito)));

        if (optionalRestriccion.isEmpty()) {
            return "No hay restricciones para el último dígito de la placa.";
        }

        Restriccion restriccion = optionalRestriccion.get();

        // Verificar si el día de la semana y la hora están dentro de las restricciones
        if (diaSemana.equals(restriccion.getDiaSemana())) {
            if (localTime.isAfter(restriccion.getStartTimeMorning()) && localTime.isBefore(restriccion.getEndTimeMorning())
                || localTime.isAfter(restriccion.getStartTimeAfternoon()) && localTime.isBefore(restriccion.getEndTimeAfternoon())) {
                return "No puede circular en este horario.";
            }
        }

        return "Puede circular en este horario.";
    }
}
