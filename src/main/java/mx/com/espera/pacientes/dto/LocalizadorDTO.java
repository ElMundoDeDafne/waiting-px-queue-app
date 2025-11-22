/**
 * 
 */
package mx.com.espera.pacientes.dto;

import java.io.Serializable;

/**
 * 
 */
public class LocalizadorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7969438080419252838L;
	private String codigoLocalizador;
	private String valorLocalizador;
	public String getCodigoLocalizador() {
		return codigoLocalizador;
	}
	public void setCodigoLocalizador(String codigoLocalizador) {
		this.codigoLocalizador = codigoLocalizador;
	}
	public String getValorLocalizador() {
		return valorLocalizador;
	}
	public void setValorLocalizador(String valorLocalizador) {
		this.valorLocalizador = valorLocalizador;
	}

}
