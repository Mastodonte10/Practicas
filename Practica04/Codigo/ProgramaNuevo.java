public class ProgramaNuevo{
public static void main(String[] args)
{

//Primero usa string para ponerle nombre a laptop
String producto = "Laptop para la carrera";
//Como no existen laptops que cuesten lo mismo que una isla privada basta usar int para poner el precio y el descuento  
int precio = 15000;
int descuento = 3000;
//Despues guarda la cantidad de meses en decimal para que salga preciso
double meses = 18.0;

// Luego a base de puros print lines escribe 

//La ficha de compra
System.out.println("=== Ficha de compra ===");

// El nombre del producto
System.out.println("- Producto : " + producto);

// El precio final restando el descuento al precio original
System.out.println("- Precio con descuento : " + (precio - descuento));

// Convierte los meses a años dividiendo entre 12.0 e imprime el plazo 
System.out.println("- Plazo de pago en anios : " + (meses / 12.0));

// Calcula e imprime el costo mensual dividiendo el precio con descuento entre los meses
System.out.println("- Pago mensual : " + ((precio - descuento) / meses));

// Imprime la línea final de la ficha
System.out.println("=== Fin de la ficha ===");
}
}


