package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.CarType;
import idv.cpl.springboot.repository.CarTypeRepository;

@Service
public class CarTypeService {

    private final CarTypeRepository CarTypeRepository;

    public CarTypeService(CarTypeRepository CarTypeRepository) {
        this.CarTypeRepository = CarTypeRepository;
    }

    public CarType save(CarType CarType) {
        return CarTypeRepository.save(CarType);
    }

    public void delete(CarType CarType) {
        CarTypeRepository.delete(CarType);
    }

    public Optional<CarType> findById(Long id) {
        return CarTypeRepository.findById(id);
    }

    public Page<CarType> findAllByPageable(Pageable pageable) {
        return CarTypeRepository.findAll(pageable);
    }
}
