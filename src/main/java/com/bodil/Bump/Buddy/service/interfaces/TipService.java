package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Tip;

import java.util.List;
import java.util.Optional;

public interface TipService {
    List<Tip> getAllTips();
    Tip getTipById(Long id);
    List<Tip> getTipsByWeek(int week);
    Tip createTip(Tip tip);
    Tip updateTip(Long id, Tip tip);
    void deleteTip (Long id);
}
