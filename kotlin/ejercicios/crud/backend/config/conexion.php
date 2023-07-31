<?php
    class conexion{
        private $servername = "localhost";
        private $dbname = "id21094634_tiendaadso";
        //private $dbname = "consultorio";
        private $username = "id21094634_carlos";
        private $password = "Carlos123,";
        private $conn = "";
        
        function getConexion()
        {
        try {
        $this->conn = new PDO(
            "mysql:host=$this->servername;
            dbname=$this->dbname",
            $this->username,
            $this->password
        );
            // set the PDO error mode to exception
            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            //echo "Connected successfully";
            return $this->conn;
        } catch(PDOException $e) {
            echo "Connection failed: " . $e->getMessage();
            return null;
            }
        }
        function closeConexion(){
            $this->conn=null;
            //echo "Se cerró la conexión.";
        }
    }
    /*
    $conexion=new conexion();
    $conexion->getConexion();
    $conexion->closeConexion();
    */
?>