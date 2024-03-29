package idv.cpl.springboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import idv.cpl.springboot.entity.WindowNo;
import idv.cpl.springboot.repository.WindowNoRepository;

@Service
public class WindowNoService {

    private final WindowNoRepository WindowNoRepository;

    public WindowNoService(WindowNoRepository WindowNoRepository) {
        this.WindowNoRepository = WindowNoRepository;
    }

    public WindowNo save(WindowNo WindowNo) {
        return WindowNoRepository.save(WindowNo);
    }

    public void delete(WindowNo WindowNo) {
        WindowNoRepository.delete(WindowNo);
    }

    public Optional<WindowNo> findById(Long id) {
        return WindowNoRepository.findById(id);
    }

    public Page<WindowNo> findAllByPageable(Pageable pageable) {
        return WindowNoRepository.findAll(pageable);
    }
}
