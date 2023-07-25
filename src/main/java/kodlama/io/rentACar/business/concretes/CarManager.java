package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService
{
	private final CarRepository carRepository;
	private final ModelMapperService modelMapperService;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		return cars.stream()
				.map(car -> this.modelMapperService.forResponse()
						.map(car, GetAllCarsResponse.class)).toList();
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		car.setId(0);
		this.carRepository.save(car);
		
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();
		GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);

		return response;
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
		
	}

}
