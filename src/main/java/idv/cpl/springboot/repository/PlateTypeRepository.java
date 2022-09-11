package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.PlateTypeDTO;

@Repository
public interface PlateTypeRepository extends JpaRepository<PlateTypeDTO, Long> {

}
