package interviewProject.controllers;

import interviewProject.model.UserStatusData;
import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;
import interviewProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Long> creteUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update/status/{id}/{newStatus}")
    public ResponseEntity<UserStatusData> updateUserStatus(@PathVariable("id") Long id, @PathVariable("newStatus") UserStatus newStatus) {
        return ResponseEntity.ok(userService.updateStatus(id, newStatus));
    }
}
