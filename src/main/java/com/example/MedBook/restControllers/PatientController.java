package com.example.MedBook.restControllers;

import com.example.MedBook.Entities.Patient;
import com.example.MedBook.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by uuuu on 4/4/2018.
 */

@RestController
@RequestMapping("/")
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/api/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/api/patients")
    public List<Patient> findPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @GetMapping("/api/patients/{id}")
    public Patient findById(@PathVariable(value = "id") Long patientId) {
        Optional<Patient> patient = Optional.of(patientRepository.getOne(patientId));
        return patient.get();
    }

    @DeleteMapping("/api/patients/{id}")
    public void deleteById(@PathVariable(value = "id") Long patientId) {
        patientRepository.deleteById(patientId);
    }


    @DeleteMapping("/api/patients")
    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }

    @PutMapping("/api/patients")
    public Patient addComment(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/api/patients/search/{name}")
    public List<Patient> findPatientsByName(@PathVariable(value = "name") String name) {

        return this.patientRepository.findPatientsByNameIsStartingWithIgnoreCase(name);
    }

}
