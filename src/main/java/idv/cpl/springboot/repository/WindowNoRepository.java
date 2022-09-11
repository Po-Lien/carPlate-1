package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.WindowNoDTO;

@Repository
public interface WindowNoRepository extends JpaRepository<WindowNoDTO, Long> {

}
