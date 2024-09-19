package com.picoplaca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picoplaca.model.PicoYPlaca;
import com.picoplaca.model.Restriccion;
import com.picoplaca.repository.RestriccionRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class PicoPlacaPredictor {

    @Autowired
    private RestriccionRepository restriccionRepository;

    public boolean puedeCircular(PicoYPlaca placa, String fecha, int hora) throws ParseException {
        int ultimoDigito = placa.obtenerUltimoDigito();
        String diaSemana = obtenerDiaSemana(fecha);

        

        Optional<Restriccion> restriccionOpt = restriccionRepository.findById(ultimoDigito);

        if (restriccionOpt.isPresent()) {
            Restriccion restriccion = restriccionOpt.get();
            if (restriccion.getDiaSemana().equalsIgnoreCase(diaSemana)) {
                if ((hora >= 7 && hora < 9) || (hora >= 16 && hora < 20)) {
                    return false;
                }
            }
        }

        return true;
    }

    private String obtenerDiaSemana(String fecha) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = formatoFecha.parse(fecha);

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaDate);

        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        switch (diaSemana) {
            case Calendar.MONDAY:
                return "Lunes";
            case Calendar.TUESDAY:
                return "Martes";
            case Calendar.WEDNESDAY:
                return "Miércoles";
            case Calendar.THURSDAY:
                return "Jueves";
            case Calendar.FRIDAY:
                return "Viernes";
            default:
                return "Fin de Semana";
        }
    }
}
