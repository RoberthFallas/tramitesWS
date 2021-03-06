/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author LordLalo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotaDTO {

    private Long id;
    private boolean estado;
    private boolean tipo;
    private String titulo;
    private String contenido;
    private Date fechaRegistro;
    private Date fechaModificacion;
    @Setter(AccessLevel.NONE)
    private TramiteRegistradoDTO tramitesRegistrados;
}
