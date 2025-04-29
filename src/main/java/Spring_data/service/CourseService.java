package Spring_data.service;

import Spring_data.dto.CourseDTO;
import Spring_data.dto.StudentDTO;
import Spring_data.entity.CourseEntity;
import Spring_data.entity.StudentEntity;
import Spring_data.repository.CourseRepository;
import Spring_data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    public CourseRepository courseRepository;
    public CourseDTO create(CourseDTO dto) {
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(LocalDateTime.now());
        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public  List<CourseDTO>  getAll (){
        Iterable<CourseEntity> iterable = courseRepository.findAll() ;
        List<CourseDTO> course = new LinkedList<>();
        for (CourseEntity entity : iterable) {
            course.add(toDTO(entity));
        }
        return course;
    }

    public CourseDTO getById(Integer id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()){
            return null;}
        CourseEntity entity = optional.get();
        return toDTO(entity);
    }
    public  CourseDTO upDate(Integer id , CourseDTO dto){
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        CourseEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        courseRepository.save(entity);
        return dto;
    }
    public void delete (Integer id) {
        courseRepository.deleteById(id);
    }
    public  List<CourseDTO>  getbyName(String name){
        Iterable<CourseEntity> iterable = courseRepository.findByName(name);
        List<CourseDTO> course = new LinkedList<>();
        for (CourseEntity entity : iterable) {
            course.add(toDTO(entity));
        }
        return course;

    }
    public List<CourseDTO> getByPrice(Double price) {
        Iterable<CourseEntity> iterable = courseRepository.findByPrice(price);
        List<CourseDTO> course = new LinkedList<>();
        for (CourseEntity entity : iterable){
            course.add(toDTO(entity));
        }
        return course;

    }
    public List<CourseDTO> getByDuration(Integer duration) {
        Iterable<CourseEntity> iterable = courseRepository.findByDuration(duration);
        List<CourseDTO> course = new LinkedList<>();
        for (CourseEntity entity : iterable){
            course.add(toDTO(entity));
        }
    return course;
    }
    public CourseDTO toDTO(CourseEntity entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
}
