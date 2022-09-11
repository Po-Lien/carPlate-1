package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.StationDTO;
import idv.cpl.springboot.repository.StationRepository;

@Service
public class StationService {

    private final StationRepository StationRepository;

    public StationService(StationRepository StationRepository) {
        this.StationRepository = StationRepository;
    }

    public StationDTO save(StationDTO Station) {
        return StationRepository.save(Station);
    }

    public void delete(StationDTO Station) {
        StationRepository.delete(Station);
    }

    public Optional<StationDTO> findById(Long id) {
        return StationRepository.findById(id);
    }

    public Page<StationDTO> findAllByPageable(Pageable pageable) {
        return StationRepository.findAll(pageable);
    }
}
