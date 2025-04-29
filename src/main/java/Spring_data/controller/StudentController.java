package Spring_data.controller;

import Spring_data.dto.StudentDTO;
import Spring_data.enums.Gender;
import Spring_data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @GetMapping("/by-surname/{surname}")
    private ResponseEntity<List<StudentDTO>> bySurname(@PathVariable("surname") String surname) {
        return ResponseEntity.ok(studentService.getbySurname(surname));
    }

    @GetMapping("/by-age/{age}")
    private ResponseEntity<List<StudentDTO>> byAge(@PathVariable("age") Integer age) {
        return ResponseEntity.ok(studentService.getbyAge(age));
    }
    @GetMapping("/by-level/{level}")
    private ResponseEntity<List<StudentDTO>> byLevel(@PathVariable("level") Integer level) {
        return ResponseEntity.ok(studentService.getbyLevel(level));
    }

    @GetMapping("/by-gender/{gender}")
    private ResponseEntity<List<StudentDTO>> byGender(@PathVariable("gender") Gender gender) {
        return ResponseEntity.ok(studentService.getbyGender(gender));
    }
    @GetMapping("/given-date")
    private ResponseEntity<List<StudentDTO>> byDate(@RequestParam("date") LocalDate date) {
        return ResponseEntity.ok(studentService.getByGivenDate(date));
    }

    @GetMapping("/given-dates")
    private ResponseEntity<List<StudentDTO>> byDates(@RequestParam("fromDate") LocalDate fromDate,
                                                    @RequestParam("toDate") LocalDate toDate) {
        return ResponseEntity.ok(studentService.getByGivenDates(fromDate , toDate));
    }

}
