//imports
import React, { useEffect, useState, useCallback } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  RefreshControl,
  TouchableOpacity,
} from "react-native";

//importaciones objetos internos
//importación para consultar los libros
import { getAllBook } from "../api/booksApi";
//importación para el objeto book
import { IBook } from "../api/types/IBook";
//importación para traer las tarjetas de libros
import BookCard from "./../components/BookCard";
//importaciones para la navegación
import { useFocusEffect, useNavigation } from "@react-navigation/native";

import { BookStackParamsList } from "../navigations/types";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";

//objeto tipado para la navegación y los parametros
type BookScreenNavigationProp = NativeStackNavigationProp<
  BookStackParamsList,
  "ListBook"
>;

//componente principal
const BookList: React.FC = () => {
  //creación objeto de navegación con el tipado y parametro
  const navigation = useNavigation<BookScreenNavigationProp>();
  //se crea el objeto que almacena la lista de libros y configura
  //la actualización de lista cuando se consulta
  const [books, setBooks] = useState<IBook[]>([]);
  //configuración para generar el refesh haciendo scroll hacia abajo
  const [refreshing, setRefreshing] = useState(false);

  //método que solicita la información de los libros y actualiza el objeto de libros
  const fetchBooks = async () => {
    try {
      const data = await getAllBook();
      setBooks(data);
    } catch (error) {
      console.error("Error al obtener libros:", error);
    }
  };
  //leer: https://react.dev/reference/react/useEffect
  /*
  useEffect es un hook de React que te permite ejecutar lógica secundaria (efectos) 
  después de que el componente se renderiza. Es útil para:

Llamar APIs

Suscribirse a eventos

Iniciar intervalos o temporizadores

Manipular el DOM (en React web)

Cualquier acción que no deba ejecutarse en cada render
  */
  useEffect(() => {
    fetchBooks();
  }, []);

  useFocusEffect(
    useCallback(() => {
      const intervalId = setInterval(() => {
        fetchBooks();
      }, 5000);

      return () => {
        clearInterval(intervalId);
      };
    }, [])
  );

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await fetchBooks();
    setRefreshing(false);
  }, []);

  return (
    <ScrollView
      contentContainerStyle={styles.container}
      refreshControl={
        <RefreshControl refreshing={refreshing} onRefresh={onRefresh} />
      }
    >
      <TouchableOpacity
        style={styles.touch}
        onPress={() => navigation.navigate("AddBook")}
      >
        <Text>Add Book</Text>
      </TouchableOpacity>
      {books.length === 0 ? (
        <View style={styles.center}>
          <Text>No hay libros disponibles.</Text>
        </View>
      ) : (
        books.map((book) => <BookCard key={book.id_book} data={book} />)
      )}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    paddingVertical: 10,
  },
  center: {
    alignItems: "center",
    justifyContent: "center",
    marginTop: 20,
  },
  touch: {
    margin: 5,
    backgroundColor: "#1e90ff", // azul tipo botón
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 10,
    alignItems: "center",
    justifyContent: "center",
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.3,
    shadowRadius: 3,
    elevation: 5, // sombra en Android
    width: 150,
  },
});

export default BookList;
