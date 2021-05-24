package da.camerarestapi.restapi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends MongoRepository<Camera, String> {
    List<Camera> findAll();

    Camera findByStringId(String id);
}
