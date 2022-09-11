package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.StaPltDTO;
import idv.cpl.springboot.repository.StaPltRepository;

@Service
public class StaPltService {

    private final StaPltRepository StaPltRepository;

    public StaPltService(StaPltRepository StaPltRepository) {
        this.StaPltRepository = StaPltRepository;
    }

    public StaPltDTO save(StaPltDTO StaPlt) {
        return StaPltRepository.save(StaPlt);
    }

    public void delete(StaPltDTO StaPlt) {
        StaPltRepository.delete(StaPlt);
    }

    public Optional<StaPltDTO> findById(Long id) {
        return StaPltRepository.findById(id);
    }

    public Page<StaPltDTO> findAllByPageable(Pageable pageable) {
        return StaPltRepository.findAll(pageable);
    }
}
