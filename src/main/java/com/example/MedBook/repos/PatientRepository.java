package com.example.MedBook.repos;

import com.example.MedBook.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by uuuu on 4/4/2018.
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findPatientsByNameIsStartingWithIgnoreCase(String name);
}
