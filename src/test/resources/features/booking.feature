#language: es

Característica: Reserva tickets

  @Escenario1 @all
  Esquema del escenario: Busqueda de tickets BELMOND ANDEAN EXPLORER RUTA PUNO > CUSCO
    Dado que la web perurail este disponible
    Cuando eliges un tipo de viaje "<tipo_viaje>"
    Y selecciona el destino "<destino>"
    Y selecciona la ruta "<ruta>"
    Y selecciona el tipo de tren "<tipo_tren>"
    Y se ingresa la fecha de salida "<fecha_salida>"
    Y buscar la disponibilidad del ticket
    Y validar el mensaje "<mensaje>" de disponibilidad de cabinas

    Ejemplos:
      | tipo_viaje | destino | ruta         | fecha_salida | tipo_tren                        | mensaje                                   |
      | One Way    | Cusco   | Puno > Cusco | 23-11-2022   | Andean Explorer, A Belmond Train | No cabins available for the selected date |

  @Escenario2 @all
  Esquema del escenario: Busqueda de tickets RUTA Arequipa > Puno > Cusco
    Dado que la web perurail este disponible
    Cuando eliges un tipo de viaje "<tipo_viaje>"
    Y selecciona el destino "<destino>"
    Y selecciona la ruta "<ruta>"
    Y se ingresa la fecha de salida "<fecha_salida>"
    Y buscar la disponibilidad del ticket
    Y seleccionar el número de cabinas "<nro_cabina>" del tipo de cabina "<tipo_cabina>"
    Y seleccionar la cantidad "<cantidad_adultos>" de pasajeros adultos
    Y seleccionar la cantidad "<cantidad_niños>" de pasajeros niños
    Y validar que el monto a pagar sea el mismo del resumen de compra
    Y continuar con la compra
    E ingresar los datos de los pasajeros
      | nombre    | apellido | fecha_nacimiento  | nacionalidad | tipo_documento      | nro_documento | genero    | telefono     | email               | promociones |
      | Katherine | Mori     | 17-8-1989         | Peru         | Identification Card | 46165456      | Female   | +51989081094 | kmori1708@gmail.com | si          |
      | Renzo     | Loayza   | 22-8-1988         | Peru         | Identification Card | 49495454      | Male     | +51989081094 | kmori1708@gmail.com | si          |
    Y continuar con el pago de los tickets
    Y elegir el medio de pago "<medio_pago>"
    Y aceptar los terminos y condiciones
    Y dar click a la opción de ingresar número de tarjeta

    Ejemplos:
      | tipo_viaje | destino | ruta                    | fecha_salida | nro_cabina | tipo_cabina     | cantidad_adultos | cantidad_niños | medio_pago |
      | One Way    | Cusco   | Arequipa > Puno > Cusco | 21-05-2022   | 1          | TWIN BED CABINS | 2                | 0              | visa       |
      | One Way    | Cusco   | Arequipa > Puno > Cusco | 21-05-2022   | 1          | SUITE CABINS    | 2                | 0              | visa       |
      | One Way    | Cusco   | Arequipa > Puno > Cusco | 21-05-2022   | 1          | BUNK BED CABINS | 2                | 0              | visa       |

