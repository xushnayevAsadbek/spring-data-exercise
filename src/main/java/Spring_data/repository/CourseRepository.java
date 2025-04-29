package Spring_data.repository;

import Spring_data.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    List<CourseEntity> findByName(String name);
    List<CourseEntity> findByPrice(double price);
    List<CourseEntity> findByDuration(Integer duration);

}
