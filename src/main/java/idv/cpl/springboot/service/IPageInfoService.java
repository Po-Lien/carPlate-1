package idv.cpl.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import idv.cpl.springboot.dto.PageInfoDTO;

public interface IPageInfoService {
	public PageInfoDTO save(PageInfoDTO PageInfo);

	public void delete(PageInfoDTO PageInfo);

	public void deleteAll();

	public Optional<PageInfoDTO> findById(Long id);

	public List<PageInfoDTO> findAll();
	
	public List<PageInfoDTO> findAll(Example arg0);

	public Page<PageInfoDTO> findAllByPageable(Pageable pageable);

	public void saveAuto() throws Exception;

	public List<PageInfoDTO> autoFind(String[] deptValues, String plateNo) throws Exception;
}
