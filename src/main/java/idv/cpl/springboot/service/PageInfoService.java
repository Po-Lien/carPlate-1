package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.dto.PageInfoDTO;
import idv.cpl.springboot.repository.PageInfoRepository;

@Service
public class PageInfoService {

    private final PageInfoRepository PageInfoRepository;

    public PageInfoService(PageInfoRepository PageInfoRepository) {
        this.PageInfoRepository = PageInfoRepository;
    }

    public PageInfoDTO save(PageInfoDTO PageInfo) {
        return PageInfoRepository.save(PageInfo);
    }

    public void delete(PageInfoDTO PageInfo) {
        PageInfoRepository.delete(PageInfo);
    }

    public Optional<PageInfoDTO> findById(Long id) {
        return PageInfoRepository.findById(id);
    }

    public Page<PageInfoDTO> findAllByPageable(Pageable pageable) {
        return PageInfoRepository.findAll(pageable);
    }
}
