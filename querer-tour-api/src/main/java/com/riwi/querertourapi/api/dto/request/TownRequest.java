package com.riwi.querertourapi.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder /** Patrón de diseño para creación de clases */
@AllArgsConstructor
@NoArgsConstructor
public class TownRequest {
    /**
     * Clase auxiliar encargada de extraer datos de la
     * entidad y va a guardar en ella para responder.
     * Aquí añadimos los datos que le pediremos al usuario.
     * */
    private String name;
    private String img;
    private String audio;
    private String location;
    private String description;
    private String short_description;
    private String qr;
}
