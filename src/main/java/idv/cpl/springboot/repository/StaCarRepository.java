package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.StaCar;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StaCarRepository extends JpaRepository<StaCar, Long> {

}
