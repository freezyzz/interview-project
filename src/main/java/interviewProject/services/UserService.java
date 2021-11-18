package interviewProject.services;


import interviewProject.model.UserStatusData;
import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;

public interface UserService {
    Long createUser(User user);
    User getUserById(Long id);
    UserStatusData updateStatus(Long id, UserStatus status);
}
