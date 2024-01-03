<?php

class productos
{
    public $id;
    public $nombre;
    public $descripcion;
    public $precio;
    public $cantidad;
    public $imagen;

    function __construct()
    {
    }
    public function __get($property)
    {
        if (property_exists($this, $property)) {
            return $this->$property;
        }
    }

    public function __set($property, $value)
    {
        if (property_exists($this, $property)) {
            $this->$property = $value;
        }

        return $this;
    }
}
