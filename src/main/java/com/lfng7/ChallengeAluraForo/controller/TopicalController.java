package com.lfng7.ChallengeAluraForo.controller;

import com.lfng7.ChallengeAluraForo.domain.topical.TopicalService;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalCreateDto;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalGetDto;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalUpdateDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicals")
public class TopicalController {

    private final TopicalService topicalService;

    @Autowired
    public TopicalController(TopicalService topicalService) {
        this.topicalService = topicalService;
    }

    /*
    *  METODOS
    */

    //Obtener todos
    @GetMapping("/all")
    public ResponseEntity<Page<TopicalGetDto>> getAllTopicals(
            @PageableDefault(size = 10) Pageable pagination,
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "topicalYear", required = false) String topicalYear) {
        return ResponseEntity.ok(topicalService.findByCourseName(pagination, courseName, topicalYear));
    }

    //Obtener registro por id
    @GetMapping("/{id}")
    public ResponseEntity<TopicalGetDto> getTopicalById(@NotNull @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(topicalService.findById(id));
    }

    //Insertar registro
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<TopicalGetDto> createTopical(UriComponentsBuilder uriComponentsBuilder, @RequestBody @Valid TopicalCreateDto topical) {
        TopicalGetDto topicalDto = topicalService.save(topical);
        URI url = uriComponentsBuilder.path("/topicals/{id}").buildAndExpand(topicalDto.id()).toUri();
        return ResponseEntity.created(url).body(topicalDto);
    }

    //Actualizar registro
    @PutMapping
    @Transactional
    public ResponseEntity<TopicalGetDto> updateTopical(@RequestBody @Valid TopicalUpdateDto topical) {
        return ResponseEntity.ok(topicalService.update(topical));
    }

    //Eliminar registro
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTopical(@NotNull @PathVariable(name = "id") Long id) {
        topicalService.deleteTopical(id);
        return ResponseEntity.noContent().build();
    }
}