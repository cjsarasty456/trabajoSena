// components/BookList.tsx
import React, { useEffect, useState, useCallback } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  RefreshControl,
  TouchableOpacity,
} from "react-native";
import { getAllBook } from "../api/booksApi";
import { IBook } from "../api/types/IBook";
import BookCard from "./../components/BookCard";

import { useNavigation } from "@react-navigation/native";

import { BookStackParamsList } from "../navigations/types";
import { NativeStackNavigationProp } from "@react-navigation/native-stack";

type BookScreenNavigationProp = NativeStackNavigationProp<
  BookStackParamsList,
  "ListBook"
>;

const BookList: React.FC = () => {
  const navigation = useNavigation<BookScreenNavigationProp>();
  const [books, setBooks] = useState<IBook[]>([]);
  const [refreshing, setRefreshing] = useState(false);

  const fetchBooks = async () => {
    try {
      const data = await getAllBook();
      setBooks(data);
    } catch (error) {
      console.error("Error al obtener libros:", error);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

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
