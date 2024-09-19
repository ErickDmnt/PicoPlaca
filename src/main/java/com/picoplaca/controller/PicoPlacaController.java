package com.picoplaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.picoplaca.model.PicoYPlaca;
import com.picoplaca.service.PicoPlacaPredictor;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PicoPlacaController {

    @Autowired
    private PicoPlacaPredictor predictor;

    @PostMapping("/verificar")
    public Map<String, String> verificarPicoPlaca(@RequestBody Map<String, Object> payload) {
        String plate = (String) payload.get("plate");
        String date = (String) payload.get("date");
        int hour = (int) payload.get("hour");

        PicoYPlaca placa = new PicoYPlaca(plate);
        Map<String, String> response = new HashMap<>();
        try {
            boolean puedeCircular = predictor.puedeCircular(placa, date, hour);

            if (puedeCircular) {
                response.put("message", "El vehículo con placa " + plate + " PUEDE circular.");
               
            } else {
                response.put("message", "El vehículo con placa " + plate + " NO PUEDE circular.");
               
            }
        } catch (ParseException e) {
            response.put("message", "Error: Formato de fecha incorrecto.");
        }

        return response;
    }
}
