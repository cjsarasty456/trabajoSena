<?php
define('__ROOT__', dirname(dirname(__FILE__)));
require_once __ROOT__ . "/model/productos.php";
require_once __ROOT__ . "/config/conexion.php";

class productosController
{

    public $estado;
    public $mensaje;

    function consultarListaProductos()
    {
        $filtro = "";
        if (isset($_GET["filtro"])) {
            $filtro = $_GET["filtro"];
        }
        try {
            $conexion = new conexion();
            //Se establececonexion con la base de datos
            $conn = $conexion->getConexion();
            //Se prepara la consulta SQL
            $sql = "SELECT *
            FROM productos";

            if ($filtro != "") {
                $sql .= " WHERE 
                nombre='$filtro' OR
                descripcion='$filtro' OR
                precio='$filtro' OR
                cantidad='$filtro'
                ";
            }
            $resultado = $conn->prepare(
                $sql
            );
            //Se ejecuta la consulta
            $resultado->execute();
            //Se recorre el arreglo

            $listaProductos = [];
            foreach ($resultado as $registro) {
                $producto = new productos();
                $producto->id = $registro['id'];
                $producto->nombre = $registro['nombre'];
                $producto->descripcion = $registro['descripcion'];
                $producto->precio = $registro['precio'];
                $producto->cantidad = $registro['cantidad'];
                $producto->imagen = $registro['imagen'];

                array_push($listaProductos, $producto);
            }

            echo json_encode(
                array(
                    "estatus" => "success",
                    "data" => $listaProductos
                )
            );

            //Se retorna el resultado
            $conexion->closeConexion();
            return $resultado->fetchAll();
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
            echo json_encode(
                array(
                    "estatus" => "danger",
                    "message" => "error al consultar " . $e->getMessage()
                )
            );
        }
    }
    function consultarProductoPorCodigo()
    {
        $filtro = "";
        $id = $_GET["id"];
        try {
            $conexion = new conexion();
            //Se establececonexion con la base de datos
            $conn = $conexion->getConexion();
            //Se prepara la consulta SQL
            $sql = "SELECT *
            FROM productos WHERE id=$id";


            $resultado = $conn->prepare(
                $sql
            );
            //Se ejecuta la consulta
            $resultado->execute();
            //Se recorre el arreglo

            $listaProductos = [];
            foreach ($resultado as $registro) {
                $producto = new productos();
                $producto->id = $registro['id'];
                $producto->nombre = $registro['nombre'];
                $producto->descripcion = $registro['descripcion'];
                $producto->precio = $registro['precio'];
                $producto->cantidad = $registro['cantidad'];
                $producto->imagen = $registro['imagen'];

                array_push($listaProductos, $producto);
            }

            echo json_encode(
                array(
                    "estatus" => "success",
                    "data" => $listaProductos
                )
            );

            //Se retorna el resultado
            $conexion->closeConexion();
            return $resultado->fetchAll();
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
            echo json_encode(
                array(
                    "estatus" => "danger",
                    "message" => "error al consultar " . $e->getMessage()
                )
            );
        }
    }
    function guardarProducto()
    {
        try {
            $conexion = new conexion();
            //Se establececonexion con la base de datos
            $conn = $conexion->getConexion();
            //reciben los datos
            $producto = new productos();
            $producto->id = $_REQUEST['id'];
            $producto->nombre = $_REQUEST['nombre'];
            $producto->descripcion = $_REQUEST['descripcion'];
            $producto->precio = $_REQUEST['precio'];
            $producto->cantidad = $_REQUEST['cantidad'];
            $producto->imagen = $_REQUEST['imagen'];


            if ($producto->id == 0) {

                //Se prepara la consulta SQL
                $sql =
                    "INSERT INTO productos (
                            nombre, 
                            descripcion,
                            precio,
                            cantidad,
                            imagen
                        )
                        VALUES (
                            '$producto->nombre',
                            '$producto->descripcion',
                            $producto->precio,  
                            $producto->cantidad,  
                            '$producto->imagen'
                            )";
                //Se ejecuta la consulta
                $conn->exec($sql);
                //echo "New record created successfully";
                $conexion->closeConexion();
                //Se retorna el resultado
                $this->estado = "success";
                $this->mensaje = "Se guardó correctamente";
            } else {
                //se actualiza el registro
                //Se prepara la consulta SQL
                $sql =
                    "UPDATE productos SET 
                            nombre='$producto->nombre', 
                            descripcion='$producto->descripcion',
                            precio=$producto->precio,
                            cantidad=$producto->cantidad,
                            imagen='$producto->imagen'
                        WHERE 
                        id=$producto->id
                        ";
                //Se ejecuta la consulta
                $conn->exec($sql);
                //echo "New record created successfully";
                $conexion->closeConexion();
                //Se retorna el resultado
                $this->estado = "success";
                $this->mensaje = "Se Actualizó correctamente";
            }
        } catch (PDOException $e) {
            $this->estado = "danger";
            $this->mensaje = "error al guardar " . $e->getMessage();
        }
        echo json_encode(
            array(
                "estado" => $this->estado,
                "mensaje" => $this->mensaje
            )
        );
    }
    function eliminarProducto()
    {
        try {
            $conexion = new conexion();
            //Se establececonexion con la base de datos
            $conn = $conexion->getConexion();
            //reciben los datos
            $producto = new productos();
            $producto->id = $_REQUEST['id'];
            //Se prepara la consulta SQL
            $sql =
                "DELETE FROM productos
                        WHERE 
                        id=$producto->id
                        ";
            //Se ejecuta la consulta
            $conn->exec($sql);
            //echo "New record created successfully";
            $conexion->closeConexion();
            //Se retorna el resultado
            $this->estado = "success";
            $this->mensaje = "Se eliminó correctamente el producto";
        } catch (PDOException $e) {
            $this->estado = "danger";
            $this->mensaje = "error al eliminar " . $e->getMessage();
        }
        echo json_encode(
            array(
                "estado" => $this->estado,
                "mensaje" => $this->mensaje
            )
        );
    }
}

if (isset($_REQUEST['function'])) {
    $function = $_REQUEST['function'];
    $productosController = new productosController();
    if ($function == "consultarListaProductos") {
        $productosController->consultarListaProductos();
    }
    if ($function == "guardarProducto") {
        $productosController->guardarProducto();
    }
    if ($function == "consultarProductoPorCodigo") {
        $productosController->consultarProductoPorCodigo();
    }
    if ($function == "eliminarProducto") {
        $productosController->eliminarProducto();
    }
}
