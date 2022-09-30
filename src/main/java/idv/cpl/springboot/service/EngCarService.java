package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.EngCar;
import idv.cpl.springboot.repository.EngCarRepository;

@Service
public class EngCarService {

    private final EngCarRepository EngCarRepository;

    public EngCarService(EngCarRepository EngCarRepository) {
        this.EngCarRepository = EngCarRepository;
    }

    public EngCar save(EngCar EngCar) {
        return EngCarRepository.save(EngCar);
    }

    public void delete(EngCar EngCar) {
        EngCarRepository.delete(EngCar);
    }

    public Optional<EngCar> findById(Long id) {
        return EngCarRepository.findById(id);
    }

    public Page<EngCar> findAllByPageable(Pageable pageable) {
        return EngCarRepository.findAll(pageable);
    }
}
