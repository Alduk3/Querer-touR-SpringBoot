package com.riwi.querertourapi.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import javax.swing.*;

public interface CrudService <RQ, RS, ID> {
    public RS create(RQ request);

    public RS getById(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);

    public Page<RS> getAll(int page, int size);
}
