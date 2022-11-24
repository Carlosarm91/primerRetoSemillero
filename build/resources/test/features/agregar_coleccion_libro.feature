#language: es
#Author: carlos.sarmiento@sqasa.co

  Característica: Agregar libro a coleccion
    Yo como usuario, realizó la búsqueda de un libro en la página de demoqa/books
    válido que sea el libro que busco
    y lo agrego a mi colección.

    Antecedentes:
      Dado que ingreso a la pagina de demoqa books
      Cuando hago login en esta
      Entonces valido que este logueado

    @TAG_1 @All
    Esquema del escenario: Agregar libro a coleccion de forma exitosa
      Dado que realizo la busqueda de un libro
        |<libro>|
      Y despliego su informacion
        |<libro>|
      Cuando agrego el libro a la coleccion
      Y valido el mensaje de agregado "<mensaje>"
      Entonces valido que el libro se haya agregado "<libro>"

      Ejemplos:
        |libro| mensaje|
        |Speaking JavaScript|Book added to your collection.|

    @TAG_2 @All
    Escenario: Elimino los libros presentes en la collecion
      Dado que realizo la limpieza de la coleccion

    @TAG_3 @All
    Esquema del escenario: Busqueda libro no existente
      Dado que realizo la busqueda de un libro
        |<libro>|
      Entonces valido que no arroje resultados
      Ejemplos:
        |libro|
        |Soccer|