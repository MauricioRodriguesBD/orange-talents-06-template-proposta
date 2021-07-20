package com.zup.academy.mauricio.proposta.criaproposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.academy.mauricio.proposta.criaproposta.status.StatusAvaliacao;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

		List<Proposta> findByStatusAvaliacao(StatusAvaliacao status);

		Optional<Proposta> findByDocumento(String documento);
}
