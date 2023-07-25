package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
	private int modelId;
	@NotNull
	@NotBlank
	private String plate;
	@NotNull
	@NotBlank
	private double dailyPrice;
	@NotNull
	@NotBlank
	private int modelYear;
	@NotNull
	@NotBlank
	private String state;
	


}
