/*********************************************************************
Nombre: Samuel Martín Gómez-Calcerrada
Expediente/titulación: 280/GIS
Nombre: Juan Antonio Echeverrías Aranda
Expediente/titulación: 289/GIS
*********************************************************************/

package algoritmo;


public class Mochila {
    
    private double peso;   // peso total de los objetos contenidos en la mochila
    private int capacidad;
    private Objeto [] objetos = null;
    
    
    public Mochila(){
        peso=0;
        this.capacidad=0;
        objetos = new Objeto[0];
    }
    
    public Mochila(int capacidad){
        peso=0;
        this.capacidad=capacidad;
        objetos = new Objeto[0];
    }
    
    
     public double getPeso(){
        return peso;
    }
    
     
    public int getCapacidad() {
        return capacidad;
    }

    
    public Objeto[] getObjetos() {
        return objetos;
    }
        
   
    
    public Objeto getObjeto(int i) {
    //Devuelve el objeto de la posicion que se le pasa como argumento    
        return objetos[i];
    }
     
    
    public int numObjetos() {
    //Devuelve el numero de objetos distintos que hay en la mochila, NO el total de unidades    
        return objetos.length;
    }
    
    public int numUnidades() {
    //Devuelve el numero total de unidades de todos los objetos contenidos en la mochila
        int numunidades=0;
        for (int i=0; i< objetos.length; i++){
            numunidades=numunidades+(objetos[i].getUnidades());
        }
        return numunidades;
    }
    
   
     
     
     
     
     public Mochila copia(){
     //Devuelve una copia de la mochila    
        Mochila copia = new Mochila();
        copia.peso=peso;
        copia.capacidad=capacidad;
        copia.objetos = new Objeto [getObjetos().length];
        for (int i=0; i< copia.objetos.length; i++){
            copia.objetos[i]=getObjetos()[i].copia();
        }
        return copia;
        }
    
     
     
    public double beneficio(){
    //Devuelve el beneficio total de todos los objetos contenidos en la mochila
        int beneficioTotal=0;
        for (int i=0; i<objetos.length;i++){
            for (int j=0; j<objetos[i].getUnidades();j++){
                beneficioTotal+=objetos[i].getBeneficio();
            }
        }    
        return beneficioTotal;
    }
    
   
    
   
    
    public boolean cabe (Objeto objeto){
    //Devuelve true si el objeto que se pasa como argumento cabe en l amochila y false en caso contrario    
            return capacidad>=peso+objeto.getPeso();
    }
    
    
    
    public int esta (Objeto objeto){
    //Devuelve la posicion donde se ubica el objeto que se le pasa como argumento
    //si este no se encontrase devuelve -1    
        int i=0;
        int posicion=-1;//el objeto no esta
        while (i<getObjetos().length && posicion<0){
            if (getObjetos()[i].equals(objeto)){
                posicion=i;
            }    
            else{
                i++;
            }    
        }
        return posicion;
    }
    
    
    
    public boolean añadir(Objeto objeto){
    //Añade el objeto que se le pasa como argumento a la mochila
    //devuelve true si se añade con exito y false en caso contrario    
        if (cabe(objeto)){ //comprueba que el objeto quepa en la mochila
            int posicion=esta(objeto); //se comprueba si existe en la mochila un objeto del mismo tipo
            if (posicion>=0){ //existe un objeto del mismo tipo en la mochila 
                getObjeto(posicion).incrementar(); //se actualizan las unidades del objeto
            }
            else{ //no existe un objeto del mismo tipo en la mochila 
                Objeto []aux = new Objeto [objetos.length+1];
                for(int i=0; i<objetos.length;i++){
                    aux[i]=objetos[i].copia();
                }
                aux[aux.length-1]=objeto.copia();
                aux[aux.length-1].setUnidades(1);
                objetos=aux;
            }
            peso=peso+objeto.getPeso(); //se actualiza el peso total de la mochila
            return true;
        }//fin if (cabe(objeto))
        else{
            return false; // el objeto no cabe en la mochila
        }
    }
    
    
   
    
   public boolean sacar(Objeto objeto){
   //Saca el objeto que se le pasa como argumento de la mochila
   //devuelve true si se saca con exito y false en caso contrario     
        int posicion=esta(objeto); //se comprueba si existe en la mochila un objeto del mismo tipo
        if (posicion>=0){ //el objeto esta en la mochila
            if (getObjeto(posicion).getUnidades()>=2){ //hay mas de una unidad del objeto
                getObjeto(posicion).decrementar(); //se actualizan las unidades del objeto
            }
            else{ //solo hay una unidad de dicho objeto en la mochila
                Objeto []aux = new Objeto [objetos.length-1];
                for(int i=0; i<posicion;i++){
                    aux[i]=objetos[i].copia();
                }
                for(int i=posicion+1; i<objetos.length;i++){
                    aux[i-1]=objetos[i].copia();
                }
                objetos=aux;
            }
        peso=peso-objeto.getPeso();  //se actualiza el peso total de la mochila     
        return true;    
        } //fin  if (posicion>=0)  
        else{
            return false;//el objeto a sacar no se encontraba en la mochila
        }
   }
   
   
 
    
     public String mostrarMochila(){
     //Devuelve un String con el contenido de la mochila
        StringBuilder contenido =new StringBuilder();
        int cargaTotal=0;
        int gananciaTotal=0;
        for (int i=0; i<numObjetos(); i++){
            contenido.append("El objeto contenido en la posicion " + i + " es de tipo: " + getObjeto(i).toString() );
            contenido.append("\n");
            cargaTotal += getObjeto(i).getPeso();
            gananciaTotal += getObjeto(i).getBeneficio();
        }
	contenido.append("En total, la mochila lleva un total de: "+numUnidades()+" objetos");
        contenido.append("\n");
        contenido.append("  - Carga: " +peso);
        contenido.append("\n");
        contenido.append("  - Ganancias: " + beneficio());
        contenido.append("\n");
	return contenido.toString();
    } 
    
  
}





