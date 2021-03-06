package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.TramiteCambioEstadoDTO;
import org.una.tramites.entities.TramiteCambioEstado;
import org.una.tramites.entities.TramiteEstado;
import org.una.tramites.repositories.ITramiteCambioEstadoRepository;
import org.una.tramites.repositories.ITramiteEstadoRepository;
import org.una.tramites.utils.MapperUtils;

@Service
public class TramiteCambioEstadoServiceImplementation implements ITramiteCambioEstadoService {

    @Autowired
    private ITramiteCambioEstadoRepository tramiteCambioEstadoRepository;

    @Autowired
    private ITramiteEstadoRepository tramiteEstadoRepository;

    private Optional<List< TramiteCambioEstadoDTO>> findList(List< TramiteCambioEstado> list) {
        if (list != null) {
            List< TramiteCambioEstadoDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(list, TramiteCambioEstadoDTO.class);
            return Optional.ofNullable(usuariosDTO);
        } else {
            return null;
        }
    }

    private Optional<List< TramiteCambioEstadoDTO>> findList(Optional<List< TramiteCambioEstado>> list) {
        if (list.isPresent()) {
            return findList(list.get());
        } else {
            return null;
        }
    }

    private Optional< TramiteCambioEstadoDTO> oneToDto(Optional< TramiteCambioEstado> one) {
        if (one.isPresent()) {
            TramiteCambioEstadoDTO requisitoDTO = MapperUtils.DtoFromEntity(one.get(), TramiteCambioEstadoDTO.class);
            return Optional.ofNullable(requisitoDTO);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteCambioEstadoDTO> findById(Long id) {
        return oneToDto(tramiteCambioEstadoRepository.findById(id));
    }

    @Override
    @Transactional
    public TramiteCambioEstadoDTO create(TramiteCambioEstadoDTO tramiteCambioEstadoDTO) {
        TramiteCambioEstado tramiteCambioEstado = MapperUtils.EntityFromDto(tramiteCambioEstadoDTO, TramiteCambioEstado.class);
        tramiteCambioEstado = tramiteCambioEstadoRepository.save(tramiteCambioEstado);
        return MapperUtils.DtoFromEntity(tramiteCambioEstado, TramiteCambioEstadoDTO.class);
    }

    @Override
    @Transactional
    public Optional<TramiteCambioEstadoDTO> update(TramiteCambioEstadoDTO tramiteCambioEstadoDTO, Long id) {

        if (tramiteCambioEstadoRepository.findById(id).isPresent()) {
            TramiteCambioEstado tramiteCambioEstado = MapperUtils.EntityFromDto(tramiteCambioEstadoDTO, TramiteCambioEstado.class);
            tramiteCambioEstado = tramiteCambioEstadoRepository.save(tramiteCambioEstado);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tramiteCambioEstado, TramiteCambioEstadoDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteCambioEstadoDTO>> findAll() {
        return findList(tramiteCambioEstadoRepository.findAll());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tramiteCambioEstadoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramiteCambioEstadoRepository.deleteAll();
    }

    @Override
    @Transactional
    public Optional<TramiteCambioEstadoDTO> modificarEstado(Long idTramite, Long idTramiteEstado) {
        if (tramiteCambioEstadoRepository.findById(idTramite).isPresent()) {
            Optional<TramiteCambioEstado> tramiteCambEs = tramiteCambioEstadoRepository.findById(idTramite);
            Optional<TramiteEstado> tramiteEstad = tramiteEstadoRepository.findById(idTramiteEstado);
            tramiteCambEs.get().setTramiteEstado((TramiteEstado) tramiteEstad.get());
            TramiteCambioEstado tra = tramiteCambioEstadoRepository.save((TramiteCambioEstado) tramiteCambEs.get());
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tra, TramiteCambioEstadoDTO.class));

        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Optional<TramiteCambioEstadoDTO> actualizarTramiteNuevo(Long idTramite, Long idTramiteEstado) {
        if (tramiteCambioEstadoRepository.findById(idTramite).isPresent()) {
            Optional<TramiteCambioEstado> tramiteCambEs = tramiteCambioEstadoRepository.findById(idTramite);
            Optional<TramiteEstado> tramiteEstad = tramiteEstadoRepository.findById(idTramiteEstado);
            TramiteCambioEstado tramiteCambioEstadoNuevo = new TramiteCambioEstado();
            tramiteCambioEstadoNuevo.setUsuario(tramiteCambEs.get().getUsuario());
            tramiteCambioEstadoNuevo.setTramiteRegistrado(tramiteCambEs.get().getTramiteRegistrado());
            tramiteCambioEstadoNuevo.setTramiteEstado(tramiteEstad.get());
            TramiteCambioEstado tra = tramiteCambioEstadoRepository.save(tramiteCambioEstadoNuevo);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tra, TramiteCambioEstadoDTO.class));

        } else {
            return null;
        }
    }
}
