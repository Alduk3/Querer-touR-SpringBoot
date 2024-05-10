
package com.riwi.querertourapi.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
    public void delete(ID id);
    public RS create(RQ request);
    public RS update(ID id, RQ request);
    public Page<RS> getAll(int page, int size);
}
