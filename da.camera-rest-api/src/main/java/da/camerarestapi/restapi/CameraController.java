package da.camerarestapi.restapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8081")
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
    public ResponseEntity<Optional<Camera>> findById(@PathVariable String id){
        return new ResponseEntity<>(cameraService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Camera> createCamera(@RequestBody Camera camera){
        return new ResponseEntity<>(cameraService.createCamera(camera), HttpStatus.OK);
    }
}
