package azericardramin.insurancecompany.model;

import azericardramin.insurancecompany.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    @Length(min = 3, message = "*Your username must have at least 3 characters")
    @NotEmpty(message = "*Must provide username")
    private String name;

    @Column(name = "surname")
    @Length(min = 3, message = "*Your surname must have at least 3 characters")
    @NotEmpty(message = "*Must provide surname")
    private String surname;

    @Column(name = "username", unique = true)
    @NotEmpty(message = "*Must provide surname")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "status")
    private int status;

    @Column(name = "phone_number", unique = true)
    private int phoneNumber;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_at")
    private Date lastLoginDate = new Date();

    @Enumerated
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
