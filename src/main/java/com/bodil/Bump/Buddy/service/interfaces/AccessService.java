package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Access;
import java.util.List;
import java.util.Optional;

public interface AccessService {
    Access createAccess(Access access);
    Optional<Access> getAccessById(long id);
    List<Access> getAllAccess();
    Access updateAccess(long id, Access access);
    void deleteAccess(long id);
}
