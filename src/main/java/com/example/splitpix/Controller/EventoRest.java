package com.example.splitpix.Controller;

import com.example.splitpix.Enum.StatusEvento;
import com.example.splitpix.Model.Evento;
import com.example.splitpix.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/evento")
public class EventoRest {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/getAllEvents")
    public List<Evento> listAllEvents(){
        return eventoRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvento(@RequestBody Evento evento){

        if(evento.getStatus() == null){
            evento.setStatus(StatusEvento.ATIVO);
        }
        Evento novoEvento = eventoRepository.save(evento);
        return ResponseEntity.ok(novoEvento);
    }
}
