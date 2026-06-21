@cine
Feature: Cineplanet

  @toy
  Scenario: Seleccionar pelicula toystory
    Given estoy en la pagina inicial de Cineplanet
    And cierro el modal de compra
    And hago click en la combo pelicula
    And selecciono Toy Story 5
    When selecciono el boton filtrar
    Then verifico que se muestre el texto "Sinopsis."
