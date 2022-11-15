package models;
// Generated 15 nov. 2022 � 15:31:58 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EtatCommande generated by hbm2java
 */
@Entity
@Table(name = "EtatCommande", catalog = "kahoueh")
public class EtatCommande implements java.io.Serializable {

	private Integer etatcmdId;
	private String etatcmdDesc;

	public EtatCommande() {
	}

	public EtatCommande(String etatcmdDesc) {
		this.etatcmdDesc = etatcmdDesc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "etatcmdID", unique = true, nullable = false)
	public Integer getEtatcmdId() {
		return this.etatcmdId;
	}

	public void setEtatcmdId(Integer etatcmdId) {
		this.etatcmdId = etatcmdId;
	}

	@Column(name = "etatcmdDesc", nullable = false)
	public String getEtatcmdDesc() {
		return this.etatcmdDesc;
	}

	public void setEtatcmdDesc(String etatcmdDesc) {
		this.etatcmdDesc = etatcmdDesc;
	}

}