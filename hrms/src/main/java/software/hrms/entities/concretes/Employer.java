package software.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.hrms.core.concretes.User;

@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "web_address", nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String webSiteAdress;
	
	@Column(name = "phone_number", nullable = false)
	@NotBlank
	@NotNull(message="required")
	@Pattern(regexp ="[0-9\\s]{12}")
	private String phoneNumber;
	
}
