package da.camerarestapi.restapi;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "camera")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Camera {

    @Id
    @NonNull
    private String id;
    private String name;
    private String model;
    private String resolution;
    private String ip;
}
