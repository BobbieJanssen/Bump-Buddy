package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Pregnancy;
import com.bodil.Bump.Buddy.repository.interfaces.PregnancyRepository;
import com.bodil.Bump.Buddy.service.interfaces.PregnancyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PregnancyServiceImp implements PregnancyService {

    private final PregnancyRepository pregnancyRepository;

    public PregnancyServiceImp(PregnancyRepository pregnancyRepository) {
        this.pregnancyRepository = pregnancyRepository;
    }

    @Override
    public List<Pregnancy> getAllPregnancies(){
        return pregnancyRepository.findAll();
    }

    @Override
    public Optional<Pregnancy> getPregnancyById(long id){
        return pregnancyRepository.findById(id);
    }

    @Override
    public Pregnancy createPregnancy(Pregnancy pregnancy) {
        return pregnancyRepository.save(pregnancy);
    }

    @Override
    public Pregnancy updatePregnancy (long id, Pregnancy pregnancy) {
        if (pregnancyRepository.existsById(id)) {
            return pregnancyRepository.save(pregnancy);
        }
        throw new RuntimeException("Pregnancy not found");
    }

    @Override
    public void deletePregnancy(long id) {
        pregnancyRepository.deleteById(id);
    }
}
