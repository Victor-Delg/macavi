package com.macavi.service;

import com.macavi.service.dto.FacturaDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.macavi.domain.Factura}.
 */
public interface FacturaService {
    /**
     * Save a factura.
     *
     * @param facturaDTO the entity to save.
     * @return the persisted entity.
     */
    FacturaDTO save(FacturaDTO facturaDTO);

    /**
     * Updates a factura.
     *
     * @param facturaDTO the entity to update.
     * @return the persisted entity.
     */
    FacturaDTO update(FacturaDTO facturaDTO);

    /**
     * Partially updates a factura.
     *
     * @param facturaDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FacturaDTO> partialUpdate(FacturaDTO facturaDTO);

    /**
     * Get all the facturas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FacturaDTO> findAll(Pageable pageable);

    /**
     * Get the "id" factura.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FacturaDTO> findOne(Long id);

    /**
     * Delete the "id" factura.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
