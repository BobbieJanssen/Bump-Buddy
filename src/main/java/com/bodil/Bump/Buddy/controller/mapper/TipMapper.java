package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.TipDTO;
import com.bodil.Bump.Buddy.model.Tip;
import org.springframework.stereotype.Component;

@Component
    public class TipMapper {

        public TipDTO toDTO(Tip tip) {
            TipDTO tipDTO = new TipDTO();
            tipDTO.setId(tip.getId());
            tipDTO.setTitle(tip.getTitle());
            tipDTO.setContent(tip.getContent());
            tipDTO.setVisibleAtWeek(tip.getVisibleAtWeek());
            tipDTO.setCreatedAt(tip.getCreatedAt());
            tipDTO.setUploadedAt(tip.getUploadedAt());
            return tipDTO;
        }

        public Tip toEntity(TipDTO tipDTO) {
            Tip tip = new Tip();
            tip.setTitle(tipDTO.getTitle());
            tip.setContent(tipDTO.getContent());
            tip.setVisibleAtWeek(tipDTO.getVisibleAtWeek());
            tip.setCreatedAt(tipDTO.getCreatedAt());
            tip.setUploadedAt(tipDTO.getUploadedAt());
            return tip;
        }
    }

