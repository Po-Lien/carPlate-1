package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.Dept;
import idv.cpl.springboot.repository.DeptRepository;

@Service
public class DeptService {

    private final DeptRepository deptRepository;

    public DeptService(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    public Dept save(Dept dept) {
        return deptRepository.save(dept);
    }

    public void delete(Dept dept) {
        deptRepository.delete(dept);
    }

    public Optional<Dept> findById(Long id) {
        return deptRepository.findById(id);
    }

    public Page<Dept> findAllByPageable(Pageable pageable) {
        return deptRepository.findAll(pageable);
    }
}
