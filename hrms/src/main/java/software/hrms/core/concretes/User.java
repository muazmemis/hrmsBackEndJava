package software.hrms.core.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email(message = "Email should be valid")
    @NotBlank
    @NotNull(message = "required")
    @Pattern(regexp="^.+@.+\\..+$", message = "Mail adresi istenilen formatta değil.")
    private String email;

    @Column(name = "password")
    @NotBlank
    @NotNull(message = "required")
    @Size(min = 5)
    private String password;

}