package com.example.splitpix.Controller;

import com.example.splitpix.DTO.UpdateEventDTO;
import com.example.splitpix.Enum.StatusEvent;
import com.example.splitpix.Model.Event;
import com.example.splitpix.Repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/rest/evento")
public class EventoRest {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/getAllEvents")
    public List<Event> listAllEvents(){
        return eventRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event){

        if(event.getStatus() == null){
            event.setStatus(StatusEvent.ATIVO);
        }
        Event novoEvent = eventRepository.save(event);
        return ResponseEntity.ok(novoEvent);
    }

    @PutMapping("/editEvent/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody UpdateEventDTO dto) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Event event = eventOptional.get();
        event.setNome(dto.getNome());
        event.setValorTotal(dto.getValorTotal());
        event.setChavePix(dto.getChavePix());
        event.setLinkUnico(dto.getLinkUnico());
        try {
            event.setStatus(StatusEvent.valueOf(dto.getStatus().toUpperCase()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Status inválido! Use um valor válido.");
        }
        eventRepository.save(event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        if(eventRepository.existsById(id)){
            eventRepository.deleteById(id);
            return ResponseEntity.ok("evento deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado!");
        }
    }

}
