UNIVERSIDAD POPULAR DEL CESAR
Programacion II - Parcial Segundo Corte
Sistema de Gestion Veterinaria PetVet Colombia
Autor: Jorge Alfonso Gutierrez Thomas

1. ANALISIS DEL PROBLEMA

El sistema permite administrar dueños, servicios veterinarios y citas.
La informacion se guarda en memoria usando ArrayList, tal como pide la rubrica.

Clases principales:
- Dueno: guarda la informacion del dueño y su mascota principal.
- Servicio: clase padre abstracta para los servicios veterinarios.
- ServicioBasico: clase hija de Servicio.
- ServicioEspecializado: clase hija de Servicio.
- Cita: relaciona un dueño con un servicio y calcula el total.
- Main: contiene el menu, los ArrayList y la logica del sistema.

2. HERENCIA

Servicio es la clase padre.
ServicioBasico y ServicioEspecializado heredan de Servicio.

La clase Servicio tiene el metodo abstracto:
calcularPrecioFinal()

Cada clase hija implementa ese metodo con @Override:
- ServicioBasico: retorna precio base.
- ServicioEspecializado: retorna precio base + cargo adicional.

3. RELACIONES ENTRE CLASES

Una Cita tiene:
- un Dueno
- un Servicio

Esto representa que un dueño agenda una cita para un servicio.

4. DIAGRAMA UML EN TEXTO

                 Servicio (abstract)
------------------------------------------------
- codigo: String
- nombre: String
- descripcion: String
- fechaDisponibilidad: String
- horaInicio: String
- horaFin: String
- cuposTotales: int
- cuposRestantes: int
- precioBase: double
- estado: String
------------------------------------------------
+ calcularPrecioFinal(): double
+ printData(): void
+ descontarCupos(cantidad:int): void
+ devolverCupos(cantidad:int): void
+ getters y setters

          ^                              ^
          |                              |
ServicioBasico                  ServicioEspecializado
--------------------------      -------------------------------
- duracionEstimada: int         - especialidadRequerida: String
- incluyeCertificado: String    - requiereExamenes: String
                                - cargoAdicional: double
--------------------------      -------------------------------
+ calcularPrecioFinal():double  + calcularPrecioFinal():double
+ printData():void              + printData():void


Dueno
------------------------------------------------
- cedula: String
- nombres: String
- apellidos: String
- email: String
- telefono: String
- direccion: String
- nombreMascota: String
- especieMascota: String
- razaMascota: String
- edadMascota: int
------------------------------------------------
+ printData(): void
+ getters y setters


Cita
------------------------------------------------
- codigo: String
- dueno: Dueno
- servicio: Servicio
- cantidadCupos: int
- fechaAgendada: String
- precioTotal: double
- estado: String
------------------------------------------------
+ printData(): void
+ getters y setters


Main
------------------------------------------------
- duenos: ArrayList<Dueno>
- servicios: ArrayList<Servicio>
- citas: ArrayList<Cita>
------------------------------------------------
+ registrarDueno(): void
+ registrarServicioBasico(): void
+ registrarServicioEspecializado(): void
+ agendarCita(): void
+ cancelarCita(): void
+ consultarCita(): void
+ listarCitasPorDueno(): void
+ buscarDueno(): Dueno
+ buscarServicio(): Servicio
+ buscarCita(): Cita

5. VALIDACIONES IMPLEMENTADAS

- Cedula duplicada.
- Email sin @ usando contains().
- Campos obligatorios.
- Edad de mascota mayor o igual a 0.
- Codigo de servicio unico.
- Cupos totales mayor a 0.
- Precio base mayor a 0.
- Servicio disponible antes de agendar.
- Cupos suficientes.
- Cita entre 1 y 3 cupos.
- Codigo de cita unico.
- Cancelacion de cita con devolucion de cupos.
- Consulta de cita por codigo.
- Listado de citas por cedula del dueño.
- Total de dueños registrados.

6. COMO EJECUTAR

Abrir el proyecto en IntelliJ IDEA.
Verificar que la carpeta src tenga:
- Main.java
- entities/Dueno.java
- entities/Servicio.java
- entities/ServicioBasico.java
- entities/ServicioEspecializado.java
- entities/Cita.java

Ejecutar Main.java.
