package software.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.hrms.core.concretes.User;

@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {

	@Column(name = "first_name", nullable = false)
	@NotBlank
	@NotNull(message = "required")
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@NotBlank
	@NotNull(message = "required")
	private String lastName;

	@Column(name = "identity_number", nullable = false)
	@NotBlank
	@NotNull(message = "required")
	private String identityNumber;

	@Column(name = "birth_of_year", nullable = false)
	@NotBlank
	@NotNull(message = "required")
	@Min(1970)
	private int birthOfYear;

}
