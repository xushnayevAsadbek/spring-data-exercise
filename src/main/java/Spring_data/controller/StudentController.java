package Spring_data.controller;

import Spring_data.dto.StudentDTO;
import Spring_data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("")
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
    StudentDTO result = studentService.create(dto);
    return ResponseEntity.ok(result);
    }
    @GetMapping("")
    private ResponseEntity<List<StudentDTO>> all() {
        return ResponseEntity.ok(studentService.getAll());
    }
    @GetMapping("/{id}")
    private ResponseEntity<StudentDTO> byId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }
    @PutMapping("/{id}")
    private ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id,
                                              @RequestBody StudentDTO dto) {
        StudentDTO result = studentService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<StudentDTO> delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/by-name/{name}")
    private ResponseEntity<List<StudentDTO>> byName(@PathVariable("name") String name) {
        return ResponseEntity.ok(studentService.getbyName(name));
    }

}
