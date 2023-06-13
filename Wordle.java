import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String palabraSecreta;
		String respuesta="";
		char letraSecreta;
		char letraRespuesta;
		String verde="\033[32m";
		String amarillo="\033[33m";
		String rojo="\033[30m";
		String blanco="\033[37m";
		int intentos=0;
		int aciertos=0;
		
		
		Scanner lector=new Scanner(System.in);
		
		palabraSecreta=BancoPalabras();
		
		do {
				do {
					System.out.print("Introduzca su intento.");
					respuesta=lector.nextLine();
					
					if(respuesta.length()>5) {
						System.out.println("La palabra no puede contener ni numeros ni mas de 5 letras.");
					}else {
						intentos++;
					}
				}while(respuesta.length()>5);
				
				for (int i = 0; i < 5; i++) {
					
					letraSecreta=palabraSecreta.charAt(i);
					letraRespuesta=respuesta.charAt(i);
		            if(letraSecreta==letraRespuesta) {
		                System.out.print(verde+letraRespuesta);
		                aciertos++;
		            }else {
		                if(palabraSecreta.indexOf(letraRespuesta)!=-1) {
		                    System.out.print(amarillo+letraRespuesta);
		                    aciertos=0;
		                }else {
		                    System.out.print(rojo+letraRespuesta);
		                    aciertos=0;
		                }
		            }
		        }
				System.out.println(blanco+"");
		}while(intentos<5 && aciertos<5);	
		;
		
		if(aciertos==5) {
			System.out.println("Correcto");
		}else {
			System.out.println("Se acabo, la palabra era "+palabraSecreta);
		}
	}

	public static String BancoPalabras() {
		
		String resultado;
		
		ArrayList<String> banco= new ArrayList<String>();
		
		banco.add("botin");
		banco.add("jarra");
		banco.add("perla");
		banco.add("boton");
		banco.add("balon");
		banco.add("kebab");
		banco.add("talar");
		banco.add("poker");
		banco.add("salon");
		banco.add("norte");
		banco.add("remar");
		
		resultado=banco.get((int) (Math.random() * banco.size()));
		
		return resultado;
	}
}

