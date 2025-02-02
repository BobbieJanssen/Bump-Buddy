package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Access;
import com.bodil.Bump.Buddy.repository.interfaces.AccessRepository;
import com.bodil.Bump.Buddy.service.interfaces.AccessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessServiceImp implements AccessService {
    private final AccessRepository accessRepository;

    public AccessServiceImp (AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @Override
    public Optional<Access> getAccessById(Long id) {
        return accessRepository.findById(id);
    }

    @Override
    public List<Access> getAllAccess() {
        return accessRepository.findAll();
    }

    @Override
    public Access createAccess(Access access) {
        return accessRepository.save(access);
    }

    @Override
    public Access updateAccess(Long id, Access access) {
        if(accessRepository.existsById(id)) {
            return accessRepository.save(access);
        }
        throw new RuntimeException("Access not found");
    }

    @Override
    public void deleteAccess(Long id) {
        accessRepository.deleteById(id);
    }
}
