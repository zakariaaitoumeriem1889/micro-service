package org.sid.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScolariteRestController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @GetMapping("/students")
    public List<Student> student() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable("id") Long id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("/")
    public Student save(@RequestBody Student student) {
        if (student.getLaboratory().getId() == null) {
            Laboratory laboratory = laboratoryRepository.save(student.getLaboratory());
            student.setLaboratory(laboratory);
        }
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        studentRepository.deleteById(id);
    }
}
