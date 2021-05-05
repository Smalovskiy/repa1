/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author 18751
 */
@Entity
@Table(name="specialnosti"
    ,catalog="gr"
    , uniqueConstraints = @UniqueConstraint(columnNames="Nazvanie") 
)
public class Specialnosti implements java.io.Serializable{
    private long id;
    private String nazvanie;
    private Date dataFormir;
    private Set<Gruppyi> gruppyis = new HashSet<Gruppyi>(0);
    
    public Specialnosti(){}
    
    public Specialnosti(String nazvanie){
        this.nazvanie = nazvanie;
    }
    
    @Id
    @Column(name="id", unique=true, nullable=false)
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    @Column(name="Nazvanie", unique=true, nullable=false, length=50)
    public String getNazvanie() {
        return this.nazvanie;
    }
    
    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="DataFormir", nullable=false, length=10)
    public Date getDataFormir() {
        return this.dataFormir;
    }
    
    public void setDataFormir(Date dataFormir) {
        this.dataFormir = dataFormir;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="specialnost")
    public Set<Gruppyi> getStudentyis() {
        return this.gruppyis;
    }
    
    public void setStudentyis(Set<Gruppyi> gruppyis) {
        this.gruppyis = gruppyis;
    }
}
