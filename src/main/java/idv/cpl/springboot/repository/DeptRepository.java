package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.DeptDTO;

@Repository
public interface DeptRepository extends JpaRepository<DeptDTO, Long> {

}
