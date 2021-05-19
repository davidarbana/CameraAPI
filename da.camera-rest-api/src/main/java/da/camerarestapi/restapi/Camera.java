package da.camerarestapi.restapi;

import lombok.*;
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
    private String _id;
    private String id;
    private String name;
    private String model;
    private String resolution;
    private String ip;
}
