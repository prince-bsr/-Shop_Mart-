package com.ecom.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imageName;
    private Boolean isactive;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Category(int id, String name, String imageName, Boolean isactive) {
		super();
		this.id = id;
		this.name = name;
		this.imageName = imageName;
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", imageName=" + imageName + ", isactive=" + isactive + "]";
	}
	
    
    
	
		
}
