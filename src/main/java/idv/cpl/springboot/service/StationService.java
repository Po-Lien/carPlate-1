package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.Station;
import idv.cpl.springboot.repository.StationRepository;

@Service
public class StationService {

    private final StationRepository StationRepository;

    public StationService(StationRepository StationRepository) {
        this.StationRepository = StationRepository;
    }

    public Station save(Station Station) {
        return StationRepository.save(Station);
    }

    public void delete(Station Station) {
        StationRepository.delete(Station);
    }

    public Optional<Station> findById(Long id) {
        return StationRepository.findById(id);
    }

    public Page<Station> findAllByPageable(Pageable pageable) {
        return StationRepository.findAll(pageable);
    }
}
