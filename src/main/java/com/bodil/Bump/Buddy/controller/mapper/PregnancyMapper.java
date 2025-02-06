package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.PregnancyDTO;
import com.bodil.Bump.Buddy.model.Pregnancy;
import com.bodil.Bump.Buddy.model.User;
import org.springframework.stereotype.Component;

@Component
public class PregnancyMapper {

    public PregnancyDTO toDTO(Pregnancy pregnancy) {
        if (pregnancy == null) {
            return null;
        }
        return new PregnancyDTO(
                pregnancy.getId(),
                pregnancy.getDueDate(),
                pregnancy.getUser() != null ? pregnancy.getUser().getId() : null
        );
    }

    public Pregnancy toEntity(PregnancyDTO pregnancyDTO, User user) {
        if (pregnancyDTO == null) {
            return null;
        }
        Pregnancy pregnancy = new Pregnancy();
        pregnancy.setDueDate(pregnancyDTO.getDueDate());
        pregnancy.setUser(user);
        return pregnancy;
    }
}
