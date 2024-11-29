package com.lfng7.ChallengeAluraForo.domain.topical;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicalRepository extends JpaRepository<TopicalEntity, Long> {

    /*
    * Query personalizado para buscar por parametros en la url el topico segun el curso o
    * el año de creacion del topico
    */
    @Query("""
            SELECT topical 
            FROM TopicalEntity topical 
            JOIN topical.course course
            WHERE course.name LIKE %:courseName%
            AND topical.createdAt LIKE %:topicalYear%
            ORDER BY topical.createdAt ASC
            """)
    Page<TopicalEntity> searchByCourseNameAndTopicYear(
            Pageable pagintaion,
            @Param("courseName")
            String courseName,
            @Param("topicalYear")
            String topicalYear);
}
