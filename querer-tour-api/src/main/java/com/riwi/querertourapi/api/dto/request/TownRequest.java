package com.riwi.querertourapi.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 0, max = 50, message = "El nombre supera la cantidad de caracteres permitidos") //Uso de la librería validation
    @NotBlank(message = "El nombre del pueblo es requerido") //Uso de la librería validation
    private String name;
    @NotBlank(message = "La imagen del pueblo es requerida") //Uso de la librería validation
    private String img;
    private String audio;
    @NotBlank(message = "La locación del pueblo es requerida") //Uso de la librería validation
    private String location;
    @NotBlank(message = "La descripción del pueblo es requerida") //Uso de la librería validation
    private String description;
    @NotBlank(message = "La descripción corta del pueblo es requerida") //Uso de la librería validation
    private String short_description;
    @NotBlank(message = "El código QR del pueblo es requerido") //Uso de la librería validation
    private String qr;
}
