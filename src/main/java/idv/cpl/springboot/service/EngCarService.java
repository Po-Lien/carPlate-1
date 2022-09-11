package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.EngCarDTO;
import idv.cpl.springboot.repository.EngCarRepository;

@Service
public class EngCarService {

    private final EngCarRepository EngCarRepository;

    public EngCarService(EngCarRepository EngCarRepository) {
        this.EngCarRepository = EngCarRepository;
    }

    public EngCarDTO save(EngCarDTO EngCar) {
        return EngCarRepository.save(EngCar);
    }

    public void delete(EngCarDTO EngCar) {
        EngCarRepository.delete(EngCar);
    }

    public Optional<EngCarDTO> findById(Long id) {
        return EngCarRepository.findById(id);
    }

    public Page<EngCarDTO> findAllByPageable(Pageable pageable) {
        return EngCarRepository.findAll(pageable);
    }
}
