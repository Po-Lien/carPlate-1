package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.StaPlt;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StaPltRepository extends JpaRepository<StaPlt, Long> {

}
