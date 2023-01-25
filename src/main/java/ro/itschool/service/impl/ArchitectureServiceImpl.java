package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Architecture;
import ro.itschool.exception.ArchitectureNotFound;
import ro.itschool.repository.ArchitectureRepository;
import ro.itschool.service.ArchitectureService;

import java.util.List;
import java.util.Optional;

@Service
public class ArchitectureServiceImpl implements ArchitectureService {

    @Autowired
    private ArchitectureRepository architectureRepository;

    @Override
    public void deleteByName(String name) throws ArchitectureNotFound {
        Optional.ofNullable(architectureRepository.findByName(name)).orElseThrow(ArchitectureNotFound::new);
        architectureRepository.deleteByName(name);
    }

    @Override
    public void save(Architecture architecture) throws ArchitectureNotFound {
        Optional.of(architectureRepository.save(architecture)).orElseThrow(ArchitectureNotFound::new);

    }

    @Override
    public List<Architecture> getAll() throws ArchitectureNotFound {
        return Optional.of(architectureRepository.findAll()).orElseThrow(ArchitectureNotFound::new);
    }

    @Override
    public Architecture findByName(String name) throws ArchitectureNotFound {
        return Optional.ofNullable(architectureRepository.findByName(name)).orElseThrow(ArchitectureNotFound::new);
    }

    @Override
    public List<Architecture> getAllByUserId(Long userId) throws ArchitectureNotFound {
        return Optional.ofNullable(architectureRepository.findByUserId(userId)).orElseThrow(ArchitectureNotFound::new);
    }
}