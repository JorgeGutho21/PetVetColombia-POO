UNIVERSIDAD POPULAR DEL CESAR
Programación II - Parcial Segundo Corte
Sistema de Gestión Veterinaria PetVet Colombia
Autor: Jorge Alfonso Gutierrez Thomas

1. ANÁLISIS DEL PROBLEMA

PetVet Colombia necesita registrar dueños y mascotas, administrar servicios
veterinarios, agendar o cancelar citas y consultar reportes sencillos.

El programa se construyó con objetos fáciles de explicar: un dueño tiene su
mascota principal, una cita relaciona a ese dueño con un servicio y cada tipo
de servicio sabe calcular su propio precio.

2. ESTRUCTURA POR CAPAS

El proyecto utiliza cuatro capas, manteniendo un Main sencillo para el menú:

- entities: contiene las clases del modelo (Dueno, Servicio, ServicioBasico,
  ServicioEspecializado y Cita). Aquí se ve la herencia y el encapsulamiento.
- repositories: contiene PetVetRepository. Guarda los ArrayList en memoria y
  realiza búsquedas básicas por cédula o código.
- services: contiene PetVetService. Aplica las reglas del parcial: validar,
  registrar, agendar, cancelar, descontar cupos y generar consultas.
- controllers: contiene PetVetController. Recibe las solicitudes del Main y
  las envía al servicio, sin repetir la lógica del negocio.

Main.java es el punto de entrada: muestra el menú, lee los datos digitados y
presenta los resultados que entrega el controlador.

Las entidades también protegen sus propios datos. Así, un setter no permite
dejar un precio en cero, cupos negativos ni estados diferentes a los definidos
en el enunciado.
La cédula y los códigos no tienen setter porque son identificadores únicos:
se asignan al crear el objeto y no deben cambiar después del registro.

3. HERENCIA Y POLIMORFISMO

Servicio es la clase padre abstracta.
ServicioBasico y ServicioEspecializado heredan de Servicio.

Servicio declara el método abstracto:
calcularPrecioFinal()

Las clases hijas lo implementan con @Override:
- ServicioBasico retorna el precio base.
- ServicioEspecializado retorna el precio base más el cargo adicional.

Cuando Cita calcula el total, utiliza el servicio recibido. Por eso funciona
correctamente tanto para un servicio básico como para uno especializado.

4. RELACIONES ENTRE CLASES

- Cita tiene un Dueno.
- Cita tiene un Servicio.
- PetVetRepository almacena ArrayList de Dueno, Servicio y Cita.
- PetVetService utiliza el repositorio para aplicar las reglas del sistema.
- PetVetController utiliza el servicio y Main utiliza el controlador.

5. DIAGRAMA UML EN TEXTO

Servicio (abstracta)
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

             ^                          ^
             |                          |
ServicioBasico                  ServicioEspecializado
--------------------------      -------------------------------
- duracionEstimada: int         - especialidadRequerida: String
- incluyeCertificado: String    - requiereExamenes: String
                                - cargoAdicional: double
--------------------------      -------------------------------
+ calcularPrecioFinal():double  + calcularPrecioFinal():double
+ printData():void              + printData():void

Dueno                          Cita
--------------------------     -------------------------------
- cedula: String               - codigo: String
- nombres: String              - dueno: Dueno
- apellidos: String            - servicio: Servicio
- email: String                - cantidadCupos: int
- telefono: String             - fechaAgendada: String
- direccion: String            - precioTotal: double
- datos de mascota             - estado: String
--------------------------     -------------------------------
+ printData(): void            + printData(): void
+ getters y setters            + getters y setters

PetVetRepository               PetVetService
--------------------------     -------------------------------
- duenos: ArrayList            - repository: PetVetRepository
- servicios: ArrayList         -------------------------------
- citas: ArrayList             + registrarDueno(): String
--------------------------     + registrarServicio...(): String
+ guardar...(): void           + agendarCita(): String
+ buscar...(): objeto          + cancelarCita(): String
+ listar...(): ArrayList       + consultas(): objeto/ArrayList

PetVetController               Main
--------------------------     -------------------------------
- service: PetVetService       - controlador: PetVetController
--------------------------     - sc: Scanner
+ operaciones del sistema      -------------------------------
                               + main(): void
                               + métodos del menú

6. VALIDACIONES IMPLEMENTADAS

- Cédula duplicada: "Ya existe un dueño registrado con esa cédula".
- Email sin @ usando contains(): "El email debe contener el símbolo @".
- Todos los campos obligatorios.
- Edad de mascota mayor o igual a 0.
- Especie de mascota válida: Perro, Gato, Conejo, Ave u Otro.
- Código de servicio único.
- Fecha DD/MM/YYYY y hora HH:MM.
- Respuestas Si/No para certificado y exámenes previos.
- Cupos totales mayores a 0.
- Precio base mayor a 0: "El precio del servicio debe ser mayor a cero".
- Servicio disponible antes de agendar.
- Cupos suficientes: "No hay cupos disponibles para este servicio".
- Máximo 3 cupos: "No se pueden reservar más de 3 cupos por cita".
- Los cupos restantes no quedan negativos ni superan los cupos totales.
- Los setters conservan precios, cupos y estados válidos después del registro.
- Si cambia el servicio o la cantidad de una cita, su precio total se recalcula.
- Código de cita único.
- Cédulas y códigos permanecen fijos después de registrarse.
- Cancelación de cita con devolución de cupos.
- Consulta inexistente: "No se encontró la cita con ese código".
- Listado de citas por cédula del dueño.
- Total de dueños registrados.
- Campos numéricos vacíos muestran "Todos los campos son obligatorios".

7. ESTRUCTURA DEL PROYECTO

src/
  Main.java
  entities/
    Dueno.java
    Servicio.java
    ServicioBasico.java
    ServicioEspecializado.java
    Cita.java
  repositories/
    PetVetRepository.java
  services/
    PetVetService.java
  controllers/
    PetVetController.java

No se entregan archivos .class porque son archivos generados al compilar.
La entrega contiene solamente el código fuente y su documentación.

8. CÓMO EJECUTAR

Abrir el proyecto en IntelliJ IDEA y ejecutar Main.java.

Desde consola se puede compilar en una carpeta de salida:

javac --release 17 -encoding UTF-8 -d build src/Main.java src/entities/*.java src/repositories/*.java src/services/*.java src/controllers/*.java
java -cp build Main

El programa carga los datos de Sofía Morales y el servicio especializado SV050
para probar rápidamente el caso del parcial: agendar C001, cédula 1122334455,
servicio SV050 y 1 cupo produce un total de 430000.
