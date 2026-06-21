@metro
Feature: MetroCarlay

  @metrogas
  Scenario: Iniciar sesion en Metrogas
    Given estoy en la pagina inicial de Metrogas
    And cierro el modal informativo
    And hago click en soy usuario
    And ingreso usuario "carlayblanco@gmail.com"
    And ingreso clave "1234"
    When hago clic en el boton login
    Then valido el mensaje "Este usuario no está registrado en la nueva Sucursal Virtual de Metrogas, para registrarlo, debes dirigirte a: Soy nuevo y no tengo usuario."
