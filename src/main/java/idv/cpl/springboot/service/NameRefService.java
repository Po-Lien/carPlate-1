package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.NameRef;
import idv.cpl.springboot.repository.NameRefRepository;

@Service
public class NameRefService {

    private final NameRefRepository NameRefRepository;

    public NameRefService(NameRefRepository NameRefRepository) {
        this.NameRefRepository = NameRefRepository;
    }

    public NameRef save(NameRef NameRef) {
        return NameRefRepository.save(NameRef);
    }

    public void delete(NameRef NameRef) {
        NameRefRepository.delete(NameRef);
    }

    public Optional<NameRef> findById(Long id) {
        return NameRefRepository.findById(id);
    }

    public Page<NameRef> findAllByPageable(Pageable pageable) {
        return NameRefRepository.findAll(pageable);
    }
}
