/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Departamento;

/**
 *
 * @author Roberth
 */
public interface IDepartamentoService {
    
    public Optional<List<Departamento>> findAll();
}