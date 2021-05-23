package da.camerarestapi.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    public List<Camera> findAll() {
        List<Camera> listCamera = cameraRepository.findAll();
        return listCamera;
    }

    public Camera findById(String id) {
        Camera camera = cameraRepository.findByStringId(id);
        return camera;
    }

    public Camera createCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    public void updateCamera(Camera camera, String id) {
        Camera cameraOptional = cameraRepository.findByStringId(id);
        cameraOptional.setName(camera.getName());
        cameraOptional.setModel(camera.getModel());
        cameraRepository.save(camera);
    }

    public void deleteCamera(String id) {
        boolean exists = cameraRepository.existsById(id);
        if(!exists){throw new IllegalStateException("camera with id" + id +" does not exist");}
        cameraRepository.deleteById(id);
    }
}
