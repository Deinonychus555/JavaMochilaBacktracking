/*********************************************************************
Nombre: Samuel Martín Gómez-Calcerrada
Expediente/titulación: 280/GIS
Nombre: Juan Antonio Echeverrías Aranda
Expediente/titulación: 289/GIS
********************************************************************/

package algoritmo;


public class Algoritmo {
    
    static Objeto[] inventario;
    // variable global donde la función 'calcular' dejará depositada la mochila con los objetos que componen el beneficio óptimo
	static Mochila optima = null;	
    static int capacidad = 150;

	public static void main(String args[]){
            
		// El contenido de este array es modificable para poder probar distintos escenarios del problema
		
        inventario=new Objeto[10];
        inventario[0]=new Objeto("banana",	50,	1000,	3);
		inventario[1]=new Objeto("patata",	35,	700, 	7);
		inventario[2]=new Objeto("piña",	78,	2000, 	1);
		inventario[3]=new Objeto("pepino",	58,	1400, 	4);
		inventario[4]=new Objeto("tomate",	28,	1100, 	2);
		inventario[5]=new Objeto("calabacin",	32,	600, 	6);
		inventario[6]=new Objeto("manzana",	10,	350, 	3);
		inventario[7]=new Objeto("berenjena",	9,	280, 	2);
		inventario[8]=new Objeto("apio",	24,	650, 	2);
		inventario[9]=new Objeto("naranja",	80,	800, 	1);
               
		
		
	
		// Variables para resultados del inventario
		int cargaTotal = 0;
		int gananciaTotal = 0;
                
	    
        //Mostramos por consola el contenido del inventario        

        System.out.println("CONTENIDO DEL INVENTARIO:");
        for(int i=0; i<inventario.length;i++){
                 System.out.println(inventario[i].toString()); 
                 cargaTotal=cargaTotal+inventario[i].getPeso()*inventario[i].getUnidades();
                 gananciaTotal=gananciaTotal+inventario[i].getBeneficio();
               }  
        System.out.println("  - Carga total: "+cargaTotal);
        System.out.println("  - Beneficio total: "+gananciaTotal);
        System.out.println();                    

        //Calculamos la mochila optima con 'calcular' y mostramos su contenido por consola
        System.out.println("CONTENIDO ÓPTIMO DE LA MOCHILA:");
        optima=new Mochila(capacidad);
        calcular(new Mochila (capacidad));
        System.out.println(optima.mostrarMochila());                     
    }// fin metodo main

           
    public static void calcular ( Mochila mochila){
        for (int i=0; i<inventario.length;i++){
			if (inventario[i].getUnidades()!=0 && mochila.cabe(inventario[i])){
				mochila.añadir(inventario[i]);
                inventario[i].decrementar();
                if   ( ((i==inventario.length-1)&&inventario[i].getUnidades()==0) || (!mochila.cabe(inventario[i]) &&inventario[i].getUnidades()!=0) ){
					if (mochila.beneficio()>optima.beneficio()){
						optima=mochila.copia();
                    }
                }    
                else{
                    calcular(mochila );
                }
            mochila.sacar(inventario[i]);
            inventario[i].incrementar(); 
            }//if (mochila.cabe(inventario[i]))
        }//fin for inventario.length
    }// fin backtracking        
            
        
            
}