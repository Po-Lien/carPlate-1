package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.DeptDTO;
import idv.cpl.springboot.repository.DeptRepository;

@Service
public class DeptService {

    private final DeptRepository deptRepository;

    public DeptService(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    public DeptDTO save(DeptDTO dept) {
        return deptRepository.save(dept);
    }

    public void delete(DeptDTO dept) {
        deptRepository.delete(dept);
    }

    public Optional<DeptDTO> findById(Long id) {
        return deptRepository.findById(id);
    }

    public Page<DeptDTO> findAllByPageable(Pageable pageable) {
        return deptRepository.findAll(pageable);
    }
}
