UNIVERSIDAD POPULAR DEL CESAR
Programación II - Parcial Segundo Corte
Sistema de Gestión Veterinaria PetVet Colombia
Autor: Jorge Alfonso Gutierrez Thomas

1. ANALISIS DEL PROBLEMA

El sistema permite administrar dueños, servicios veterinarios y citas.
La información se guarda en memoria usando ArrayList, tal como pide la rúbrica.

Clases principales:
- Dueno: guarda la información del dueño y su mascota principal.
- Servicio: clase padre abstracta para los servicios veterinarios.
- ServicioBasico: clase hija de Servicio.
- ServicioEspecializado: clase hija de Servicio.
- Cita: relaciona un dueño con un servicio y calcula el total.
- Main: contiene el menú, los ArrayList y la lógica del sistema.

2. HERENCIA

Servicio es la clase padre abstracta.
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

Esto representa que un dueño agenda una cita para que su mascota reciba un servicio.
El precio de la cita se calcula usando el método polimórfico calcularPrecioFinal()
del servicio que se haya escogido.

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

- Cédula duplicada: "Ya existe un dueño registrado con esa cédula".
- Email sin @ usando contains().
- Campos obligatorios.
- Edad de mascota mayor o igual a 0.
- Código de servicio único.
- Cupos totales mayor a 0.
- Precio base mayor a 0: "El precio del servicio debe ser mayor a cero".
- Servicio disponible antes de agendar.
- Cupos suficientes: "No hay cupos disponibles para este servicio".
- Máximo 3 cupos: "No se pueden reservar más de 3 cupos por cita".
- Los cupos restantes nunca pueden quedar negativos ni superar los cupos totales.
- Código de cita único.
- Cancelación de cita con devolución de cupos.
- Consulta de cita por código: "No se encontró la cita con ese código".
- Listado de citas por cédula del dueño.
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

El programa carga los datos de Sofía Morales, el servicio especializado SV050
y un servicio básico para poder demostrar rápidamente los casos del enunciado.
Para probar la cita solicitada se puede escoger la opción 4, usar el código C001,
la cédula 1122334455, el servicio SV050 y reservar 1 cupo.
