package Spring_data.controller;

import Spring_data.dto.CourseDTO;
import Spring_data.dto.StudentDTO;
import Spring_data.entity.CourseEntity;
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

    @GetMapping("/{id}")
    private ResponseEntity<CourseDTO> byId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(courseService.getById(id));
    }
    @PutMapping("/{id}")
    private ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id ,
                                             @RequestBody CourseDTO dto) {
        CourseDTO result = courseService.upDate(id, dto);
        return ResponseEntity.ok(result);
    }
        @DeleteMapping("/{id}")

       private ResponseEntity<CourseDTO> delete(@PathVariable("id") Integer id){
            courseService.delete(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/by-name/{name}")
    private ResponseEntity<List<CourseDTO>> byName(@PathVariable("name") String name) {
            return  ResponseEntity.ok(courseService.getbyName(name));
        }
    @GetMapping("/by-price")
    private ResponseEntity<List<CourseDTO>> byPrice(@RequestParam("price") double price) {
        return  ResponseEntity.ok(courseService.getByPrice(price));
    }
    @GetMapping("/by-duration")
    private ResponseEntity<List<CourseDTO>> byDuration (@RequestParam("duration") Integer duration ) {
        return  ResponseEntity.ok(courseService.getByDuration(duration ));
    }
    }


