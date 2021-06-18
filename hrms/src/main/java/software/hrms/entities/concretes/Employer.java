package software.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.hrms.core.entities.User;

@PrimaryKeyJoinColumn(name="employer_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer extends User{

	@Column(name = "company_name", nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String companyName;
	
	@Column(name = "web_address", nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String webSiteAdress;
	
	@Column(name = "phone_number", nullable = false)
	@NotBlank
	@NotNull(message="required")
	@Pattern(regexp ="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
	private String phoneNumber;
	

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
