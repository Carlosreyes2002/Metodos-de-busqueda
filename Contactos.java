import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Contactos {

    private static ArrayList<Contacto> listaDeContactos = new ArrayList<>();

    public static void main(String[] args) {
        // Aqui agragamos los contactos 
        agregarContacto(new Contacto("Juan", "555-1234"));
        agregarContacto(new Contacto("Ana", "555-5678"));
        agregarContacto(new Contacto("Carlos", "555-8765"));
        agregarContacto(new Contacto("Maria", "555-4321"));
        agregarContacto(new Contacto("Jose", "555-7890"));

        Collections.sort(listaDeContactos);

        System.out.println("Lista de contactos:");
        for (Contacto contacto : listaDeContactos) {
            System.out.println(contacto);
        }

        // Aqui declaramos que cotacto buscar
        buscarContactoSecuencial("Ana");
        buscarContactoBinaria("MAria");
    }

    private static void agregarContacto(Contacto contacto) {
        listaDeContactos.add(contacto);
    }

    private static void buscarContactoSecuencial(String nombre) {
        System.out.println("\nBúsqueda Secuencial:");
        for (Contacto contacto : listaDeContactos) {
            if (contacto.getNombre().equals(nombre)) {
                System.out.println("Contacto encontrado: " + contacto);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    private static void buscarContactoBinaria(String nombre) {
        System.out.println("\nBúsqueda Binaria:");
        int indice = busquedaBinaria(nombre);
        if (indice != -1) {
            System.out.println("Contacto encontrado: " + listaDeContactos.get(indice));
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static int busquedaBinaria(String nombre) {
        int inicio = 0;
        int fin = listaDeContactos.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = listaDeContactos.get(medio).getNombre().compareTo(nombre);

            if (comparacion == 0) {
                return medio; 
            } else if (comparacion < 0) {
                inicio = medio + 1; 
            } else {
                fin = medio - 1; 
            }
        }

        return -1; 
    }

    static class Contacto implements Comparable<Contacto> {
        private String nombre;
        private String telefono;

        public Contacto(String nombre, String telefono) {
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public int compareTo(Contacto otroContacto) {
            return this.nombre.compareTo(otroContacto.nombre);
        }

        @Override
        public String toString() {
            return nombre + ": " + telefono;
        }
    }
}
