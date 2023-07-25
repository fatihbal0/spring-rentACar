package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();

	void add(CreateCarRequest createCarRequest);

	GetByIdCarResponse getById(int id);

	void update(UpdateCarRequest updateCarRequest);

	void delete(int id);
}
