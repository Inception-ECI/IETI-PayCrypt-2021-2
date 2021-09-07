package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum contains the Available document types for the server
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum DocumentType {

	/**
	 * Cédula de ciudadanía
	 */
	CC(new Country[] {Country.CO}),

	/**
	 * Cédula de extranjería
	 */
	CE(new Country[] {Country.AR, Country.CL, Country.CO, Country.ES, Country.MX, Country.PE, Country.US}),

	/**
	 * Brasil CPF
	 */
	CEP(new Country[] {Country.BR}),

	/**
	 * Cédula identidad CL
	 */
	CI(new Country[] {Country.CL}),

	/**
	 * Brasil CPF
	 */
	CPF(new Country[] {Country.BR}),

	/**
	 * Brasil Social Contract
	 */
	SC(new Country[] {Country.BR}),

	/**
	 * Argentina CUIT
	 */
	CUIT(new Country[] {Country.AR}),

	/**
	 * Clave única registro población MX
	 */
	CURP(new Country[] {Country.MX}),

	/**
	 * Documento de Identificación Extranjero.
	 */
	DE(new Country[] {Country.CO}),

	/**
	 * Argentina DNI
	 */
	DNI(new Country[] {Country.PE, Country.AR, Country.ES}),

	/**
	 * Número identificación fiscal ES
	 */
	NIF(new Country[] {Country.ES}),

	/**
	 * N.I.T.
	 */
	NIT(new Country[] {Country.CO}),

	/**
	 * Pasaporte.
	 */
	PP(new Country[] {Country.AR, Country.CL, Country.PE, Country.ES, Country.MX, Country.US, Country.CO}),

	/**
	 * Registro mercantil AR
	 **/
	RM(new Country[] {Country.AR}),

	/**
	 * Registro mercantil central ES
	 **/
	RMC(new Country[] {Country.ES}),

	/**
	 * Peru RUC
	 */
	RUC(new Country[] {Country.PE}),

	/**
	 * Social Security Number US
	 **/
	SSN(new Country[] {Country.US});

	/**
	 * Countries that have the DocumentType
	 */
	private final Country[] countries;

}
