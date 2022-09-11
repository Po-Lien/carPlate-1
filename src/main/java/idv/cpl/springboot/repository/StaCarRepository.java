package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.StaCarDTO;

@Repository
public interface StaCarRepository extends JpaRepository<StaCarDTO, Long> {

}
