package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Tip;
import com.bodil.Bump.Buddy.repository.interfaces.TipRepository;
import com.bodil.Bump.Buddy.service.interfaces.TipService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImp implements TipService {
    private final TipRepository tipRepository;

    @Autowired
    public TipServiceImp (TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @Override
    public List<Tip> getAllTips() {
        return tipRepository.findAll();
    }

    @Override
    public Tip getTipById(Long id) {
        return tipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tip not found"));
    }

    @Override
    public List<Tip> getTipsByWeek (int week) {
        return tipRepository.findByVisibleAtWeek(week);
    }

    @Override
    public Tip createTip(Tip tip) {
        return tipRepository.save(tip);
    }

    @Override
    public Tip updateTip (Long id, Tip updatedTip) {
        Tip existingTip = getTipById(id);
        existingTip.setTitle(updatedTip.getTitle());
        existingTip.setContent(updatedTip.getContent());
        existingTip.setVisibleAtWeek(updatedTip.getVisibleAtWeek());
        existingTip.setUploadedAt(updatedTip.getUploadedAt());
        return tipRepository.save(existingTip);
    }

    @Override
    public void deleteTip(Long id) {
        tipRepository.deleteById(id);
    }
}
