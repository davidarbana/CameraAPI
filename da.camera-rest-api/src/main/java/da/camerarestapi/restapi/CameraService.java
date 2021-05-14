package da.camerarestapi.restapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    public List<Camera> findAll() {
        List<Camera> listCamera = cameraRepository.findAll();
        return listCamera;
    }

    public Optional<Camera> findById(ObjectId id) {
        Optional<Camera> camera = cameraRepository.findById(id);
        return camera;
    }

    public Camera createCamera(Camera camera) {
        Optional<Camera> cameraOptional = cameraRepository.findById(camera.getId());
        if(cameraOptional.isPresent()){
            throw new IllegalStateException("Id taken");
        }
        return cameraRepository.save(camera);
    }
}
