package da.camerarestapi.restapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CameraRepository extends MongoRepository<Camera, ObjectId> {
    List<Camera> findAll();

    Optional<Camera> findById(String id);
}
