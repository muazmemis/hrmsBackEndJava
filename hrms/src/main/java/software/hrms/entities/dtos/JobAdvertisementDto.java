package software.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private String companyName;

	private String title;

	private int numberOfAvailablePosition;

	private LocalDate createdDate;
	
	private LocalDate deadline;

}
