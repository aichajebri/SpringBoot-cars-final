package com.aisha.cars.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Groupe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGrp;
private String nomGrp;
private String descriptionGrp;
@JsonIgnore
@OneToMany(mappedBy = "groupe")
private List<car> cars;
public Groupe() {}
public Groupe(String nomGrp, String descriptionGrp, List<car> cars) 
{
super();
this.nomGrp = nomGrp;
this.descriptionGrp = descriptionGrp;
this.cars = cars;
}
public Long getIdGrp() {
return idGrp;
}
public void setIdGrp(Long idGrp) {
this.idGrp = idGrp;
}
public String getNomGrp() {
return nomGrp;
}
public void setNomGrp(String nomGrp) {
this.nomGrp = nomGrp;
}
public String getDescriptionGrp() {
return descriptionGrp;
}
public void setDescriptionGrp(String descriptionGrp) {
this.descriptionGrp = descriptionGrp;
}
public List<car> getCars() {
return cars;
}
public void setCars(List<car> cars) {
this.cars = cars;
}
@Override
public String toString() {
	return "Groupe [idGrp=" + idGrp + ", nomGrp=" + nomGrp + ", descriptionGrp=" + descriptionGrp + "]";
}
}