package API.model.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String job;
}