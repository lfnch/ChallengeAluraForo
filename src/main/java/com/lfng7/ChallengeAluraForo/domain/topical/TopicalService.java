package com.lfng7.ChallengeAluraForo.domain.topical;

import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalCreateDto;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalGetDto;
import com.lfng7.ChallengeAluraForo.domain.topical.dto.TopicalUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicalService {

    private final TopicalRepository topicalRepository;

    @Autowired
    public TopicalService(TopicalRepository topicalRepository) {
        this.topicalRepository = topicalRepository;
    }

    /*
     *  METODOS
     */

    //Obtener todos
    public Page<TopicalGetDto> getAllTopicals(Pageable pagination) {
        return topicalRepository.findAll(pagination).map(TopicalGetDto::new);
    }

    //Obtener registro por id
    public TopicalGetDto findById(Long id) {
        Optional<TopicalEntity> topicalSearch = topicalRepository.findById(id);
        if(topicalSearch.isEmpty()) throw new EntityNotFoundException();
        return topicalSearch.map(TopicalGetDto::new).get();
    }

    //Obtener por nombre curso
    public Page<TopicalGetDto> findByCourseName(Pageable pagination, String courseName , String topicalYear) {
        if(courseName == null){ courseName = ""; }
        if(topicalYear == null) { topicalYear = ""; }
        return topicalRepository.searchByCourseNameAndTopicYear(pagination, courseName, topicalYear).map(TopicalGetDto::new);
    }

    //Insertar registro
    public TopicalGetDto save(TopicalCreateDto topicalDto) {
        TopicalEntity saveEntity = topicalRepository.save(new TopicalEntity(topicalDto));
        return new TopicalGetDto(saveEntity);
    }

    //Actualizar registro
    public TopicalGetDto update(TopicalUpdateDto topicalDto) {
        TopicalEntity topical = topicalRepository.getReferenceById(topicalDto.id());
        topical.updateTopical(topicalDto);
        topicalRepository.save(topical);
        return new TopicalGetDto(topical);
    }

    //Eliminar registro
    public void deleteTopical(Long id) {
        Optional<TopicalEntity> topicalSearch = topicalRepository.findById(id);
        if(topicalSearch.isEmpty()) throw new EntityNotFoundException();
        topicalRepository.deleteById(id);
    }
}
