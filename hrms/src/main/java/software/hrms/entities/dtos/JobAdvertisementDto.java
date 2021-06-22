package software.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	
	private int numberOfAvailablePosition;

	private LocalDate createdDate;

	private LocalDate deadline;
	
	private String companyName;

	private String title;

}
