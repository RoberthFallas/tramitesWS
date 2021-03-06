/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author rober
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermisoDTO {

    private Long id;
    private String codigo;
    private String descripcion;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private boolean estado;
    @Setter(AccessLevel.NONE)
    private List<PermisoOtorgadoDTO> permisosOtorgados = new ArrayList<>();
}
