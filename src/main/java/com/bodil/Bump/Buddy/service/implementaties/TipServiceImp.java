package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.TipDTO;
import com.bodil.Bump.Buddy.controller.mapper.TipMapper;
import com.bodil.Bump.Buddy.model.Tip;
import com.bodil.Bump.Buddy.repository.interfaces.TipRepository;
import com.bodil.Bump.Buddy.service.interfaces.TipService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipServiceImp implements TipService {
    private final TipRepository tipRepository;
    private final TipMapper tipMapper;


    public TipServiceImp (TipRepository tipRepository, TipMapper tipMapper) {
        this.tipRepository = tipRepository;
        this.tipMapper = tipMapper;
    }

    @Override
    public List<TipDTO> getAllTips() {
        return tipRepository.findAll().stream()
                .map(tipMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipDTO getTipById(Long id) {
        return tipRepository.findById(id)
                .map(tipMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Tip not found"));
    }

    @Override
    public List<TipDTO> getTipsByWeek (int week) {
        return tipRepository.findByVisibleAtWeek(week).stream()
                .map(tipMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipDTO createTip(TipDTO tipDTO) {
        Tip tip = tipMapper.toEntity(tipDTO);
        Tip savedTip = tipRepository.save(tip);
        return tipMapper.toDTO(savedTip);
    }

    @Override
    public TipDTO updateTip (Long id, TipDTO updatedTipDTO) {
        Tip existingTip = tipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tip not found"));
        existingTip.setTitle(updatedTipDTO.getTitle());
        existingTip.setContent(updatedTipDTO.getContent());
        existingTip.setVisibleAtWeek(updatedTipDTO.getVisibleAtWeek());
        existingTip.setUploadedAt(updatedTipDTO.getUploadedAt());
        Tip updatedTip = tipRepository.save(existingTip);
        return tipMapper.toDTO(updatedTip);
    }

    @Override
    public void deleteTip(Long id) {
        tipRepository.deleteById(id);
    }
}
