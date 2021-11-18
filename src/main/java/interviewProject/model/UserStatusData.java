package interviewProject.model;

import interviewProject.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusData {
    private Long id;
    private UserStatus oldStatus;
    private UserStatus newStatus;
}
