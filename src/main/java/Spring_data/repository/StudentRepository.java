package Spring_data.repository;

import Spring_data.entity.StudentEntity;
import Spring_data.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    List<StudentEntity> findByName(String name);

    List<StudentEntity> findBySurname(String surname);

    List<StudentEntity> findByAge(Integer age);

    List<StudentEntity> findByLevel(Integer level);

    List<StudentEntity> findByGender(Gender gender);

}
