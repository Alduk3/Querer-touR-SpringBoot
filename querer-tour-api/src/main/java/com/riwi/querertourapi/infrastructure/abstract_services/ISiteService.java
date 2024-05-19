package com.riwi.querertourapi.infrastructure.abstract_services;

import com.riwi.querertourapi.api.dto.request.SiteRequest;
import com.riwi.querertourapi.api.dto.response.SiteResponse;

public interface ISiteService extends CrudService<SiteRequest, SiteResponse, String>{
}
