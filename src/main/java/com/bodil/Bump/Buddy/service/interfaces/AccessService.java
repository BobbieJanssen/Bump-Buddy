package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Access;
import java.util.List;
import java.util.Optional;

public interface AccessService {
    Optional<Access> getAccessById(Long id);
    List<Access> getAllAccess();
    Access createAccess(Access access);
    Access updateAccess(Long id, Access access);
    void deleteAccess(Long id);
}
