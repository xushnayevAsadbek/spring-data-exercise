package Spring_data.service;

import Spring_data.dto.StudentDTO;
import Spring_data.entity.StudentEntity;
import Spring_data.enums.Gender;
import Spring_data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
   public StudentRepository studentRepository;
    public StudentDTO create(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setLevel(dto.getLevel());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setCreatedDate(LocalDateTime.now());
        studentRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> iterable = studentRepository.findAll() ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public StudentDTO getById(Integer id) {
    Optional<StudentEntity> optional = studentRepository.findById(id);
    if (optional.isEmpty()){
        return null;}
    StudentEntity entity = optional.get();
    return toDTO(entity);
    }

    public StudentDTO update(Integer id , StudentDTO dto) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        StudentEntity entity = optional.get();
       entity.setName(dto.getName());
       entity.setSurname(dto.getSurname());
       entity.setLevel(dto.getLevel());
       entity.setAge(dto.getAge());
       entity.setGender(dto.getGender());
       studentRepository.save(entity);

      return dto ;
    }
    public void delete (Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> getbyName(String name) {
        Iterable<StudentEntity> iterable = studentRepository.findByName(name) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }
    public List<StudentDTO> getbySurname(String surname) {
        Iterable<StudentEntity> iterable = studentRepository.findBySurname(surname) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public List<StudentDTO> getbyAge(Integer age) {
        Iterable<StudentEntity> iterable = studentRepository.findByAge(age) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }
    public List<StudentDTO> getbyLevel(Integer level) {
        Iterable<StudentEntity> iterable = studentRepository.findByLevel(level) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }
    public List<StudentDTO> getbyGender(Gender gender) {
        Iterable<StudentEntity> iterable = studentRepository.findByGender(gender) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public List<StudentDTO> getByGivenDate(LocalDate givenDate) {
        LocalDateTime from = LocalDateTime.of(givenDate , LocalTime.MIN);
        LocalDateTime to = LocalDateTime.of(givenDate , LocalTime.MAX);
        Iterable<StudentEntity> iterable = studentRepository.findByCreatedDateBetween(from, to) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public List<StudentDTO> getByGivenDates(LocalDate fromDate , LocalDate toDate ) {
        LocalDateTime from = LocalDateTime.of(fromDate , LocalTime.MIN);
        LocalDateTime to = LocalDateTime.of(toDate , LocalTime.MAX);
        Iterable<StudentEntity> iterable = studentRepository.findByCreatedDateBetween(from, to) ;
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : iterable) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public StudentDTO toDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setLevel(entity.getLevel());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setCreatedDate(entity.getCreatedDate());
      return dto;
    }


}
