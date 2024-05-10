package com.riwi.querertourapi.infrastructure.abstract_services;

import com.riwi.querertourapi.api.dto.request.TownRequest;
import com.riwi.querertourapi.api.dto.response.TownResponse;

/** La interfaz individual ITownService extiende de
 * CrudService, el cual recibe 3 parámetros: RQ, RS, ID.
 *
 * Si se llegaran a necesitar otros métodos particularmente
 * especializados o muy específicos, se pondrían aquí dentro
 * de las llaves de la interfaz
 * */
public interface ITownService extends CrudService<TownRequest, TownResponse, String>{
    //public TownResponse getById(String id);
}
