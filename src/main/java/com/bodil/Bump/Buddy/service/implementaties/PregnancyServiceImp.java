package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.PregnancyDTO;
import com.bodil.Bump.Buddy.controller.mapper.PregnancyMapper;
import com.bodil.Bump.Buddy.model.Pregnancy;
import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.repository.interfaces.PregnancyRepository;
import com.bodil.Bump.Buddy.repository.interfaces.UserRepository;
import com.bodil.Bump.Buddy.service.interfaces.PregnancyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PregnancyServiceImp implements PregnancyService {
    private final PregnancyRepository pregnancyRepository;
    private final UserRepository userRepository;
    private final PregnancyMapper pregnancyMapper;

    public PregnancyServiceImp(PregnancyRepository pregnancyRepository,
                               UserRepository userRepository,
                               PregnancyMapper pregnancyMapper) {
        this.pregnancyRepository = pregnancyRepository;
        this.userRepository = userRepository;
        this.pregnancyMapper = pregnancyMapper;
    }

    @Override
    public List<PregnancyDTO> getAllPregnancies(){
        return pregnancyRepository.findAll().stream()
                .map(pregnancyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PregnancyDTO> getPregnancyById(Long id){
        return pregnancyRepository.findById(id).map(pregnancyMapper::toDTO);
    }

    @Override
    public PregnancyDTO createPregnancy(PregnancyDTO pregnancyDTO) {
        User user = userRepository.findById(pregnancyDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Pregnancy pregnancy = pregnancyMapper.toEntity(pregnancyDTO, user);
        return pregnancyMapper.toDTO(pregnancyRepository.save(pregnancy));
    }

    @Override
    public PregnancyDTO updatePregnancy (Long id, PregnancyDTO pregnancyDTO) {
        if (!pregnancyRepository.existsById(id)) {
            throw new RuntimeException("Pregnancy not found");
        }
        User user = userRepository.findById(pregnancyDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Pregnancy pregnancy = pregnancyMapper.toEntity(pregnancyDTO, user);

        return pregnancyMapper.toDTO(pregnancyRepository.save(pregnancy));
    }

    @Override
    public void deletePregnancy(Long id) {
        pregnancyRepository.deleteById(id);
    }
}
