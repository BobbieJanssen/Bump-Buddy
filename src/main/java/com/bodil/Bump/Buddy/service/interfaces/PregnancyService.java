package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Pregnancy;
import java.util.List;
import java.util.Optional;

public interface PregnancyService {
    List<Pregnancy> getAllPregnancies();
    Optional<Pregnancy> getPregnancyById(int id);
    Pregnancy createPregnancy(Pregnancy pregnancy);
    Pregnancy updatePregnancy(int id, Pregnancy pregnancy);
    void deletePregnancy(int id);
}
