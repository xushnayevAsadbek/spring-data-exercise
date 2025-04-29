package Spring_data.controller;

import Spring_data.dto.CourseDTO;
import Spring_data.dto.StudentDTO;
import Spring_data.service.CourseService;
import Spring_data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("")
    private ResponseEntity<CourseDTO> create(@RequestBody CourseDTO dto) {
        CourseDTO result = courseService.create(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("")
    private ResponseEntity<List<CourseDTO>> all() {
        return ResponseEntity.ok(courseService.getAll());
    }

}
