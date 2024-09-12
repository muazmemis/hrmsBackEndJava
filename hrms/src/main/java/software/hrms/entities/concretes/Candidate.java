package software.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.hrms.core.entities.User;

@PrimaryKeyJoinColumn(name = "candidate_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cvs" })
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
	@NotNull(message = "required")
	@Min(1970)
	private int birthOfYear;

}
