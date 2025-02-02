package com.bodil.Bump.Buddy.controller;

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
    public List<Tip> getAllTips() {
        return tipService.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tip> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(tipService.getTipById(id));
    }

    @GetMapping("/week/{week}")
    public List<Tip> getTipsByWeek(@PathVariable int week) {
        return tipService.getTipsByWeek(week);
    }

    @PostMapping
    public ResponseEntity<Tip> createTip(@RequestBody Tip tip) {
        return ResponseEntity.ok(tipService.createTip(tip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tip> updateTip(@PathVariable Long id, @RequestBody Tip tip) {
        return ResponseEntity.ok(tipService.updateTip(id, tip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        tipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
