package com.riwi.querertourapi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TownResponse {
    /**
     * Acá vamos a mostrar el id, ya que el usuario actualiza
     * por id y no por otro parámetro
     *
     * */
    private String id;
    private String name;
    private String img;
    private String audio;
    private String location;
    private String description;
    private String short_description;
    private String qr;
}
