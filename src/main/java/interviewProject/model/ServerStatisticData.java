package interviewProject.model;

import interviewProject.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerStatisticData {
    private Long id;
    private String imageURI;
    private UserStatus userStatus;
}
