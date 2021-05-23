package da.camerarestapi.restapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping(value = "cameras")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Camera>> findAllCameras(){
        return new ResponseEntity<>(cameraService.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Camera> findById(@PathVariable String id){
        return new ResponseEntity<>(cameraService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Camera> createCamera(@RequestBody Camera camera){
        return new ResponseEntity<>(cameraService.createCamera(camera), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateCamera(@RequestBody Camera camera, @PathVariable("id") String id){
        cameraService.updateCamera(camera, id);
        return new ResponseEntity<>("Camera updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteCamera(@PathVariable("id") String id){
        cameraService.deleteCamera(id);
        return new ResponseEntity<>("Camera deleted", HttpStatus.OK);
    }
}
