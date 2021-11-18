package interviewProject.model.entities;

import interviewProject.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "image")
    private String imageURI;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private UserStatus userStatus = UserStatus.NONE;
}

