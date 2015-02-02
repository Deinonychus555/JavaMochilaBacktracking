/*********************************************************************
Nombre: Samuel Martín Gómez-Calcerrada
Expediente/titulación: 280/GIS
Nombre: Juan Antonio Echeverrías Aranda
Expediente/titulación: 289/GIS
*********************************************************************/

package algoritmo;


public class Objeto {

    private String nombre;
    private int peso;
    private int beneficio;
    private int unidades;
    
    
    public Objeto (String nombre, int peso, int beneficio, int unidades){
        this.nombre=nombre;
        this.peso=peso;
        this.beneficio=beneficio;
        this.unidades=unidades;
    }
     
  
     public String getNombre() {
        return nombre;
    }
     
    public int getPeso() {
        return peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public int getUnidades() {
        return unidades;
    }
    
    public void setUnidades(int unidades) {
        if (unidades<0){
            this.unidades=0;
        }
        else{
            this.unidades=unidades;  
        }
            
    }
    
   
   public Objeto copia(){
   //Devuelve una copia del objeto    
       return new Objeto (getNombre(),getPeso(),getBeneficio(),getUnidades());
   }
   
   
   public boolean equals(Objeto objeto){
   //Devuelve true si los objetos a comparar son iguales y false en caso contrario
   //suponemos que si los objetos tienen el mismo nombre son el mismo tipo de objeto    
       return (this.nombre==objeto.nombre);
   } 
   
   
   public void incrementar(){
   //Incrementa en 1 las unidades del objeto    
       setUnidades(unidades+1);
   }
   
   public void decrementar(){
   //Decrementa en 1 las unidades del objeto     
       setUnidades(unidades-1);
   }
   
   @Override
    public String toString() {
    //Devuelve un String con las caracteristicas del objeto   
        return "nombre: "+nombre+", peso: "+peso+", beneficio: "+beneficio+", unidades: "+unidades;
    }
}


