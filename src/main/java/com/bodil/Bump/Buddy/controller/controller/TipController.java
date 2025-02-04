package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.TipDTO;
import com.bodil.Bump.Buddy.model.Tip;
import com.bodil.Bump.Buddy.service.interfaces.TipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipController {
    private final TipService tipService;

    public TipController(TipService tipService) {
        this.tipService = tipService;
    }

    @GetMapping
    public List<TipDTO> getAllTips() {
        return tipService.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipDTO> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(tipService.getTipById(id));
    }

    @GetMapping("/week/{week}")
    public List<TipDTO> getTipsByWeek(@PathVariable int week) {
        return tipService.getTipsByWeek(week);
    }

    @PostMapping
    public ResponseEntity<TipDTO> createTip(@RequestBody TipDTO tipDTO) {
        return ResponseEntity.ok(tipService.createTip(tipDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipDTO> updateTip(@PathVariable Long id, @RequestBody TipDTO tipDTO) {
        return ResponseEntity.ok(tipService.updateTip(id, tipDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        tipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
