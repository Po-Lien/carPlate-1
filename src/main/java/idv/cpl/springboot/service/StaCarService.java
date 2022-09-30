package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.StaCar;
import idv.cpl.springboot.repository.StaCarRepository;

@Service
public class StaCarService {

    private final StaCarRepository StaCarRepository;

    public StaCarService(StaCarRepository StaCarRepository) {
        this.StaCarRepository = StaCarRepository;
    }

    public StaCar save(StaCar StaCar) {
        return StaCarRepository.save(StaCar);
    }

    public void delete(StaCar StaCar) {
        StaCarRepository.delete(StaCar);
    }

    public Optional<StaCar> findById(Long id) {
        return StaCarRepository.findById(id);
    }

    public Page<StaCar> findAllByPageable(Pageable pageable) {
        return StaCarRepository.findAll(pageable);
    }
}
