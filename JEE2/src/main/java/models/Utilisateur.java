package models;
// Generated 18 nov. 2022 � 11:50:07 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "Utilisateur", catalog = "kahoueh")
public class Utilisateur implements java.io.Serializable {

	private Integer utilId;
	private Role role;
	private String utilMail;
	private String utilPassword;
	private String utilNom;
	private String utilPrenom;
	private String utilTel;
	private String utilAddresse;
	private String utilCp;
	private String utilVille;
	private String utilCb;

	public Utilisateur() {
	}

	public Utilisateur(Role role, String utilMail, String utilPassword, String utilNom, String utilPrenom,
			String utilTel, String utilAddresse, String utilCp, String utilVille, String utilCb) {
		this.role = role;
		this.utilMail = utilMail;
		this.utilPassword = utilPassword;
		this.utilNom = utilNom;
		this.utilPrenom = utilPrenom;
		this.utilTel = utilTel;
		this.utilAddresse = utilAddresse;
		this.utilCp = utilCp;
		this.utilVille = utilVille;
		this.utilCb = utilCb;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "utilID", unique = true, nullable = false)
	public Integer getUtilId() {
		return this.utilId;
	}

	public void setUtilId(Integer utilId) {
		this.utilId = utilId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilRole", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "utilMail", nullable = false)
	public String getUtilMail() {
		return this.utilMail;
	}

	public void setUtilMail(String utilMail) {
		this.utilMail = utilMail;
	}

	@Column(name = "utilPassword", nullable = false)
	public String getUtilPassword() {
		return this.utilPassword;
	}

	public void setUtilPassword(String utilPassword) {
		this.utilPassword = utilPassword;
	}

	@Column(name = "utilNom", nullable = false)
	public String getUtilNom() {
		return this.utilNom;
	}

	public void setUtilNom(String utilNom) {
		this.utilNom = utilNom;
	}

	@Column(name = "utilPrenom", nullable = false)
	public String getUtilPrenom() {
		return this.utilPrenom;
	}

	public void setUtilPrenom(String utilPrenom) {
		this.utilPrenom = utilPrenom;
	}

	@Column(name = "utilTel", nullable = false)
	public String getUtilTel() {
		return this.utilTel;
	}

	public void setUtilTel(String utilTel) {
		this.utilTel = utilTel;
	}

	@Column(name = "utilAddresse", nullable = false)
	public String getUtilAddresse() {
		return this.utilAddresse;
	}

	public void setUtilAddresse(String utilAddresse) {
		this.utilAddresse = utilAddresse;
	}

	@Column(name = "utilCP", nullable = false)
	public String getUtilCp() {
		return this.utilCp;
	}

	public void setUtilCp(String utilCp) {
		this.utilCp = utilCp;
	}

	@Column(name = "utilVille", nullable = false)
	public String getUtilVille() {
		return this.utilVille;
	}

	public void setUtilVille(String utilVille) {
		this.utilVille = utilVille;
	}

	@Column(name = "utilCB", nullable = false)
	public String getUtilCb() {
		return this.utilCb;
	}

	public void setUtilCb(String utilCb) {
		this.utilCb = utilCb;
	}

}
