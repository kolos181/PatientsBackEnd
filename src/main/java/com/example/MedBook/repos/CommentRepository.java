package com.example.MedBook.repos;

import com.example.MedBook.Entities.Comments;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by uuuu on 4/4/2018.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
    @Query("select c from Comments c inner join c.patient where c.patient.id = :patientId")
    List<Comments> findPatientWithComments(@Param("patientId") Long patientId);
}
