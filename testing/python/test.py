import unittest
import program

# Definimos una clase de prueba que hereda de unittest.TestCase
class TestSuma(unittest.TestCase):
    
    # Se define el método para realizar el test
    def test_suma(self):
        #primera prueba, si el método realiza la suma de dos números
        #Sí se ingresa 2 y 3, el valor esperado debe ser 5
        self.assertEqual(program.suma(2, 3), 5,"primera suma fallo")  # Aseguramos que suma(2, 3) sea igual a 5
        self.assertEqual(program.suma(-1, 1), 0,"segunda suma fallo")  # Aseguramos que suma(-1, 1) sea igual a 0
        self.assertEqual(program.suma(0, 0), 0,"tercera suma fallo")    # Aseguramos que suma(0, 0) sea igual a 0

    def test_multiplicar(self):
        self.assertEqual(program.multiplicar(2,2),4,"Error al multiplicar primera")
        self.assertEqual(program.multiplicar(2,3),6,"Error al multiplicar segunda")
        self.assertEqual(program.multiplicar(4,1),4,"Error al multiplicar tercera")

# Si ejecutamos este script directamente, ejecutará las pruebas
if __name__ == '__main__':
    unittest.main()