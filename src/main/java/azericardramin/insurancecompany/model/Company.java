package azericardramin.insurancecompany.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    @NotEmpty(message = "*Company name must be provided")
    private String name;

    @Column(name = "address")
    @Length(min = 5, message = "*Your address must have at least 5 characters")
    @NotEmpty(message = "*Please provide adress")
    private String address;

    @Column(name = "mobile_number")
    @Length(min = 5, message = "*Your number must have at least 5 characters")
    @NotEmpty(message = "*Please provide your mobile number")
    private int mobileNumber;

    @Column(name = "office_number")
    @NotEmpty(message = "*Please provide your mobile number")
    private int officeNumber;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "logo")
    @Lob
    private Long logo;

    @Column(name = "status")
    private int status;

//    @OneToMany(mappedBy = "company")
//    List<User> users;

}
