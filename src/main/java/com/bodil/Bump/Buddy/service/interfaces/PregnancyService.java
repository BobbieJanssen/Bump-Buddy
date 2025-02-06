package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.PregnancyDTO;
import java.util.List;
import java.util.Optional;

public interface PregnancyService {
    List<PregnancyDTO> getAllPregnancies();
    Optional<PregnancyDTO> getPregnancyById(Long id);
    PregnancyDTO createPregnancy(PregnancyDTO pregnancyDTO);
    PregnancyDTO updatePregnancy(Long id, PregnancyDTO pregnancyDTO);
    void deletePregnancy(Long id);
}
