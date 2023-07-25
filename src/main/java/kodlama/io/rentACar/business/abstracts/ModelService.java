package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();

	void add(CreateModelRequest createModelRequest);

	GetByIdModelResponse getById(int id);

	void update(UpdateModelRequest updateModelRequest);

	void delete(int id);
}
