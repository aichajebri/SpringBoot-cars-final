package com.aisha.cars.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCar;

@NotNull
@Size (min = 4,max = 15)
private String nomCar;

@NotNull
private Double prixCar;

private String imgCar;

public Groupe getGroupe() {
	return groupe;
}
public void setGroupe(Groupe groupe) {
	this.groupe = groupe;
}

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateAjout;

@ManyToOne
private Groupe groupe;
public car() {
super();
}
public car(String nomCar,Double prixCar,String imgCar,Date dateAjout) {
super();
this.nomCar = nomCar;
this.prixCar = prixCar;
this.dateAjout = dateAjout;
this.imgCar = imgCar;
}
public Long getIdCar() {
return idCar;
}
public void setIdCar(Long idCar) {
this.idCar = idCar;
}
public String getNomCar() {
return nomCar;
}
public void setNomCar(String nomCar) {
this.nomCar = nomCar;
}
public String getImgCar() {
return imgCar;
}
public void setImgCar(String imgCar) {
this.imgCar = imgCar;
}
public Date getDateAjout() {
return dateAjout;
}
public void setDateAjout(Date dateAjout) {
this.dateAjout = dateAjout;
}
public Double getPrixCar() {
return prixCar;
}
public void setPrixCar(Double prixCar) {
this.prixCar = prixCar;
}
@Override
public String toString() {
	return "car [idCar=" + idCar + ", nomCar=" + nomCar + ", prixCar=" + prixCar + ", imgCar=" + imgCar + ", dateAjout="
			+ dateAjout + ", groupe=" + groupe + "]";
}

}
