package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.TipDTO;
import java.util.List;


public interface TipService {
    List<TipDTO> getAllTips();
    TipDTO getTipById(Long id);
    List<TipDTO> getTipsByWeek(int week);
    TipDTO createTip(TipDTO tipDTO);
    TipDTO updateTip(Long id, TipDTO tipDTO);
    void deleteTip (Long id);
}
