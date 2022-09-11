package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.PlateTypeDTO;
import idv.cpl.springboot.repository.PlateTypeRepository;

@Service
public class PlateTypeService {

    private final PlateTypeRepository PlateTypeRepository;

    public PlateTypeService(PlateTypeRepository PlateTypeRepository) {
        this.PlateTypeRepository = PlateTypeRepository;
    }

    public PlateTypeDTO save(PlateTypeDTO PlateType) {
        return PlateTypeRepository.save(PlateType);
    }

    public void delete(PlateTypeDTO PlateType) {
        PlateTypeRepository.delete(PlateType);
    }

    public Optional<PlateTypeDTO> findById(Long id) {
        return PlateTypeRepository.findById(id);
    }

    public Page<PlateTypeDTO> findAllByPageable(Pageable pageable) {
        return PlateTypeRepository.findAll(pageable);
    }
}
