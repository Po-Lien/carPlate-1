package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.EnergyType;
import idv.cpl.springboot.repository.EnergyTypeRepository;

@Service
public class EnergyTypeService {

    private final EnergyTypeRepository EnergyTypeRepository;

    public EnergyTypeService(EnergyTypeRepository EnergyTypeRepository) {
        this.EnergyTypeRepository = EnergyTypeRepository;
    }

    public EnergyType save(EnergyType EnergyType) {
        return EnergyTypeRepository.save(EnergyType);
    }

    public void delete(EnergyType EnergyType) {
        EnergyTypeRepository.delete(EnergyType);
    }

    public Optional<EnergyType> findById(Long id) {
        return EnergyTypeRepository.findById(id);
    }

    public Page<EnergyType> findAllByPageable(Pageable pageable) {
        return EnergyTypeRepository.findAll(pageable);
    }
}
