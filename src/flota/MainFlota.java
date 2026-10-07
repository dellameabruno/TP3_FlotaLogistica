package flota;

public class MainFlota {

    public static void main(String[] args) {

        Vehiculo[] flota = new Vehiculo[3];
        flota[0] = new Camion("AA123BB", "Scania", 450.0, 18.0);
        flota[1] = new Furgoneta("AF456CD", "Mercedes-Benz", 450.0, true);
        flota[2] = new MotoEnvios("A099XYZ", "Honda", 180.0);

        double distanciaViaje = 150.0;
        double costoTotal = 0.0;

        System.out.println("=== Reporte de Operaciones de Flota ===");

        // Recorrido polimórfico: Java despacha en tiempo de ejecución la
        // versión de calcularCostoViaje() y mostrarFicha() que corresponde
        // al tipo real de cada objeto guardado en el Heap.
        for (Vehiculo v : flota) {
            v.mostrarFicha();
            double costoViaje = v.calcularCostoViaje(distanciaViaje);
            System.out.println("Costo de viaje (" + distanciaViaje + " km): $" + costoViaje);
            costoTotal += costoViaje;
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Costo total operativo de la flota: $" + costoTotal);

        // Demostración de la sobrecarga: misma firma de nombre, distinta
        // cantidad de parámetros, resuelta en tiempo de compilación.
        double costoConPeajes = flota[0].calcularCostoViaje(distanciaViaje, 3500.0);
        System.out.println();
        System.out.println("Costo del camión incluyendo $3500.0 de peajes: $" + costoConPeajes);
    }
}