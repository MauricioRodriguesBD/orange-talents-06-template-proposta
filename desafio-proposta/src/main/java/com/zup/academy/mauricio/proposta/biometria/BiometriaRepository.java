package com.zup.academy.mauricio.proposta.biometria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BiometriaRepository extends JpaRepository<Biometria, Long> {

//	public String findByFingerPrint(String fingerPrint);
	
	Optional<Biometria> findByFingerPrint(String fingerPrint);
}
